
public class StackWithLinkedList implements Stack{

	private Node topNode;
	private int totalNode;
	
	StackWithLinkedList(){
		this.topNode = null;
		this.totalNode = 0;
	}
	
	/**
	 * class Node with Data and next node address
	 * @author User29
	 *
	 */
	class Node{
		
		private Data data;
		private Node next;
		
		Node(Data data){
			this.data = data;
			this.next = null;
		}
	}
	
	@Override
	public void push(Data data) {
		Node node = new Node(data);
		if(this.topNode == null) {
			this.topNode = node;
		}
		else {
			node.next = this.topNode;
			this.topNode = node;
		}
		this.totalNode ++;
	}
	
	@Override
	public void pop() throws NullPointerException{
		
		if(this.topNode == null) {
			throw new NullPointerException("Stack is Empty!");
		}
		Node temp = this.topNode;
		this.topNode = this.topNode.next;
		temp = null;
		this.totalNode --;
	}
	
	@Override
	public Data getPeak() {
		
		if(this.topNode == null) {
			throw new NullPointerException("Stack is Empty!");
		}
		return this.topNode.data;
	}
	
	@Override
	public int getSize() {
		
		return this.totalNode;
	}
	
	@Override
	public boolean isEmpty() {
		return this.getSize() == 0;
	}
}
