import java.lang.ArithmeticException;

public class Area {
	
	/*
	 * Compute Area of Triangle
	 * @param  widht - width of triangle
	 * @param  height - height of triangle
	 * @return double - area of triangle
	 */
	public double areaOfTriangle(double width, double height)throws ArithmeticException {
		return (0.5 * width * height);
	}
	
	/*
	 * Compute Area of Rectangle
	 * @param  widht - width of Rectangle
	 * @param  height - height of Rectangle
	 * @return double - area of Rectangle
	 */
	public double areaOfRectangle(double width, double height)throws ArithmeticException {
		return ( width * height);
	}
	
	/*
	 * Compute Area of Square
	 * @param  widht - side of Square
	 * @return double - area of Square
	 */
	public double areaOfSquare(double side)throws ArithmeticException {
		return (side * side);
	}
	
	/*
	 * Compute Area of Circle
	 * @param  widht - radius of Circle
	 * @return double - area of Circle
	 */
	public double areaOfCircle(double radius)throws ArithmeticException {
		return ( Math.PI * Math.pow(radius, 2.0) );
	}
	
}
