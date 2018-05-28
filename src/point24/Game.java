package point24;

import java.util.*;

public class Game {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int[] a = {cin.nextInt(), cin.nextInt(), cin.nextInt(), cin.nextInt()};
        cin.close();
        String ans = solve24(a);
        System.out.println(ans);
    }

    public static String solve24(int[] a) {
        Random rand = new Random();
        String[] ops = "+ - * /".split("\\s+");
        for (int t = 0; t < 100000; t++) {
            List<String> exp = new Vector<>();
            for (int i: a
                 ) {
                exp.add(Double.toString(i * 1.0));
            }
            for (int i = 0; i < 3; i++) {
                exp.add(ops[rand.nextInt(4)]);
            }
            Collections.shuffle(exp);
            if (Math.abs(RPorlandExpression.evalue(exp) - 24.0) < 1e-6) {
                StringBuffer buffer = new StringBuffer("");
                BinaryTree.buildBTree(exp).midVisit(buffer);
                return buffer.toString().replaceAll("\\.0", "") + " = 24";
            }
        }
        return "No solution?";

    }
}
