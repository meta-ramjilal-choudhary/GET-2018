import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueWithListTest {

	private QueueWithList queue;
	private Data data1;
	private Data data2;
	private Data data3;
	private Data data4;

	QueueWithListTest(){
		queue = new QueueWithList();
		data1 = new Data(111, "ram");
		data2 = new Data(200, "rahul");
		data3 = new Data(23, "Sohan");
		data4 = new Data(100, "Shubham");
	}
	
	@Test
	public void testEnqueu() {
		
		try {
			queue.enqueue(data1);
			queue.enqueue(data2);
			queue.enqueue(data3);
			Assertions.assertFalse(queue.isEmpty());
			Assertions.assertEquals(3, queue.getSize());
		}catch(NullPointerException e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testDequeue() {
		try {
			queue.dequeue();
			queue.enqueue(data1);
			queue.enqueue(data2);
			queue.enqueue(data3);
			queue.dequeue();
			assertEquals(2, queue.getSize());
			queue.dequeue();
			queue.dequeue();
			assertTrue(queue.isEmpty());
			assertEquals(0, queue.getSize());
			queue.enqueue(data2);
			queue.enqueue(data3);
			assertEquals(2, queue.getSize());
		}catch(NullPointerException e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testFront() {
		try {
			queue.enqueue(data1);
			queue.enqueue(data2);
			assertEquals(data1, queue.getFront());
		}catch(NullPointerException e) {
			System.out.println(e);
		}
	}

}
