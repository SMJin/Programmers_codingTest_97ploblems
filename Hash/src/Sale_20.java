import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Sale_20 {

    public static final int SAIL_DURATION = 10;

    /*
            XYZ 마트는 일정 금액을 지불하면 10일 동안 회원 자격을 부여합니다.
            XYZ 마트에서는 회원을 대상으로 매일 1가지 제품을 할인하는 행사를 합니다.
            할인 제품은 하루에 하나만 구매할 수 있습니다.
            알뜰한 정현이는 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 때에 맞춰서 회원가입을 하려고 합니다.

            예를 들어 정현이가 원하는 제품이 바나나 3개, 사과 2개, 쌀 2개, 돼지고기 2개, 냄비 1개 이고,
            XYZ 마트에서 14일간 회원을 대상으로 할인하는 제품이 날짜 순서대로
            치킨, 사과, 사과, 바나나, 쌀, 사과, 돼지고기, 바나나, 돼지고기, 쌀, 냄비, 바나나, 사과, 바나나면
            첫째 날부터 열흘동안은 냄비는 할인하지 않으므로 첫째 날에는 회원가입을 하지 않습니다.
            둘째 날부터 열흘 동안은 바나나를 원하는 만큼 할인 구매할 수 없으므로 둘째 날에도 회원가입을 하지 않습니다.
            셋째, 넷째, 다섯째 날부터 각각 열흘 동안은 원하는 제품과 수량이 일치하므로 셋 중 하루에 회원가입을 합니다.

            정현이가 원하는 제품을 나타내는 문자열 배열 want 와 정현이가 원하는 제품의 수량을 나타내는 정수 배열 number,
            XYZ 마트에서 할인하는 제품을 나타내는 문자열 배열 discount 가 있을 때
            회원가입 시 정현이가 원하는 제품을 모두 할인받을 수 있는 회원 등록 날짜의 총 일수를 반환하시오.
            가능한 날이 없으면 0을 반환합니다.
             */
    public static void main(String[] args) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] want = {
//                "banana", "apple", "rice", "pork", "pot"

                "apple"
        };
        int[] number = {
//                3,2,2,2,1

                10
        };
        String[] discount = {
//                "chicken", "apple", "apple", "banana", "rice",
//                "apple", "pork", "banana", "pork", "rice",
//                "pot", "banana", "apple", "banana"

                "banana", "banana", "banana", "banana", "banana",
                "banana", "banana", "banana", "banana", "banana",
        };

        System.out.println(solution(want, number, discount));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int result = 0;

        HashMap<String, Integer> basket = new HashMap<>();
        for (int i=0; i< want.length; i++) {
            basket.put(want[i], number[i]);
        }

        for (int i=0; i< discount.length - 9; i++) {
            HashMap<String, Integer> basket_sub = new HashMap<>();
            for (int j=i; j<i+10; j++) {
                basket_sub.put(discount[j], basket_sub.getOrDefault(discount[j], 0) + 1);
            }
            if (basket.equals(basket_sub)) result ++;
        }

        return result;
    }
}
