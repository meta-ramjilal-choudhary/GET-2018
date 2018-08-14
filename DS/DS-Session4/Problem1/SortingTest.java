import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortingTest {
	
	SortingTest(){
	}
	
	@Test
	void test() {
		Sorting sort = new Sorting();
		sort.addEmp(1, "Ram", "jaipur");
		sort.addEmp(4, "Shubham", "Udaipur");
		sort.addEmp(2, "Ashish", "jaipur");
		sort.addEmp(3, "Komal", "Alwar");
		sort.addEmp(2, "Ashish", "jaipur");
		sort.addEmp(5, "Mayank", "Jodhpur");
		List<Employee> list1 = sort.naturalSort();
		int expected1[] = {1, 2, 3, 4, 5};
		int actual[] = new int[list1.size()];
		int i=0;
		for(Employee emp:list1) {
			actual[i] = emp.getEmpID();
			i++;
		}
		Assertions.assertArrayEquals(expected1, actual);
		i=0;
		List<Employee> list2 = sort.sortByName();
		for(Employee emp:list2) {
			actual[i] = emp.getEmpID();
			i++;
		}
		int expected2[] = {2, 3, 5, 1, 4};
		Assertions.assertArrayEquals(expected2, actual);
	}

}
