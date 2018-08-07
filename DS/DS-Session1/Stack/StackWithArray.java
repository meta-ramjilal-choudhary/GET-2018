
public class StackWithArray implements Stack{
	
	private Data array[];
	private int topIndex;
	
	StackWithArray(){
		array = new Data[1000];
		topIndex = -1;
	}
	

	@Override
	public void push(Data data) throws ArrayIndexOutOfBoundsException{
		if(this.topIndex >= (this.array.length-1) ) {
			throw new ArrayIndexOutOfBoundsException("Stack Overflow!");
		}
		this.topIndex ++;
		this.array[this.topIndex] = data;
	}
	
	@Override
	public void pop() throws ArrayIndexOutOfBoundsException{
		if(this.topIndex < 0) {
			throw new ArrayIndexOutOfBoundsException("Stack Underflow!");
		}
		this.topIndex --;
	}
	
	@Override
	public Data getPeak() throws ArrayIndexOutOfBoundsException{
		if(this.topIndex < 0) {
			throw new ArrayIndexOutOfBoundsException("Stack is Empty!");
		}
		return this.array[this.topIndex];
	}
	
	@Override
	public int getSize() {
		if(this.topIndex < 0) {
			return 0;
		}
		return this.topIndex + 1;
	}
	
	@Override
	public boolean isEmpty() {
		return this.getSize() == 0;
	}
}
