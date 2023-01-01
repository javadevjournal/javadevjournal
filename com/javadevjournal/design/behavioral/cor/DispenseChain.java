package main.com.kunwar.designpatterns.behavioral.cor;

/**
 * @author Kunwar Vikas
 */
public interface DispenseChain {
	void setNextChain(DispenseChain nextChain);
	void dispense(Currency currency);
}