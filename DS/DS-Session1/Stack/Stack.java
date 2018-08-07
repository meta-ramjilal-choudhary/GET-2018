
public interface Stack {

	/**
	 * Push Data inside Stack
	 * @param data - Date value
	 */
	public void push(Data data);
	
	/**
	 * Pop top element of the stack
	 * @param data - data value
	 * @return -  true if element popped otherwise false
	 */
	public void pop();
	
	/**
	 * 
	 * @return - Top element of the stack
	 */
	public Data getPeak();
	
	/**
	 * 
	 * @return - size of the Stack
	 */
	public int getSize();
	
	/**
	 * @return - True if stack is empty otherwise false;
	 */
	public boolean isEmpty();
}
