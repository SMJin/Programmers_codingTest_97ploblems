import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] nodes = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(tree_25(nodes)));
    }

    /*
        이진 트리를 표현한 리스트 nodes를 인자로 받습니다.
        예를들어 nodes가 [1,2,3,4,5,6,7]이면 다음과 같은 트리를 표현한 것입니다.
        해당 이진 트리에 대하여 전위 순회, 중위 순회, 후위 순회 결과를 반환하라
     */
    public static String[] tree_25(int[] nodes) {
        String[] result = new String[3];
        result[0] = preorder(nodes, 0).trim();
        result[1] = inorder(nodes, 0).trim();
        result[2] = postorder(nodes, 0).trim();
        return result;
    }

    private static String preorder(int[] nodes, int idx) {
        if (idx >= nodes.length) return "";

        return nodes[idx] + " "
                + preorder(nodes, idx * 2 + 1)
                + preorder(nodes, idx * 2 + 2);
    }

    private static String inorder(int[] nodes, int idx) {
        if (idx >= nodes.length) return "";

        return inorder(nodes, idx * 2 + 1)
                + nodes[idx] + " "
                + inorder(nodes, idx * 2 + 2);
    }

    private static String postorder(int[] nodes, int idx) {
        if (idx >= nodes.length) return "";

        return postorder(nodes, idx * 2 + 1)
                + postorder(nodes, idx * 2 + 2)
                + nodes[idx] + " ";
    }
}