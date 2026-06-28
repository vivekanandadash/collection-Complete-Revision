package stringTokenizer;

import java.util.StringTokenizer;

public class StringTokenizerDemo {
    public static void main(String[] args) {
        String s = "Java Programming Class";
        StringTokenizer st = new StringTokenizer(s , " ");
        while (st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}
