
public class QueueWithList implements Queue{

	private Node frontNode;
	private Node rearNode;
	private int totalNode;
	
	QueueWithList(){
		this.frontNode = null;
		this.rearNode = null;
		this.totalNode = 0;
	}
	
	class Node{
		private Data data;
		private Node next;
		
		/**
		 * Class Node with data and next node address
		 * @param data
		 */
		Node(Data data){
			this.data = data;
			this.next = null;
		}
	}

	@Override
	public void enqueue(Data data){
		Node node = new Node(data);
		if(this.isEmpty()) {
			this.frontNode = node;
			this.rearNode = node;
		}
		else {
			this.rearNode.next = node;
			this.rearNode = this.rearNode.next;
		}
		this.totalNode ++;
	}

	@Override
	public void dequeue() throws NullPointerException{
		if(this.isEmpty()) {
			throw new NullPointerException("Queue is Empty!");
		}
		this.frontNode = this.frontNode.next;
		this.totalNode --;
	}

	@Override
	public Data getFront() {
		if(this.isEmpty()) {
			throw new NullPointerException("Queue is Empty!");
		}
		return this.frontNode.data;
	}

	@Override
	public boolean isEmpty() {
		return (this.frontNode == null) ? true : false;
	}

	@Override
	public int getSize() {
		return (this.totalNode < 0) ? 0 : this.totalNode;
	}
}
