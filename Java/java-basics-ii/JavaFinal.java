import java.util.*;

public class JavaContinue {
    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            if (i == 5) {
                break;
            }
            System.out.println(i);
            i++;
        }
    }

    public static void breakExample(String[] args) {
        int[][] numbers = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        outer: for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (numbers[i][j] == 5) {
                    System.out.println("Found 5 at index [" + i + "][" + j + "]");
                    break outer;
                }
            }
        }
    }
}
