interface MyCar {
    default public String getColor() {
        return "red";
    }
}

interface MyBike {
    default public String getColor() {
        return "blue";
    }
}

public class MyVehicle implements MyCar, MyBike {

    public static void main(String args[]) {
        MyVehicle vehicle = new MyVehicle();
        System.out.println(vehicle.getColor());
    }


    @Override
    public String getColor() {
        return MyCar.super.getColor();
    }
}
