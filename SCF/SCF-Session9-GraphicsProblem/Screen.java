import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Screen {

	private TreeMap<Date, Shape> shapeWithTime ;
	private TreeMap<Shape, Double> shapeWithArea;
	private TreeMap<Double, Shape> shapeWithPerimeter;
	private TreeMap<Double, Shape> shapeWithOriginDistance;
	
	Screen(){
		shapeWithTime = new TreeMap<Date, Shape>();
		shapeWithArea = new TreeMap<Shape, Double>();
		shapeWithPerimeter = new TreeMap<Double, Shape>();
		shapeWithOriginDistance = new TreeMap<Double, Shape>();
	}
	
	/**
	 * Add Shape to screen
	 * @param shape - Shape objects
	 */
	public void addShapeToScreen(Shape shape) {
		System.out.println(shape.getShapeType());
		this.shapeWithTime.put(new Date(), shape);
		this.shapeWithArea.put(shape, shape.getArea());
		this.shapeWithPerimeter.put(shape.getPerimeter(), shape);
		try {
			this.shapeWithOriginDistance.put(shape.getOrigin().distanceFromPoint(new Point(0, 0)), shape);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * 
	 * @return - List of Shapes in sorted according to timestamp
	 */
	public List<Shape> sortShapeWithTimestamp(){
		List<Shape> list = new ArrayList<Shape>();
		for (Map.Entry<Date, Shape> entry : this.shapeWithTime.entrySet()) {
	        list.add(entry.getValue());
	    }
		return list;
	}
	
	/**
	 * 
	 * @return - List of Shapes in sorted according to Area
	 */
	public List<Shape> sortShapeWithArea(){
		List<Shape> list = new ArrayList<Shape>();
		for (Map.Entry<Shape, Double> entry : this.shapeWithArea.entrySet()) {
	        list.add(entry.getKey());
	    }
		return list;
	}
	
	/**
	 * 
	 * @return - List of Shapes in sorted according to Perimeter
	 */
	public List<Shape> sortShapeWithPerimeter(){
		List<Shape> list = new ArrayList<Shape>();
		for (Map.Entry<Double, Shape> entry : this.shapeWithPerimeter.entrySet()) {
	        list.add(entry.getValue());
	    }
		return list;
	}
	
	/**
	 * 
	 * @return - List of Shapes in sorted according to Origin Distance
	 */
	public List<Shape> sortShapeWithOriginDistance(){
		List<Shape> list = new ArrayList<Shape>();
		for (Map.Entry<Double, Shape> entry : this.shapeWithOriginDistance.entrySet()) {
	        list.add(entry.getValue());
	    }
		return list;
	}
	
	/**
	 * 
	 * @return - List of Shapes in given Point is Enclosed
	 */
	public List<Shape> getShapesInPointIsEnclosed(Point point){
		List<Shape> list = new ArrayList<Shape>();
		for (Map.Entry<Shape, Double> entry : this.shapeWithArea.entrySet()) {
	        if(entry.getKey().isPointEnclosed(point)) {
	        	list.add(entry.getKey());
	        }
	    }
		return list;
	}
}
