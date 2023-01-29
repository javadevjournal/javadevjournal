import java.util.*;

public class TernaryOperator {
    public static void main(String[] args) {
        int x = 10;
        int y = (x > 5) ? 100 : 200;
    }

    public static void nestedTernaryOperator() {
        int x = 10;
        int y = 20;
        int z = (x > 5) ? (y > 10 ? 30 : 40) : 50;
    }

}
