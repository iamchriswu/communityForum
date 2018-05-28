package point24;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    String root;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree() {
        root = "";
        left = null;
        right = null;
    }

    public BinaryTree(String root, BinaryTree left, BinaryTree right) {
        this.root = root;
        this.right = right;
        this.left = left;
    }

    static BinaryTree buildBTree(List<String> exp) {
        Stack<BinaryTree> st = new Stack<>();
        for (String e: exp
             ) {
            if("+-*/".contains(e)) {
                BinaryTree op = new BinaryTree(e, null, null);
                BinaryTree b = st.pop();
                BinaryTree a = st.pop();
                op.right = b;
                op.left = a;
                st.push(op);
            } else {
                st.push(new BinaryTree(e, null, null));
            }
        }
        return st.pop();
    }
    public void midVisit() {
        if (left != null) {
            System.out.print("(");
            left.midVisit();
        }
        System.out.print(root);
        if (right != null) {
            right.midVisit();
            System.out.print(")");
        }
    }

    public void midVisit(StringBuffer buffer) {
        if (left != null) {
            buffer.append("(");
            left.midVisit(buffer);
        }
        buffer.append(root);
        if (right != null) {
            right.midVisit(buffer);
            buffer.append(")");
        }
    }

    public static void main(String[] args) {
        BinaryTree bTree = BinaryTree.buildBTree(Arrays.asList("8 7 + 1 5 - *".split("\\s+")));
        StringBuffer buffer = new StringBuffer("");
        bTree.midVisit(buffer);
        System.out.println(buffer);
    }
}
