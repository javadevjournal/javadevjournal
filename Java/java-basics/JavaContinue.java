import java.util.*;

public class JavaContinue {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (j == 5) {
                    continue;
                }
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }

    public static void continueExample(String[] args) {
        outer: for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (j == 5) {
                    continue outer;
                }
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }


}
