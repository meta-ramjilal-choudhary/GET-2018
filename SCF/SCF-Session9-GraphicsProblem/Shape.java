import java.util.List;

/**
 * Shape Abstract Data Type
 * @author User29
 *
 */

public interface Shape {
	
	/**
	 * Calculate Area for Shape 
	 * @return - Area of shape
	 */
	public double getArea();
	
	/**
	 * Calculate Perimeter for Shape
	 * @return - Perimeter of shape
	 */
	public double getPerimeter();
	
	/**
	 * Find Origin of a shape
	 * @return - Point class 
	 */
	public Point getOrigin();
	
	/**
	 * 
	 * @param point
	 * @return - True if point is Enclosed otherwise false
	 */
	public boolean isPointEnclosed(Point point);
	
	/**
	 * 
	 * @return - Type of shape
	 */
	public String getShapeType() ;
	
	/**
	 * 
	 * @return - List of Parameter
	 */
	public List<Integer> getList();
}
