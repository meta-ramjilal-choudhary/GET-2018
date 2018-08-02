/**
 * Point Class represent a Point on Screen
 * @author User29
 *
 */

import java.lang.Math;

public class Point {

	private int x;
	private int y;
	private final int XMAX = 1000;
	private final int YMAX = 1000;
	
	Point(int x, int y) throws InvalidCoordinate{
		if(x > XMAX || y > YMAX || x < 0 || y < 0) {
			throw new InvalidCoordinate("Coordinates exceed screen size!");
		}
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Custom Exception class 
	 * @author User29
	 *
	 */
	class InvalidCoordinate extends Exception{
		
		InvalidCoordinate(String exception){
			
			super(exception);
		}
	}
	
	/**
	 * 
	 * @return - X coordinate of Point
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * 
	 * @return - Y coordinate of Point
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Calculate distance between Both points
	 * @param point - Second point
	 * @return - Distance between both point
	 */
	public double distanceFromPoint(Point point) {
		
		return Math.sqrt(Math.pow((point.getX() - this.getX()), 2) + Math.pow(( point.getY() - this.getY() ), 2));
	}
}
