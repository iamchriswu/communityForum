package point24;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RPorlandExpression {
    public static void main(String[] args) {
        String[] exp = "3 4 + 5 6 + *".split(" ");
        System.out.println(Arrays.toString(exp));
        System.out.println(evalue(exp));
    }

    public static double evalue(String[] exp) {
        Stack<Double> expStack = new Stack<>();
        for (String e: exp
             ) {
            if("+-*/".contains(e)) {
                if (expStack.size() < 2) {
                    return -1;
                }
                double b = expStack.pop();
                double a = expStack.pop();
                int idx = "+-*/".indexOf(e);
                if (idx == 0) {
                    expStack.push(a + b);
                }else if (idx == 1) {
                    expStack.push(a - b);
                }else if (idx == 2) {
                    expStack.push(a * b);
                } else {
                    expStack.push(a / b);
                }
            } else {
                expStack.push(Double.parseDouble(e));
            }
        }
        if (expStack.size() != 1) {
            return -1;
        }
        return expStack.peek();
    }

    public static double evalue(List<String> v) {
        String[] exp = new String[v.size()];
        for (int i = 0; i < v.size(); i++) {
            exp[i] = v.get(i);
        }
        return evalue(exp);
    }
}
