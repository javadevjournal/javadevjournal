package javadevjournal.design.structural.decorator;// DecoratorPatternDemo.java

/**
 * @author Kunwar
 */
public class DecoratorPatternDemo {

	public static void main(String[] args) {
		// Creating objects of Shape interface
		Shape circle = new Circle();
		Shape rectangle = new Rectangle();

		// Creating objects of decorated classes
		Shape redCircle = new RedShapeDecorator(new Circle());
		Shape redRectangle = new RedShapeDecorator(new Rectangle());

		System.out.println("Circle with normal fill");
		circle.drawShape();

		System.out.println("Rectangle with normal fill");
		rectangle.drawShape();

		System.out.println("\nCircle of red fill");
		redCircle.drawShape();

		System.out.println("\nRectangle of red fill");
		redRectangle.drawShape();
	}
}
