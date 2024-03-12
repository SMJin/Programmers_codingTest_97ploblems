import java.util.ArrayDeque;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println(queue_15(5, 2));
    }

    /*
        N명의 사람이 원 형태로 서 있습니다.
        각 사람은 1부터 N 까지의 번호표를 갖고 있습니다.
        그리고 임의의 숫자 K가 주어졌을 때 다음과 같이 사람을 없앱니다.
        - 1번 번호표를 가진 사람을 기준으로 K번째 사람을 없앱니다.
        - 없앤 사람 다음 사람을 기준으로 하고 다시 K번째 사람을 없앱니다.
        N과 K가 주어질 때 마지막에 살아있는 사람의 번호를 반환하라

        [제약조건]
         N과 K는 1이상 1000이하의 자연수입니다.
     */
    public static int queue_15(int n, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i=1; i<n+1; i++) q.addLast(i);

        // while(q.size() > 1) 로 하면 됨
        for (int i=0; i<n-1; i++) {
            for (int j=0; j<k-1; j++) {
                q.addLast(q.pollFirst());
            }
            q.pollFirst();
        }
        return q.pollFirst();
    }
}