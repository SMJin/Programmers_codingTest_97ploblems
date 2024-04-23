import java.util.ArrayList;
import java.util.List;

public class backTracking_43 {

    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(2));
        System.out.println(solution(7));
    }


    static List<ArrayList<Integer>> result;
    static final int AMT = 10;

    /*
     * 정수 N을 입력 받아 1부터 N 까지의 숫자 중에서 합이 10이 되는 조합을 리스트로 반환
     *
     * 백트랙킹을 활용
     * 숫자 조합은 오름차순으로 정렬
     * 같은 숫자는 한 번만 선택
     * N은 1이상 10이하인 정수
     */
    private static List<ArrayList<Integer>> solution(int n) {
        result = new ArrayList<>();

        for (int i=1; i<=n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            combination(n, i, i, list);
        }

//        for (int i=n; i>0; i--) {
//            desc_combination(i, i, new ArrayList<Integer>());
//        }

        return result;
    }

    private static void combination(int N, int n, int amt, ArrayList<Integer> list) {
        if (amt == AMT) {
            result.add(list);
            return;
        }

        for (int i=n+1; i<=N; i++) {
            if (n+amt > AMT) return;
            ArrayList<Integer> newList = new ArrayList<>(list);
            newList.add(i);
            combination(N, i, i + amt, newList);
        }
    }

    private static void desc_combination(int n, int amt, ArrayList<Integer> list) {
        list.add(n);

        if (amt == AMT) {
            result.add(list);
            return;
        }

        for (int i=n-1; i>0; i--) {
            if (amt + i > AMT) continue;
            desc_combination(i, amt+i, new ArrayList<>(list));
        }
    }

}
