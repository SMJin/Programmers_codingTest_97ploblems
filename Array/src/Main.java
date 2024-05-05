import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        int[] input_03 = {2,1,3,4,1};
//        int[] input_03 = {5, 0, 2, 7};
        int[] input_03 = {0, 1, 3, 0, 8, 9, 8, 7, 1, 1, 2};
        System.out.println(Arrays.toString(array_03(input_03)));
    }

    /*
    문제 01 배열 정렬하기
    정수 배열을 정렬해서 반환하는 solution 함수를 완성하세요.

    [제약조건]
      - 정수 배열의 길이는 2이상 10^5 이하
      - 정수 배열의 각 데이터 값은 -100,000이상 100,000이하
     */
    public int[] array_01(int[] input) {
        Arrays.sort(input);
        return input;
    }

    /*
    문제 02 배열 제어하기
    정수 배열을 하나 받습니다. 배열의 중복값을 제거하고 배열 데이터를 내림차순으로 정렬해서 반환하시오.

    [제약조건]
      - 정수 배열의 길이는 2이상 1000 이하
      - 정수 배열의 각 데이터 값은 -100,000이상 100,000이하
     */
    public int[] array_02(int[] input) {
        Integer[] newArray = (Integer[]) Arrays.stream(input).boxed().distinct().toArray();
        Arrays.sort(newArray, Collections.reverseOrder());
        return Arrays.stream(newArray).mapToInt(Integer::intValue).toArray();
    }

    /*
    문제 03 두 개 뽑아서 더하기
        정수 배열 numbers가 주어진다. numbers에서 서로 다른 인덱스에 있는 2개의 수를 뽑아 더해
        만들 수 있는 모든 수를 배열에 오름차순으로 담아 반환하시오.

    [제약조건]
      - numbers의 길이는 2이상 100 이하
      - numbers의 모든 수는 0이상 100이하
     */
    public static int[] array_03(int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i=0; i<numbers.length; i++) {
            for (int j=i+1; j <numbers.length; j++) {
                answer.add(numbers[i] + numbers[j]);
            }
        }
        return answer.stream().sorted().distinct().mapToInt(Integer::intValue).toArray();
    }
    public static int[] array_03_answer(int[] input) {
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<input.length-1; i++) {
            for (int j=i+1; j <input.length; j++) {
                set.add(input[i] + input[j]);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}