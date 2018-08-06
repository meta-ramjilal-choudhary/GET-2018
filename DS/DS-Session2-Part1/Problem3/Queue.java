
public interface Queue {

	/**
	 * Add Data at Queue
	 * @param data - data value
	 */
	public void enqueue(Data data);
	
	/**
	 * Remove data from Queue
	 */
	public void dequeue();
	
	/**
	 * 
	 * @return - front Data of Queue
	 */
	public Data getFront();
	
	/**
	 * Check whether Queue is Empty or not
	 * @return - true if Queue is empty otherwise false
	 */
	public boolean isEmpty();
	
	/**
	 * 
	 * @return - size of queue
	 */
	public int getSize();

}
