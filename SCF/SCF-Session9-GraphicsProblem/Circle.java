import java.lang.Math;
import java.util.List;

public class Circle implements Shape{

	private Point originPoint;
	private Point centerPoint;
	private double radius;
	private static int id = 0;
	private int circleID;
	private List<Integer> list;
	
	Circle(Point originPoint, List<Integer> list){
		this.id++;
		this.circleID = id;
		try {
			this.list = list;
			this.originPoint = originPoint;
			this.radius = list.get(0);
			Point originOfScreen = new Point(0, 0);
			double m = this.originPoint.distanceFromPoint(originOfScreen) + (double)this.radius;
			int x1 = (int)( (m * (double)this.originPoint.getX())/ (m - (double)this.radius) );
			int y1 = (int)( (m * (double)this.originPoint.getY())/ (m - (double)this.radius) );
			this.centerPoint = new Point(x1, y1);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * @return - Area of circle
	 */
	public double getArea() {
		
		return Math.PI * this.radius * this.radius;
	}
	
	/**
	 * @return - Perimeter of Circle
	 */
	public double getPerimeter() {
		
		return 2 * Math.PI * this.radius;
	}
	
	/**
	 * @return - Origin point of Circle
	 */
	public Point getOrigin() {
		
		return this.originPoint;
	}
	
	/**
	 * Check Whether point inside circle or not
	 * @return - true if point is enclosed otherwise false
	 */
	public boolean isPointEnclosed(Point point) {
		
		if( this.centerPoint.distanceFromPoint(point) <= this.radius ) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return - Type of shape
	 */
	public String getShapeType() {
		return "Circle" + this.circleID;
	}
	
	/**
	 * 
	 * @return - List of Parameter
	 */
	public List<Integer> getList(){
		
		return this.list;
	}
}
