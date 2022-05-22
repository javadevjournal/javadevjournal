package javadevjournal.design.structural.facade;

/**
 * @author Kunwar
 */
public class Iphone implements IMobileShop {
    @Override
    public void getMobileModelNumber() {
        System.out.println("The model is: IPhone 13");
    }

    @Override
    public void getMobilePrice() {
        System.out.println("The price is: 75000INR ");
    }
} 