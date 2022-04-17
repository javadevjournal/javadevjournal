package javadevjournal.design.structural.facade;

/**
 * @author Kunwar
 */
public class ShopKeeper {
    private IMobileShop iphone;
    private IMobileShop samsung;
    private IMobileShop nokia;

    /**
     * no args constructor
     */
    public ShopKeeper() {
        iphone = new Iphone();
        samsung = new Samsung();
        nokia = new Nokia();
    }

    public void iphonePhoneSale() {
        iphone.getMobileModelNumber();
        iphone.getMobilePrice();
    }

    public void samsungPhoneSale() {
        samsung.getMobileModelNumber();
        samsung.getMobilePrice();
    }

    public void nokiaPhoneSale() {
        nokia.getMobileModelNumber();
        nokia.getMobilePrice();
    }
}  