import static org.junit.Assert.*;

import org.junit.Test;

public class Tester_L_C {

	@Test
	public void test() {
		 BST_LCA<Integer, Integer> bst = new BST_LCA<Integer, Integer>();
		 
		 assertEquals("Checking an empty tree",-1, bst.lowestCommonAncestor(1,7));
		 bst.put(10);      
	     bst.put(5);       
	     bst.put(15);
	     bst.put(2);      
	     bst.put(7);       
	     bst.put(3);     
	     bst.put(1);      
		 
	     assertEquals("Testing where one node is present and the other is not",-1, bst.lowestCommonAncestor(45,7));
		 assertEquals("Twesting where both nodes are present",5, bst.lowestCommonAncestor(1,7));
		 
		 assertEquals("Testing where both nodes are present and the lca is the root",10, bst.lowestCommonAncestor(5,15));
	      
		 assertEquals("Where both are the same",5, bst.lowestCommonAncestor(5,5));
	    
	    
	     bst.put(6);       
	     bst.put(4);     
	     bst.put(9);      
	     bst.put(8);       
	     bst.put(12);     
	     bst.put(18);      
	     bst.put(11);       
	     bst.put(13);     
	     bst.put(17);      
	     bst.put(20);       
	     bst.put(14);     
	    
	     assertEquals("Checking a deeper tree",15, bst.lowestCommonAncestor(14,20));
	}

}
