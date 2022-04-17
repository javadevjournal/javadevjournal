package javadevjournal.design.structural.facade;

/**
 * @author Kunwar
 */
public class Samsung implements IMobileShop {
    @Override
    public void getMobileModelNumber() {
        System.out.println("The model is: Galaxy 11");
    }

    @Override
    public void getMobilePrice() {
        System.out.println("The price is: 85000INR ");
    }
}  