import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShapeFactoryTest {

	
	//Test Cases For circle -------------------------------------------------------
	@Test
	void testCircleArea() {
		try {
			ShapeFactory shapeFactory = new ShapeFactory();
			Point point = new Point(2, 3);
			List<Integer> list = new ArrayList<Integer>();
			list.add(5); // Radius of Circle
			Shape shape = shapeFactory.createShape("Circle", point , list);
			Assertions.assertTrue( Math.abs(78.54 - shape.getArea()) < 0.001);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	void testCirclePerimeter() {
		try {
			ShapeFactory shapeFactory = new ShapeFactory();
			Point point = new Point(2, 3);
			List<Integer> list = new ArrayList<Integer>();
			list.add(5); // Radius of Circle
			Shape shape = shapeFactory.createShape("Circle", point , list);
			Assertions.assertTrue( Math.abs(31.4159 - shape.getPerimeter()) < 0.001);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	void testCircleOrigin() {
		try {
			ShapeFactory shapeFactory = new ShapeFactory();
			Point point = new Point(2, 3);
			List<Integer> list = new ArrayList<Integer>();
			list.add(5); // Radius of Circle
			Shape shape = shapeFactory.createShape("Circle", point , list);
			Assertions.assertEquals(point, shape.getOrigin());
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	void testCircleIsPointEnclosed() {
		try {
			ShapeFactory shapeFactory = new ShapeFactory();
			Point point = new Point(2, 3);
			List<Integer> list = new ArrayList<Integer>();
			list.add(5); // Radius of Circle
			Shape shape = shapeFactory.createShape("Circle", point , list);
			Point point2 = new Point(1, 5);
			Assertions.assertTrue(shape.isPointEnclosed(point2));;
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	//Test Cases for Square--------------------------------------------
	@Test
	void testSquareArea() {
		try {
			ShapeFactory shapeFactory = new ShapeFactory();
			Point point = new Point(1, 3);
			List<Integer> list = new ArrayList<Integer>();
			list.add(3); // Side of Square
			Shape shape = shapeFactory.createShape("Square", point , list);
			Assertions.assertTrue( Math.abs(9 - shape.getArea()) < 0.001);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	void testSquarePerimeter() {
		try {
			ShapeFactory shapeFactory = new ShapeFactory();
			Point point = new Point(1, 3);
			List<Integer> list = new ArrayList<Integer>();
			list.add(3); // Side of Square
			Shape shape = shapeFactory.createShape("Square", point , list);
			Assertions.assertTrue( Math.abs(12 - shape.getPerimeter()) < 0.001);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	void testSquareOrigin() {
		try {
			ShapeFactory shapeFactory = new ShapeFactory();
			Point point = new Point(1, 3);
			List<Integer> list = new ArrayList<Integer>();
			list.add(3); // Side of Square
			Shape shape = shapeFactory.createShape("Square", point , list);
			Assertions.assertEquals(point, shape.getOrigin());
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	void testSquareIsPointEnclosed() {
		try {
			ShapeFactory shapeFactory = new ShapeFactory();
			Point point = new Point(1, 3);
			List<Integer> list = new ArrayList<Integer>();
			list.add(3); // Side of Square
			Shape shape = shapeFactory.createShape("Square", point , list);
			Point point2 = new Point(3, 5);
			Assertions.assertTrue(shape.isPointEnclosed(point2));;
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//Test Cases for Rectangle --------------------------------------------
		@Test
		void testRectangleArea() {
			try {
				ShapeFactory shapeFactory = new ShapeFactory();
				Point point = new Point(4, 5);
				List<Integer> list = new ArrayList<Integer>();
				list.add(4); // Length of Rectangle
				list.add(10); // Breadth of Rectangle
				Shape shape = shapeFactory.createShape("Rectangle", point , list);
				Assertions.assertTrue( Math.abs(40 - shape.getArea()) < 0.001);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		@Test
		void testRectanglePerimeter() {
			try {
				ShapeFactory shapeFactory = new ShapeFactory();
				Point point = new Point(1, 3);
				List<Integer> list = new ArrayList<Integer>();
				list.add(4); // Length of Rectangle
				list.add(10); // Breadth of Rectangle
				Shape shape = shapeFactory.createShape("Rectangle", point , list);
				Assertions.assertTrue( Math.abs(28 - shape.getPerimeter()) < 0.001);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		@Test
		void testRectangleOrigin() {
			try {
				ShapeFactory shapeFactory = new ShapeFactory();
				Point point = new Point(1, 3);
				List<Integer> list = new ArrayList<Integer>();
				list.add(4); // Length of Rectangle
				list.add(10); // Breadth of Rectangle
				Shape shape = shapeFactory.createShape("Rectangle", point , list);
				Assertions.assertEquals(point, shape.getOrigin());
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		@Test
		void testRectangleIsPointEnclosed() {
			
			try {
				ShapeFactory shapeFactory = new ShapeFactory();
				Point point = new Point(10, 3);
				List<Integer> list = new ArrayList<Integer>();
				list.add(4); // Length of Rectangle
				list.add(10); // Breadth of Rectangle
				Shape shape = shapeFactory.createShape("Rectangle", point , list);
				Point point2 = new Point(14, 5);
				Assertions.assertTrue(shape.isPointEnclosed(point2));;
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		//Triangle test Cases---------------------------------------------
		@Test
		void testTriangleArea() {
			try {
				ShapeFactory shapeFactory = new ShapeFactory();
				Point point = new Point(4, 5);
				List<Integer> list = new ArrayList<Integer>();
				list.add(4); // Base of Triangle
				list.add(10); // Height of Triangle
				Shape shape = shapeFactory.createShape("Triangle", point , list);
				Assertions.assertTrue( Math.abs(20 - shape.getArea()) < 0.001);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		@Test
		void testTrianglePerimeter() {
			try {
				ShapeFactory shapeFactory = new ShapeFactory();
				Point point = new Point(1, 3);
				List<Integer> list = new ArrayList<Integer>();
				list.add(3); // Base of Triangle
				list.add(4); // Height of Triangle
				Shape shape = shapeFactory.createShape("Triangle", point , list);
				Assertions.assertTrue( Math.abs(12 - shape.getPerimeter()) < 0.001);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		@Test
		void testTriangleOrigin() {
			try {
				ShapeFactory shapeFactory = new ShapeFactory();
				Point point = new Point(1, 3);
				List<Integer> list = new ArrayList<Integer>();
				list.add(4); // Base of Triangle
				list.add(10); // Height of Triangle
				Shape shape = shapeFactory.createShape("Triangle", point , list);
				Assertions.assertEquals(point, shape.getOrigin());
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		@Test
		void testTriangleIsPointEnclosed() {
			
			try {
				ShapeFactory shapeFactory = new ShapeFactory();
				Point point = new Point(1, 3);
				List<Integer> list = new ArrayList<Integer>();
				list.add(4); // Base of Triangle
				list.add(3); // Height of Triangle
				Shape shape = shapeFactory.createShape("Triangle", point , list);
				Point point2 = new Point(3, 4);
				Assertions.assertTrue(shape.isPointEnclosed(point2));;
			}catch(Exception e) {
				System.out.println(e);
			}
		}
}
