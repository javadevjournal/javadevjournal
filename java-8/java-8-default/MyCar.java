interface Car {
    default void printWheelCount() {
        System.out.println("4");
    }

    void printColor();
}

public class MyCar implements Car {

    public static void main(String args[]) {
        MyCar myCar = new MyCar();
        myCar.printColor();
        myCar.printWheelCount();
    }

    @Override
    public void printColor() {
        System.out.println("Red");
    }
}
