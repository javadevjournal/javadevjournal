package javadevjournal.design.structural.decorator;

/**
 * @author Kunwar
 */
public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}

	@Override
	public void drawShape() {
		decoratedShape.drawShape();
		//additional method to change the behavior of the shape object
		shapeFill(decoratedShape);
	}

	/**
	 * This method will change the behavior of the shape object at runtime.
	 *
	 * @param decoratedShape
	 */
	private void shapeFill(Shape decoratedShape) {
		System.out.println("Shape Fill color: Red");
	}
}
