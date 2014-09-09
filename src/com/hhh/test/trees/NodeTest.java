package com.hhh.test.trees;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.hhh.trees.Node;

public class NodeTest {

	Node root;
	
	@Before
	public void setUp() throws Exception {
		root = new Node(10);
	}

	@Test
	public void nodeCreation(){
		assertTrue(root.getData()==10);
	}
	
	@Test
	public void testIsLeafNode(){
		Node testNode = new Node(5);
		assertTrue(testNode.isLeafNode());
	}
	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

}
