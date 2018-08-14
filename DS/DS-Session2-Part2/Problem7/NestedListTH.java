import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedListTH {

	List<Object> nestedList = new LinkedList<Object>();
	
	NestedListTH(){}
	
	/**
	 * Add object to the list
	 * @param object - object to be add
	 */
	public void add(Object object) {
		this.nestedList.add(object);
	}
	
	/**
	 * 
	 * @param posString - Position String 
	 * @return - Object in nested list
	 */
	public Object traverse(String posString) {
		try {
			Object object = this.nestedList;
			for(int i=0; i<posString.length()-1; i++) {
				if(posString.substring(i, i+1).equals("T")) {
					if(object instanceof List) {
						List<Integer> list = (List)object;
						list.remove(list.get(0));
					}
					else {
						throw new NullPointerException("Error - No List found");
					}
				}
				else {
					if(object instanceof List) {
						object = ((List) object).get(0);
					}
					else {
						throw new NullPointerException("Error - No List found");
					}
				}
			}
			if(posString.substring(posString.length()-1).equals("T")) {
				if(object instanceof List) {
					List<Integer> list = (List)object;
					list.remove(list.get(0));
				}
				else {
					throw new NullPointerException("Error - No List found");
				}
			}
			else if(posString.substring(posString.length()-1).equals("H")) {
				if(object instanceof List) {
					object = ((List)object).get(0);
					if(object instanceof List) {
						throw new NullPointerException("Error - No Element found");	
					}
					return object;
				}
				else {
					throw new NullPointerException("Error - No List found");
				}
			}
		}catch(NullPointerException e) {
			System.out.println(e);
		}catch(IndexOutOfBoundsException e) {
			System.out.println("No Such element or list found");
		}
		return null;
	}
}
