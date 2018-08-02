import java.util.List;

public class Triangle implements Shape {

	private Point originPoint;
	private int base;
	private int height;
	private List<Integer> list;
	private static int id=0;
	private int triangleID;
	
	Triangle(Point originPoint, List<Integer> list){
		this.id++;
		this.triangleID = id;
		this.list = list;
		this.originPoint = originPoint;
		this.base = list.get(0);
		this.height = list.get(1);
	}
	
	/**
	 * @return - Area of Triangle
	 */
	public double getArea() {
		
		return 0.5 * this.base * this.height;
	}
	
	/**
	 * @return - Perimeter of Triangle
	 */
	public double getPerimeter() {
		
		return this.base + this.height + Math.sqrt( this.base*this.base + this.height*this.height );
	}
	
	/**
	 * @return - Origin point of Triangle
	 */
	public Point getOrigin() {
		return this.originPoint;
	}
	
	/**
	 * Check Whether point inside Triangle or not
	 * @return - true if point is enclosed otherwise false
	 */
	public boolean isPointEnclosed(Point point) {
		
		try {
			Point p1 = new Point(this.originPoint.getX()+this.base, this.originPoint.getY());
			Point p2 = new Point(this.originPoint.getX(), this.originPoint.getY()+this.height);
			if(point.getX()>=this.originPoint.getX() && point.getY() >= this.originPoint.getY()) {
				double left = point.getY()*( p2.getX() - p1.getX() ) - point.getX()*(p2.getY() - p1.getY());
				double right = p1.getY()*p2.getX() - p1.getX()*p2.getY();
				if(left >= right) {
					return true;
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	/**
	 * 
	 * @return - Type of shape
	 */
	public String getShapeType() {
		return "Triangle" + this.triangleID;
	}
	
	/**
	 * 
	 * @return - List of Parameter
	 */
	public List<Integer> getList(){
		
		return this.list;
	}
}
