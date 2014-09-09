package com.hhh.trees;

import java.util.ArrayList;

public class Tree {

	private Node root;
	//populated after running in order method
	public ArrayList<Integer> elementsInOrder = new ArrayList<Integer>();
	//populated after running pre order method
	public ArrayList<Integer> elementsPreOrder = new ArrayList<Integer>();
	//populated after running post order method
	public ArrayList<Integer> elementsPostOrder = new ArrayList<Integer>();
	
	public Tree(int d) {
		root = new Node(d);
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void insert(int d){
		Node current = root;
		Node parent = null;
//		track down to bottom
		while(current != null){
			if(d < current.getData()){
				parent = current;
				current = current.getLeft();
			}else {
				parent = current;
				current = current.getRight();
			}
		}
//		add node on the appropriate side
		if(d<parent.getData())
			parent.setLeft(new Node(d));
		else
			parent.setRight(new Node(d));
	}
	
	public Node insertRecursive(int d, Node node) { 
		if(node == null)
			return new Node(d);
		else if(d < node.getData()) {
			node.setLeft(insertRecursive(d, node.getLeft()));
			return node;
		}else {
			node.setRight(insertRecursive(d, node.getRight()));
			return node;
		}
	}
	
	public void printInOrder(Node root){
		if(root!=null){
			printInOrder(root.getLeft());
			System.out.print("-->"+root.getData());
			this.elementsInOrder.add(root.getData());
			printInOrder(root.getRight());
		}
	}
	
	public void printPreOrder(Node root){
		if(root!=null){
			System.out.print("-->"+root.getData());
			this.elementsPreOrder.add(root.getData());
			printPreOrder(root.getLeft());
			printPreOrder(root.getRight());
		}
	}
	
	public void printPostOrder(Node root){
		if(root!=null){
			printPostOrder(root.getLeft());
			printPostOrder(root.getRight());
			System.out.print("-->"+root.getData());
			this.elementsPostOrder.add(root.getData());
		}
	}
	
	public int getSize() {
		return getSizeFromNode(getRoot());
	}
	
	private int getSizeFromNode(Node node) {
		if(node == null)
			return 0;
		else
			return 1 + getSizeFromNode(node.getLeft()) + getSizeFromNode(node.getRight());
	}

	public int getMin() {
		Node current = getRoot();
		while(current.getLeft()!=null){
			current = current.getLeft();
		}
		return current.getData();
	}
	
	public int getMax() {
		Node current = getRoot();
		while(current.getRight()!=null){
			current = current.getRight();
		}
		return current.getData();
	}
	
	public boolean lookUp(int searchKey){
		return lookUpFromNode(searchKey, getRoot());
	}

	private boolean lookUpFromNode(int searchKey, Node node) {
		if(node == null)
			return false;
		else if (searchKey == node.getData()) 
			return true;
		else if (searchKey < node.getData())
			return lookUpFromNode(searchKey, node.getLeft());
		else 
			return lookUpFromNode(searchKey, node.getRight());
	}
	
	public Node delete(int deleteKey) {
		return deleteFromNode(deleteKey, getRoot());
	}

	private Node deleteFromNode(int deleteKey, Node node) {
		if(node == null)
			return node;
		else if(deleteKey < node.getData()){
			node.setLeft(deleteFromNode(deleteKey, node.getLeft()));
			return node;
		}
		else if(deleteKey > node.getData()){
			node.setRight(deleteFromNode(deleteKey, node.getRight()));
			return node;
		}
		else{
//			No child
			if(node.getLeft() == null && node.getRight() == null)
				return null;
//			Only One Child
			else if(node.getLeft() == null)
				return node.getRight(); 
			else if(node.getRight() == null)
				return node.getLeft();
//			Two Children
			else {
				Node minNode = node.getRight();
				while(minNode.getLeft() != null)
					minNode = minNode.getLeft();
				node.setData(minNode.getData());
				deleteFromNode(minNode.getData(), minNode);
				return node;
			}
				
		}
	}
	
}
