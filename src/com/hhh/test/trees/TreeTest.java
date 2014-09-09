package com.hhh.test.trees;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.hhh.trees.Tree;

public class TreeTest {

	Tree tree;
	
	@Before
	public void setUp() throws Exception {
		tree = new Tree(10);
	}

	@Test
	public void insertTestPositive(){
		System.out.println("check if the root is the leaf node after inserting");
		tree.insert(12);
		assertFalse(tree.getRoot().isLeafNode());
	}
	@Test
	public void insertTestNegative(){
		System.out.println("check if the root is the leaf node without inserting");
		assertTrue(tree.getRoot().isLeafNode());
	}
	@Test
	public void insertRecursiveTestPositive(){
		int sizeBefore = tree.getSize();
		System.out.println("check if the root is the leaf node after inserting");
		tree.insertRecursive(12, tree.getRoot());
		assertTrue(tree.getSize() == sizeBefore + 1);
	}
	
	@Test
	public void printInOrderTest(){
		tree.insert(5);tree.insert(2);tree.insert(4);tree.insert(1);
		tree.insert(13);tree.insert(15);tree.insert(12);tree.insertRecursive(17, tree.getRoot());
		System.out.println("Expected output in order 1, 2, 4, 5, 10, 12, 13, 15");
		tree.printInOrder(tree.getRoot());
		System.out.println("\n");
		assertTrue(tree.elementsInOrder.get(0)==1 && tree.elementsInOrder.get(3)==5 &&
				tree.elementsInOrder.get(4)==10 && tree.elementsInOrder.get(7)==15);
	}
	@Test
	public void printPreOrderTest(){
		tree.insert(5);tree.insert(2);tree.insert(4);tree.insert(1);
		tree.insert(13);tree.insert(15);tree.insert(12);
		System.out.println("Expected output in order 10, 5, 2, 1, 4, 13, 12, 15");
		tree.printPreOrder(tree.getRoot());
		System.out.println("\n");
		assertTrue(tree.elementsPreOrder.get(0)==10 && tree.elementsPreOrder.get(3)==1 &&
				tree.elementsPreOrder.get(4)==4 && tree.elementsPreOrder.get(7)==15);
	}
	@Test
	public void printPostOrderTest(){
		tree.insert(5);tree.insert(2);tree.insert(4);tree.insert(1);
		tree.insert(13);tree.insert(15);tree.insert(12);
		System.out.println("Expected output in order 1, 4, 2, 5, 12, 15, 13, 10");
		tree.printPostOrder(tree.getRoot());
		System.out.println("\n");
		assertTrue(tree.elementsPostOrder.get(0)==1 && tree.elementsPostOrder.get(3)==5 &&
				tree.elementsPostOrder.get(4)==12 && tree.elementsPostOrder.get(7)==10);
	}
	
	@Test
	public void lookUpTestPositive(){
		tree.insert(5);tree.insert(2);tree.insert(4);tree.insert(1);
		tree.insert(13);tree.insert(15);tree.insert(12);
		System.out.println("Expected output for lookUp 2: True (1, 4, 2, 5, 12, 15, 13, 10)");
		assertTrue(tree.lookUp(2));
	}
	@Test
	public void lookUpTestNegative() {
		tree.insert(5);tree.insert(2);tree.insert(4);tree.insert(1);
		tree.insert(13);tree.insert(15);tree.insert(12);
		System.out.println("Expected output for lookUp 3: False (1, 4, 2, 5, 12, 15, 13, 10)");
		assertFalse(tree.lookUp(3));
	}
	
	@Test
	public void getSizeTest() {
		tree.insert(5);tree.insert(2);tree.insert(4);tree.insert(1);
		tree.insert(13);tree.insert(15);tree.insert(12);tree.insert(11);
		assertTrue(tree.getSize() == 9);
	}
	
	@Test
	public void getMin() {
		tree.insert(5);tree.insert(2);tree.insert(4);tree.insert(1);
		tree.insert(13);tree.insert(15);tree.insert(12);tree.insert(11);
		assertTrue(tree.getMin() == 1);
	}
	@Test
	public void getMax() {
		tree.insert(5);tree.insert(2);tree.insert(4);tree.insert(1);
		tree.insert(13);tree.insert(15);tree.insert(12);tree.insert(11);
		assertTrue(tree.getMax() == 15);
	}
	
	@Test
	public void deleteRootTestPositive(){
		tree.insert(5);tree.insert(2);tree.insert(4);tree.insert(1);
		tree.insert(13);tree.insert(15);tree.insert(12);
		System.out.println("delete root");
		tree.delete(10);
		assertFalse(tree.lookUp(10));
	}
	@Test
	public void deleteLeafTest(){
		tree.insert(5);tree.insert(2);tree.insert(4);tree.insert(1);
		tree.insert(13);tree.insert(15);tree.insert(12);
		System.out.println("delete leaf - node without children");
		tree.delete(15);
		assertFalse(tree.lookUp(15));
	}
	@Test
	public void deleteNodeWithOneChildTest(){
		tree.insert(5);tree.insert(2);tree.insert(4);
		tree.insert(13);tree.insert(15);tree.insert(12);
		System.out.println("delete node with one child");
		tree.delete(2);
		assertFalse(tree.lookUp(2));
	}
	@Test
	public void deleteNodeWithTwoChildTestPositive(){
		tree.insert(7);tree.insert(4);tree.insert(3);tree.insert(5);tree.insert(1);tree.insert(6);
		tree.insert(13);tree.insert(15);tree.insert(12);
		System.out.println("delete node with two child");
		tree.delete(4);
		assertFalse(tree.lookUp(4));
	}

}
