import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NestedListTHTest {

	@Test
	void test1() {
		NestedListTH nested = new NestedListTH();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(23);
		list.add(53);
		list.add(343);
		nested.add(2);
		nested.add(34);
		nested.add(list);
		nested.add(80);
		nested.add(856);
		Assertions.assertEquals(23,nested.traverse("TTHH"));
		Assertions.assertEquals(null,nested.traverse("TTHHH"));
	}
	
	@Test
	void test2() {
		NestedListTH nested = new NestedListTH();
		List<Object> objects = new ArrayList<Object>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list1.add(23);
		list1.add(53);
		list1.add(343);
		list2.add(909);
		list2.add(1231);
		objects.add(890);
		objects.add(list1);
		nested.add(2);
		nested.add(34);
		nested.add(objects);
		nested.add(80);
		nested.add(list2);
		Assertions.assertEquals(53,nested.traverse("TTHTHTH"));
	}

}
