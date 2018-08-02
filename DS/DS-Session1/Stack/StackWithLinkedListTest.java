import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackWithLinkedListTest {

	private StackWithLinkedList stack;
	private Data data1;
	private Data data2;
	private Data data3;
	private Data data4;
	
	StackWithLinkedListTest(){
		
		stack = new StackWithLinkedList();
		data1 = new Data(111, "ram");
		data2 = new Data(200, "rahul");
		data3 = new Data(23, "Sohan");
		data4 = new Data(100, "Shubham");
	}
	

	@Test
	public void testPush() {
		
		try {
			stack.push(data1);
			stack.push(data2);
			stack.push(data3);
			stack.push(data4);
			assertEquals(4, stack.getSize());
		}catch(NullPointerException e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testPop() {
		try {
			stack.push(data2);
			stack.push(data3);
			stack.pop();
			assertEquals(1, stack.getSize());
			stack.pop();
			assertTrue(stack.isEmpty());
		}catch(NullPointerException e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testPeak() {
		try {
			stack.push(data2);
			stack.push(data3);
			assertEquals(data3, stack.getPeak());
		}catch(NullPointerException e) {
			System.out.println(e);
		}
	}

}
