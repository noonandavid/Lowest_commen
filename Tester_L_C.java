import static org.junit.Assert.*;

import org.junit.Test;

public class Tester_L_C {

	@Test
	public void test() {
		 BST_LCA<Integer, Integer> bst = new BST_LCA<Integer, Integer>();
		 
		 assertEquals(-1, bst.lowestCommonAncestor(1,7));
		 bst.put(10);      
	     bst.put(5);       
	     bst.put(15);
	     bst.put(2);      
	     bst.put(7);       
	     bst.put(3);     
	     bst.put(1);      
		 
	     
		 assertEquals(5, bst.lowestCommonAncestor(1,7));
		 
		 assertEquals(10, bst.lowestCommonAncestor(5,15));
	      
		 assertEquals(5, bst.lowestCommonAncestor(5,5));
	    
	    
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
	    
	     assertEquals(15, bst.lowestCommonAncestor(14,20));
	}

}
