import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class BinarySearchTree implements Dictionary{
	
	private Node rootNode;
	
	BinarySearchTree(String filePath){
		this.rootNode = null;
		this.jsonRead(filePath);
	}
	
	/**
	 * Tree node 
	 * @author User29
	 *
	 */
	class Node{
		
		private Pair pair;
		private Node leftNode;
		private Node rightNode;
		
		Node(Pair pair){
			this.pair = pair;
			this.leftNode = null;
			this.rightNode = null;
		}
		
		Node(Node node){
			this.pair = node.pair;
			this.leftNode = node.leftNode;
			this.rightNode = node.rightNode;
		}
		
		/**
		 * Copy pair to current node
		 * @param node - node with key value pair
		 */
		public void copyPair(Node node) {
			this.pair = node.pair;
		}
	}
	
	/**
	 * Read Json File
	 * @param filePath - Path of Json file
	 */
	private void jsonRead(String filePath) {
		try {
			JSONParser parser = new JSONParser();
			Object object = parser.parse(new FileReader(filePath));
			JSONArray listOfObjects = (JSONArray) object;
			Iterator<JSONObject> itr = listOfObjects.iterator();
			while(itr.hasNext()) {
				JSONObject obj = itr.next();
				Pair pair = new Pair( Integer.parseInt((String)obj.get("key")), (String)obj.get("value") );
				this.add(pair);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());;
		}
	}
	
	/**
	 * Traverse BST and find location for given key value pair
	 * @param root - Root node of current Subtree
	 * @param pair - Pair with key and value
	 * @return - Root node 
	 */
	private Node traverseAndInsert(Node root, Pair pair) {
		if(root == null) {
			return new Node(pair);
		}
		if(pair.getKey() < root.pair.getKey()) {
			root.leftNode = traverseAndInsert(root.leftNode, pair);
		}
		else if(pair.getKey() > root.pair.getKey()) {
			root.rightNode = traverseAndInsert(root.rightNode, pair);
		}
		return root;
	}

	/**
	 * Add Key Value pair to the dictionary
	 * @param pair
	 */
	public void add(Pair pair) {
		this.rootNode = this.traverseAndInsert(this.rootNode, pair);
	}
	
	/**
	 * Find successor node 
	 * @param node - node 
	 * @return - Successor node
	 */
	private Node inorderSucc(Node node) {
		Node current = node;
		while(current.leftNode != null) {
			current = current.leftNode;
		}
		return current;
	}

	/**
	 * Delete a node from BST
	 * @param node - Root node
	 * @param key - Key to be deleted
	 * @return - root node
	 */
	private Node deleteNode(Node node, int key) {
		if(node == null) {
			return node;
		}
		if(key < node.pair.getKey()) {
			node.leftNode =  this.deleteNode(node.leftNode, key);
		}
		else if(key > node.pair.getKey()) {
			node.rightNode =  this.deleteNode(node.rightNode, key);
		}
		else {
			if(node.leftNode == null) {
				return node.rightNode;
			}
			else if(node.rightNode == null) {
				return node.rightNode;
			}
			Node succNode = this.inorderSucc(node.rightNode);
			node.copyPair(succNode);
			node.rightNode = this.deleteNode(node.rightNode, succNode.pair.getKey());
		}
		return node;
	}
	
	/**
	 * Delete Key Value pair from the dictionary
	 * @param key - key of the pair
	 * @return - Deleted Pair
	 */
	public Pair delete(int key) {
		try {
			if(this.rootNode == null) {
				throw new NullPointerException("Binary Search Tree is Empty!");
			}
			Node node = this.deleteNode(this.rootNode, key);
			if(node == null) {
				throw new NullPointerException("No Such Value present for given key!");
			}
			return node.pair;
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	/**
	  * Search a node for given key
	 * @param node - Root node
	 * @param key - Key
	 * @return - Node with given key value pair
	 */
	private Node search(Node node, int key){
		if(node == null) {
			return node;
		}
		if(node.pair.getKey() == key) {
			return node;
		}
		else if(key < node.pair.getKey()) {
			return search(node.leftNode, key);
		}
		return search(node.rightNode, key);
	}
	
	/**
	 * Find Value in the dictionary corresponding to a specified key
	 * @param key - key of the pair
	 * @return - Value of the pair
	 */
	public String getPairValue(int key) {
		try {
			if(this.rootNode == null) {
				throw new NullPointerException("Binary Search Tree is Empty!");
			}
			Node node = search(this.rootNode, key);
			if(node == null) {
				throw new NullPointerException("No Such Value present for given key!");
			}
			return node.pair.getValue();
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	/**
	 * Inorder traversal and store pair in sortedPair List
	 * @param node - node of tree
	 * @param sortedPair - List of sorted pair
	 */
	private void inorder(Node node, List<Pair> sortedPair) {
		if(node != null) {
			inorder(node.leftNode, sortedPair);
			sortedPair.add(node.pair);
			inorder(node.rightNode, sortedPair);
		}
	}
	
	/**
	 * Sort all pair according to their keys
	 * @return - Sorted List of pairs
	 */
	public List<Pair> sortPairs() {
		List<Pair> sortedPair = new LinkedList<Pair>();
		this.inorder(this.rootNode, sortedPair);
		return sortedPair;
	}

	/**
	 * Inorder traversal and store pair in sortedPair List
	 * between two key1 and key2
	 * @param node - node of tree
	 * @param sortedPair - List of sorted pair
	 */
	private void inorderWithKeys(Node node, List<Pair> sortedPair, int key1, int key2) {
		if(node != null) {
			inorderWithKeys(node.leftNode, sortedPair, key1, key2);
			if(key1 <= node.pair.getKey() && node.pair.getKey() <= key2) {
				sortedPair.add(node.pair);
			}
			inorderWithKeys(node.rightNode, sortedPair, key1, key2);
		}
	}
	
	/**
	 * Sort list of key value pairs for all the keys >=key1 and <=key2
	 * @param key1 - Starting key
	 * @param key2 - ending key
	 * @return - Sorted List between key1 and key2
	 */
	public List<Pair> sortPairBetweenKeys(int key1, int key2) {
		List<Pair> sortedPair = new LinkedList<Pair>();
		this.inorderWithKeys(this.rootNode, sortedPair, key1, key2);
		return sortedPair;
	}
}
