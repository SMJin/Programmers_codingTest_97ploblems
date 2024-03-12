import java.util.HashMap;
import java.util.HashSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] a1 = {1,2,3,4,8};
        System.out.println(hash_18(a1, 6));
        int[] a2 = {2,3,5,9};
        System.out.println(hash_18(a2, 6));
    }

    /*
        n개의 양의 정수로 이루어진 배열 arr와 정수 target이 주어졌을 때
        이 중에서 합이 target인 두 수가 arr에 있는치 찾고, 있으면 true 없으면 false를 반환

        [제약조건]
        - n은 2이상 10,000이하의 자연수
        - arr의 각 원소는 1 이상 10,000이하의 자연수
        - arr의 원수 중 중복되는 원소는 없다
        - target은 1 이상 20,000이하의 자연수
     */
    public static boolean hash_18(int[] arr, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int a : arr) {
            m.put(a, a);
        }

        for (int a : arr) {
            if (target-a != a && m.get(target-a) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean hash_18_solution(int[] arr, int target) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int a : arr) {
            if (hashSet.contains(target-1)) return true;
            hashSet.add(a);
        }
        return false;
    }
}