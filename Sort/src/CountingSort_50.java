import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountingSort_50 {

    public static final int ALPHABET_SIZE = 26;

    public static void main(String[] args) {
//        System.out.println(solution("dcba"));
//        System.out.println(solution("hello"));
//        System.out.println(solution("algorithm"));

        System.out.println(real_solution("hello"));
    }

    /*
     * 인자로 받은 문자열 s를 계수 정렬로 정렬하여 반환
     *
     * [제약 조건]
     * strings의 길이는 1이상 10,000 이하
     * s는 알파벳 소문자로 이루어져 있다.
     */
    public static String solution(String s) {
        char[] strings = s.toCharArray();
        char[] results = new char[strings.length];

//        char a = 'a';
//        char z = 'z';
//        System.out.println((int) z - 97); // 25
//        System.out.println(((int) a) - 97); // 0

        // 원본 배열
        int[] origins = new int[strings.length];
        int idx = 0;
        for (char ch : strings) {
            origins[idx++] = getASCII(ch);
        }
        System.out.println("원본배열 : " + Arrays.toString(origins));


        // 계수 배열
        int[] counts = new int[ALPHABET_SIZE];
        for (int ogn : origins) {
            counts[ogn] ++;
        }
        System.out.println("계수배열 : " + Arrays.toString(counts));

        // 누적 계수 배열
        int[] accumulates = new int[ALPHABET_SIZE];
        accumulates[0] = counts[0];
        for (int i=1; i<ALPHABET_SIZE; i++) {
            accumulates[i] = accumulates[i-1] + counts[i];
        }
        System.out.println("누적계수 : " + Arrays.toString(accumulates));

        // 원본 배열 역순 순회
        for (int i = origins.length - 1; i>=0; i--) {
            int cur = origins[i];
            results[--accumulates[cur]] = getAlphabet(cur);
        }

        return Arrays.toString(results);
    }

    private static int getASCII(char alphabet) {
        return (int) alphabet - 97;
    }

    private static char getAlphabet(int ascii) {
        return (char) (ascii + 97);
    }

    private static String real_solution(String s) {
        int[] counts = new int[26];

        for (char c: s.toCharArray()) {
            counts[c - 'a']++;
        }
//        System.out.println(Arrays.toString(counts));

        StringBuilder sortedStr = new StringBuilder();
        for (int i=0; i<26; i++) {
            for (int j=0; j<counts[i]; j++) {
                sortedStr.append((char) (i+'a'));
            }
        }

        return sortedStr.toString();
    }
}
