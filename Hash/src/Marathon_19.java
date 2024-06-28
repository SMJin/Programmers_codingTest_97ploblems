import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Marathon_19 {
    /*
    완주하지 못한 선수

    많은 선수 중 단 한 명의 선수를 제외하고 모든 선수가 마라톤을 완주하였습니다.
    마라톤에 참여한 선수들의 이름이 담긴 배열 participant 와
    완주한 선수들의 이름이 담긴 배열 completion 이 있을 때
    완주하지 못한 선수의 이름을 반환하는 solution() 함수를 작성하세요.

    [제약 조건]
    - 마라톤 경기에 참여한 선수 수는 1 명이상 100,000 명 이하입니다.
    - completion 길이는 participant 길이보다 1 작습니다.
    - 참가자 이름은 1개 이상 20 개 이하의 알파벳 소문자로 이루어져 있습니다.
    - 참가자 중에는 동명이인이 있을 수 있습니다.

    [입출력의 예]
    (1)
    participant = leo kiki eden
    completion = eden kiki
    return leo

    (2)
    participant = marina josipa nikola vinko filipa
    completion = josipa filipa marina nikola
    return vinko

    (3)
    participant = mislav stanko mislav ana
    completion = stanko ana mislav
    return mislav
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] participant = br.readLine().split(" ");
        String[] completion = br.readLine().split(" ");

        HashMap<String, Integer> participantMap = new HashMap<>();

        for (String c : completion) participantMap.put(c, participantMap.getOrDefault(c, 0) + 1);
        for (String p : participant) {
            if (participantMap.getOrDefault(p, 0) == 0) {
                System.out.println(p);
                return;
            }
            participantMap.put(p, participantMap.get(p) - 1);
        }
    }
}
