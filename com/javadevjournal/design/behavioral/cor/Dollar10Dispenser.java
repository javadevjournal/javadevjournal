package main.com.kunwar.designpatterns.behavioral.cor;

/**
 * @author Kunwar Vikas
 */
public class Dollar10Dispenser implements DispenseChain {
	private DispenseChain dispenseChain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.dispenseChain =nextChain;
	}

	@Override
	public void dispense(Currency currency) {
		if(currency.getAmount() >= 10){
			int num = currency.getAmount()/10;
			int remainder = currency.getAmount() % 10;
			System.out.println("Dispensing "+num+" 10$ note");
			if(remainder !=0) this.dispenseChain.dispense(new Currency(remainder));
		}else{
			this.dispenseChain.dispense(currency);
		}
	}

}