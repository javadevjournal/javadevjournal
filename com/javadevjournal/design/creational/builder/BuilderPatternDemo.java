package javadevjournal.design.creational.builder;

/**
 * @author Kunwar
 * Builder Pattern Client Class
 * Create Computer object with mandatory and optional properties
 */
public class BuilderPatternDemo {
	public static void main(String[] args) {

		Computer model1 = new Computer.ComputerBuilder(
				"1 TB", "16 GB","15.6").setBluetoothEnabled(true)
				.setGraphicsCardEnabled(true).setTouchScreenEnabled(true).setWebCamEnabled(true).build();
		System.out.println("model1: " + model1.toString());

		Computer model2 = new Computer.ComputerBuilder(
				"256 GB", "8 GB","14.6").setBluetoothEnabled(true)
				.setGraphicsCardEnabled(true).build();
		System.out.println("model2: "+model2.toString());


		Computer model3 = new Computer.ComputerBuilder(
				"128 GB", "4 GB","13.6").build();
		System.out.println("model3: "+model3.toString());
	}
}