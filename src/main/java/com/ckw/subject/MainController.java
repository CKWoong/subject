package com.ckw.subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping("/main")
	public String main() {
		return "main";
	}

	//선택 정렬
	@RequestMapping("/selection")
	public String SelectionSort(@RequestParam("select") String str, Model model) {

		String[] arr = str.split(" "); // 공백을 기준으로 입력된 숫자를 배열로 나눔
		int[] num = new int[arr.length]; // String으로 입력된 배열을 int로 하나씩 형 변환
		for (int i = 0; i < arr.length; i++) {
			num[i] = Integer.parseInt(arr[i]);
		}

		int tempValue = 0;
		int tempJ = 0;
		for (int i = 0; i < num.length; i++) { // 배열 처음부터 끝까지 반복 (i는 현재 위치)
			int min = Integer.MAX_VALUE; // 제일 작은 수를 찾기 위해, min은 Integer의 최대 값으로 임시 세팅
			for (int j = i; j < num.length; j++) {
				if (num[j] < min) { // 현재 위치부터 배열 마지막까지 반복문 돌면서 최소 값을 계속 찾음
					min = num[j];
					tempJ = j;
				}
			}
			tempValue = num[i]; // 찾은 최소값과 현재 위치의 값과 서로 바꿈
			num[i] = num[tempJ];
			num[tempJ] = tempValue;
		}
		// json 형태로 출력
		JSONObject selection_json = new JSONObject();
		selection_json.put("선택정렬 결과 ", num);
		model.addAttribute("selection_json", selection_json);

		return "Q01/SelectionSort";
	}

	//버블 정렬
	@RequestMapping("/bubble")
	public String BubbleSort(@RequestParam("bubb") String str, Model model) {

		String[] arr = str.split(" ");
		int[] num = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			num[i] = Integer.parseInt(arr[i]);
		}
		int tempValue;
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length - i - 1; j++) {
				if (num[j] > num[j + 1]) { // 바로 오른쪽 숫자와 비교하여 크기가 클 경우, 서로 위치를 바꿈
					tempValue = num[j];
					num[j] = num[j + 1];
					num[j + 1] = tempValue;
				}
			}
		}
		JSONObject bubble_json = new JSONObject();
		bubble_json.put("버블정렬 결과 ", num);
		model.addAttribute("bubble_json", bubble_json);

		return "Q01/BubbleSort";
	}

	//삽입 정렬
	@RequestMapping("/insertion")
	public String InsertionSort(@RequestParam("insert") String str, Model model) {
		// 형변환
		String[] arr = str.split(" ");
		int[] num = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			num[i] = Integer.parseInt(arr[i]);
		}
		
		int tempValue;
		int target;
		for (int i = 1; i < num.length; i++) {
			tempValue = num[i]; // 선택된 숫자를 임시 저장
			target = i - 1; // 비교 대상의 위치
			while (target >= 0 && num[target] > tempValue) {
				num[target + 1] = num[target]; // tempValue보다 큰 수는 오른쪽으로 한칸 이동
				target--; // 그 다음 비교대상을 왼쪽으로 한 칸 이동
			}
			num[target + 1] = tempValue; // 적정한 위치를 찾아 tempValue를 삽입
		}
		JSONObject insert_json = new JSONObject();
		insert_json.put("삽입정렬 결과 ", num);
		model.addAttribute("insert_json", insert_json);

		return "Q01/InsertionSort";
	}

	//2번 문제
	@RequestMapping("/question02")
	public String question02(@RequestParam("Q02") String str, Model model) {

		String[] arr = str.split(" ");
		ArrayList list = new ArrayList(); // 결과값으로 배수를 받기 위해 ArrayList 설정(개수를 모르기 때문)

		int[] num = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			num[i] = Integer.parseInt(arr[i]);
		}
		
		for (int i : num) {			
			for (int j = 1; j < 10; j++) {
				ArrayList tempValue = new ArrayList(); // 결과로 나올 배수에 부합하는 입력값 임시 저장
				for (int k = 0; k < arr.length; k++) {
					if ((i * j) % (num[k]) == 0) { // 배수 확인
						tempValue.add(arr[k]);
					}
				}
				if (tempValue.size() >= 3) {  // 적어도 3개 이상의 배수 조건 성립 시 list에 추가
					list.add(i * j);
				}
			}
		}
		Collections.sort(list); // 최소값을 찾기위해 오름차순 정렬 
		
		JSONObject Q02_json = new JSONObject();
		Q02_json.put("문제 2) 적어도 대부분의 배수", list.get(0)); // 정렬 후 첫번째 수 json형태로 출력
		model.addAttribute("Q02_json", Q02_json);

		return "Q02/result";
	}

	//1-d문제 좌표
	@RequestMapping(value = "/coordinate")
	public String Coordinate(@RequestParam("coord") String str, Model model) {

		String[] arr = str.split(",");// 입력된 문자를 , 기준으로 나누어서 배열로 받음
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i].replaceAll("[()]", ""); // 배열 안에 "(" 또는 ")" 제거
		}
		// 형변환
		int[] k = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			k[i] = Integer.parseInt(arr[i]);			
		}
		// 2차원배열에 넣기
		int num[][] = new int[k.length / 2][2];
		for (int i = 0; i < k.length / 2; i++) {
			for (int j = 0; j < (i + 1) * 2; j++) {
				if (j % 2 == 0) {
					num[i][0] = k[j];
				}
				if (j % 2 == 1) {
					num[i][1] = k[j];
				}
			}
		}
		Arrays.sort(num, new Comparator<int[]>() { // Comparator 인터페이스 재정의
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])// x좌표의 값이 같다면 y좌표를 기준으로 정렬
					return Integer.compare(o1[1], o2[1]);
				return Integer.compare(o1[0], o2[0]); // 나머지는 x좌표를 기준으로 정렬
			}
		});
		String[] result = new String[5];
		for (int i = 0; i < num.length; i++) {
			result[i] = "(" + num[i][0] + "," + num[i][1] + ")";
		}

		JSONObject coordinate_json = new JSONObject();
		coordinate_json.put("좌표 결과 ", result);
		model.addAttribute("coordinate_json", coordinate_json);

		return "Q01/Coordinate";
	}
}