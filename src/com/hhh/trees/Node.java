package com.hhh.trees;

public class Node {

	private Node left, right;
	private int data;
	
	public Node(int d) {
		data = d;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	public boolean isLeafNode(){
		return (this.getLeft()==null && this.getRight()==null);
	}
	
}
