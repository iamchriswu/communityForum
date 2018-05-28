package point24;

import java.util.Collections;
import java.util.Vector;

public class CollectionShuffle {
    public static void main(String[] args) {
        String[] exp = "1 3 + 2 4 + *".split("\\s+");
        Vector<String> v = new Vector<>();
        for (String e: exp
             ) {
            v.add(e);
        }
        for (int i = 0; i < 100000; i++) {
            Collections.shuffle(v);
            double ans = RPorlandExpression.evalue(v);
            if(ans == 24) {
                System.out.println(v);
                return;
            }
        }
    }
}
