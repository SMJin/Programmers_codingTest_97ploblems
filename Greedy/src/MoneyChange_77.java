import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MoneyChange_77 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(change(123)));
        System.out.println(Arrays.toString(change(350)));
    }

    /*
    거스름 돈을 최소한의 화폐 수로 받고자 한다.
    거스름돈 amount 에 대해서 화폐 단위 [1, 10, 50, 100]을 최소한으로 사용하시오.

    반환하는 값의 화폐 단위는 내림차순이어야 합니다.
    amount 는 자연수입니다.
    화폐 단위는 1, 10, 50, 100이며 화폐 개수는 무한입니다.
     */
    private static int[] change(int amount) {
        List<Integer> result = new ArrayList<>();

        int[] moneys = {100, 50, 10, 1};
        int i = 0;
        int money = moneys[i];

        while(amount > 0) {
            if (amount >= money) {
                result.add(money);
                amount -= money;
            } else {
                money = moneys[++i];
            }
        }
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
