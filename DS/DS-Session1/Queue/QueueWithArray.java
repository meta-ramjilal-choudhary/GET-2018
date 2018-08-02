
public class QueueWithArray implements Queue{

	private Data array[];
	private int frontIndex;
	private int rearIndex;
	
	QueueWithArray(){
		this.array = new Data[1000];
		this.frontIndex = -1;
		this.rearIndex = -1;
	}
	
	@Override
	public void enqueue(Data data) throws ArrayIndexOutOfBoundsException{
		
		if(this.isFull()) {
			throw new ArrayIndexOutOfBoundsException("Queue is Full !");
		}
		if(this.frontIndex == -1) {
			this.frontIndex ++;
			this.rearIndex ++;
		}
		else {
			this.rearIndex ++;
		}
		this.array[this.rearIndex] = data;
	}

	@Override
	public void dequeue() throws ArrayIndexOutOfBoundsException{
		
		if(this.isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Queue is Empty !");
		}
		this.frontIndex ++;
		
	}

	@Override
	public Data getFront() {
		if(this.isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Queue is Empty !");
		}
		return this.array[this.frontIndex];
	}

	@Override
	public boolean isEmpty() {
		
		return this.frontIndex > this.rearIndex;
	}
	
	/**
	 * 
	 * @return - true if Queue is full otherwise false
	 */
	public boolean isFull() {
		return this.rearIndex >= (this.array.length-1);
	}
	
	@Override
	public int getSize() {
		if(this.isEmpty()) {
			return 0;
		}
		return (this.rearIndex - this.frontIndex + 1);
	}
	
}
