import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ScreenTest {

	@Test
	void test() {
		try {
			Screen screen = new Screen();
			ShapeFactory shapeFactory = new ShapeFactory();
			
			//Add Square to screen
			Point point = new Point(1, 3);
			List<Integer> list = new ArrayList<Integer>();
			list.add(3); // Side of Square
			Shape shape1 = shapeFactory.createShape("Square", point , list);
			screen.addShapeToScreen(shape1);
			
			//Add Circle to Screen 
			point = new Point(2, 3);
			list = new ArrayList<Integer>();
			list.add(5); // Radius of Circle
			Shape shape2 = shapeFactory.createShape("Circle", point, list);
			screen.addShapeToScreen(shape2);
			
			//Add Rectangel to Screen
			point  = new Point(1,1);
			list = new ArrayList<Integer>();
			list.add(6); // Length of Rectangle
			list.add(2); // Breadth of Rectangle
			Shape shape3 = shapeFactory.createShape("Rectangle", point, list);
			screen.addShapeToScreen(shape3);
			
			List<Shape> sortTimestamp = new ArrayList<Shape>();
			sortTimestamp = screen.sortShapeWithTimestamp();
			
			for(int i=0; i<sortTimestamp.size(); i++) {
				System.out.println(sortTimestamp.get(i).getShapeType());
			}
			
			List<Shape> sortArea = new ArrayList<Shape>();
			sortArea = screen.sortShapeWithTimestamp();
			
			for(int i=0; i<sortArea.size(); i++) {
				System.out.println(sortArea.get(i).getShapeType() + " " + sortArea.get(i).getArea());
			}
			
			List<Shape> sortPerimeter = new ArrayList<Shape>();
			sortPerimeter = screen.sortShapeWithTimestamp();
			
			for(int i=0; i<sortPerimeter.size(); i++) {
				System.out.println(sortPerimeter.get(i).getShapeType()+" "+sortPerimeter.get(i).getPerimeter());
			}
			
			List<Shape> sortOriginDist = new ArrayList<Shape>();
			sortOriginDist = screen.sortShapeWithTimestamp();
			
			for(int i=0; i<sortOriginDist.size(); i++) {
				System.out.println(sortOriginDist.get(i).getShapeType());
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
