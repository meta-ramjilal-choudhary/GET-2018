import java.util.List;

public class Rectangle implements Shape {

	private int length;
	private int breadth;
	private Point originPoint;
	private Point rightTopCorner;
	private List<Integer> list;
	private static int id=0;
	private int rectangleID;
	
	Rectangle(Point originPoint, List<Integer> list){
		this.id++;
		this.rectangleID = id;
		try {
			this.list = list;
			this.originPoint = originPoint;
			this.length = list.get(0);
			this.breadth = list.get(1);
			this.rightTopCorner = new Point(this.originPoint.getX()+this.length, this.originPoint.getY()+this.breadth);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * @return - Area of Rectangle
	 */
	public double getArea() {
		
		return (double)(this.length * this.breadth);
	}
	
	/**
	 * @return - Perimeter of Rectangle
	 */
	public double getPerimeter() {
		
		return (double)(2 * (this.length + this.breadth));
	}
	
	/**
	 * @return - Origin point of Rectangle
	 */
	public Point getOrigin() {
		
		return this.originPoint;
	}
	
	/**
	 * Check Whether point inside Rectangle or not
	 * @return - true if point is enclosed otherwise false
	 */
	public boolean isPointEnclosed(Point point) {
		
		if( (point.getX() >= originPoint.getX() && point.getX() <= rightTopCorner.getX()) && (point.getY()>=originPoint.getY() && point.getY()<=rightTopCorner.getY()) ) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return - Type of shape
	 */
	public String getShapeType() {
		return "Rectangle" + this.rectangleID;
	}
	
	/**
	 * 
	 * @return - List of Parameter
	 */
	public List<Integer> getList(){
		
		return this.list;
	}
}
