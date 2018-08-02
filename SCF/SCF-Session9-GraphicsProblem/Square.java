import java.util.List;

public class Square implements Shape{

	private int side;
	private Point originPoint;
	private Point rightTopCorner;
	private List<Integer> list;
	private static int id=0;
	private int squareID;
	
	Square(Point originPoint, List<Integer> list){
		this.id++;
		this.squareID = id;
		try {
			this.list = list;
			this.originPoint = originPoint;
			this.side = list.get(0);
			this.rightTopCorner = new Point(this.originPoint.getX()+this.side, this.originPoint.getY()+this.side);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * @return - Area of Square
	 */
	public double getArea() {
		
		return (double)(this.side * this.side);
	}
	
	/**
	 * @return - Perimeter of Square
	 */
	public double getPerimeter() {
		
		return (double)(4 * this.side);
	}
	
	/**
	 * @return - Origin point of Square
	 */
	public Point getOrigin() {
		
		return this.originPoint;
	}
	
	/**
	 * Check Whether point inside Square or not
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
		return "Square" + this.squareID;
	}
	
	/**
	 * 
	 * @return - List of Parameter
	 */
	public List<Integer> getList(){
		
		return this.list;
	}
}
