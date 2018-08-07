
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class OperationOnJson implements NestedList{
	
	private LinkedList<LinkedList<Long>> integerList;
	private long largestValue;
	private long sumOfAllValues;
	
	OperationOnJson(String filePath){
		try {
			JSONParser parser = new JSONParser();
			Object object = parser.parse(new FileReader(filePath));
			JSONArray listOfObjects = (JSONArray) object;
			Iterator<JSONObject> itr = listOfObjects.iterator();
			this.largestValue = Long.MIN_VALUE;
			this.sumOfAllValues = 0;
			this.integerList = new LinkedList<LinkedList<Long>>();
			while(itr.hasNext()) {
				JSONArray listContents = (JSONArray)itr.next().get("list");
				Iterator<Long> it = listContents.iterator();
				LinkedList<Long> list = new LinkedList<Long>();
				while(it.hasNext()) {
					Long x = it.next();
					list.add(x);
					this.largestValue = Math.max(this.largestValue, x);
					this.sumOfAllValues += x;
				}
				this.integerList.add(list);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public long getSumOfAllValues() {
		return this.sumOfAllValues;
	}

	public long getLargestValue() {
		return this.largestValue;
	}

	public boolean findValue(long value) {
		for(LinkedList<Long> intList: this.integerList) {
			for(Long number: intList) {
				if(value == number) {
					return true;
				}
			}
		}
		return false;
	}
	
	
}
