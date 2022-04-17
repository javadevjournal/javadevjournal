package javadevjournal.design.structural.facade;

/**
 * @author Kunwar
 */
public class Nokia implements IMobileShop {
    @Override
    public void getMobileModelNumber() {
        System.out.println("The model is: Nokia 1100");
    }

    @Override
    public void getMobilePrice() {
        System.out.println("The price is: 1500INR ");
    }
}