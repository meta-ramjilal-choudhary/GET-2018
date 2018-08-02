import java.util.List;

public class ShapeFactory {

	private static Shape shape;
	
	ShapeFactory(){}
	
	public static Shape createShape(String shapeType, Point originPoint, List<Integer> list) {
		
		ShapeTypeEnum shapeEnum = ShapeTypeEnum.valueOf(shapeType.toUpperCase());
		
		switch(shapeEnum) {
		case CIRCLE:
			return new Circle(originPoint, list);
		case SQUARE:
			return new Square(originPoint, list);
		case RECTANGLE:
			return new Rectangle(originPoint, list);
		case TRIANGLE:
			return new Triangle(originPoint, list);
		default:
			return null;
		}
		
	}
	
}
