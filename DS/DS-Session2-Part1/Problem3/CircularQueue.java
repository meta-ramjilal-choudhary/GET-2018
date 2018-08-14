
public class CircularQueue implements Queue{

	private Data array[];
	private int frontIndex;
	private int rearIndex;
	
	CircularQueue(){
		this.array = new Data[5];
		this.frontIndex = -1;
		this.rearIndex = -1;
	}
	
	public void enqueue(Data data) throws ArrayIndexOutOfBoundsException{
		if((this.rearIndex == this.array.length-1 && this.frontIndex == 0) ||(this.rearIndex == this.frontIndex-1) ) {
			throw new ArrayIndexOutOfBoundsException("Queue is full !");
		}
		else if(this.frontIndex == -1) {
			this.frontIndex = 0;
			this.rearIndex = 0;
		}
		else {
			this.readIndex = (this.rearIndex == this.array.length) ? 0 : this.rearIndex ++;
		}
		this.array[this.rearIndex] = data;
	}

	public void dequeue() throws ArrayIndexOutOfBoundsException{
		if(this.frontIndex == -1) {
			throw new ArrayIndexOutOfBoundsException("Queue is Empty!");
		}
		else if(this.frontIndex == this.rearIndex) {
			this.frontIndex = -1;
			this.rearIndex = -1;
		}
		else {
			this.frontIndex = (this.frontIndex == this.array.length) ? 0 : this.frontIndex ++;
		}
	}

	public Data getFront() {
		return this.array[this.frontIndex];
	}

	public boolean isEmpty() {
		return this.frontIndex == -1;
	}

	public int getSize() {
		if(this.frontIndex == -1) {
			return 0;
		}
		else if(this.rearIndex < this.frontIndex) {
			return (this.array.length - (this.frontIndex - this.rearIndex - 1) + 1);
		}
		return (this.rearIndex - this.frontIndex + 1);
	}

	
}
