import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }

    /*
        상호배타적 집합을 표현하고 관리하는 데 다음 두 연산이 필요합니다.
        - union(x, y) : x와 y가 속한 두 집합을 합칩니다.
        - find(x) : x가 속한 집합의 대표 원소를 찾습니다.
        operations 라는 배열은 수행할 연산을 의미합니다. 연산 종류는 2개입니다.
        - [0, 1, 2]는 노드 1과 노드 2에 대해 union 연산 수행
        - [1, 1, 3] 노드 1과 3이 같은 집합에 속해 있으면 true 아니면 false 반환하는 equals 연산
        초기의 노드는 부모 노드를 자신의 값으로 설정했다고 가정하며, 여기서는 각 집합의 루트 노드를 기준으로
        루트 노드가 작은 노드를 더 큰 노드의 자식으로 연결하는 방법을 사용합니다.
        operations 에 있는 연산에 대한 결과를 연산 순서대로 담은 Boolean 배열을 반환하라.

        [제약조건]
        - 0 <= k <= 1,000 : 노드의 개수
        - 1 <= len(operations) <= 100,000
        - operations[i][0]은 문자열 'u' 또는 'f' 중 하나
        - 0 은 union 연산, union 연산 뒤로는 두 개의 정수 x, y가 나옴
        - 1 은 equals 연산, equals 연산 뒤로는 두 개의 정수 x, y가 나옴
        - x와 y는 0 이상 k-1 이하의 정수
        - 연산은 항상 유효함
            - 즉, union, find 연산의 인수는 상호 배타적 집함 내에 있는 노드 번호
     */
    public static Boolean[] set_30 (int k, int[][] operations) {
        ArrayList<Boolean> result = new ArrayList<>();

        int[] set = new int[k];
        for (int i : set) {
            set[i] = i;
        }

        for (int[] oper : operations) {
            int c = oper[0];
            if (c == 0) {
                set = union(set, oper[1], oper[2]);
            }
            if (c == 1) {
                result.add(find(set, oper[1]) == find(set, oper[2]));
            }
        }
        return result.toArray(new Boolean[0]);
    }

    private static int[] union(int[] set, int x, int y) {
        int rootX = find(set, x);
        int rootY = find(set, y);

        if (rootX == rootY) return set;
        set[rootX] = rootY;
        return set;
    }

    private static int find(int[] set, int x) {
        if (set[x] == x) return x;
        return find(set, set[x]);
    }
}