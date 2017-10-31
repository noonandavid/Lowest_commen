import static org.junit.Assert.*;

import org.junit.Test;

public class LCA_DAG_TEST {

	
	
	@Test
	public void test() {
		DAG_LCA<Integer, Integer> dag  = new DAG_LCA<Integer, Integer>();
		assertEquals("Try LCA on an empty tree",-1,dag.lowestCommenAncestor(3,4));
		dag.create(1);
		dag.create(2);
		dag.create(3);
		dag.create(4);
		dag.create(5);
		dag.create(6);
		dag.create(8);
		dag.create(9);
		dag.create(7);
		assertEquals("Add a parent",true,dag.addParent(1, 0));
		assertEquals("Add a parent",true,dag.addParent(2, 0));
		assertEquals("Add a parent",true,dag.addParent(3, 2));
		assertEquals("Add a parent",true,dag.addParent(4, 2));
		assertEquals("Add a parent",true,dag.addParent(5, 4));
		assertEquals("Add a parent",true,dag.addParent(5, 3));
		assertEquals("Add a parent",true,dag.addParent(6, 1));
		assertEquals("Add a parent",true,dag.addParent(7, 6));
		assertEquals("Add a parent",true,dag.addParent(7, 4));
		assertEquals("Add a parent",true,dag.addParent(9, 4));
		assertEquals("Add a parent",true,dag.addParent(8, 5));
		assertEquals("Add a parent that creates a loop",false,dag.addParent(2, 8));
		assertEquals("Test a normal lca",2,dag.lowestCommenAncestor(3,4));
		assertEquals("Test a normal lca",0,dag.lowestCommenAncestor(5,6));
		assertEquals("Test a normal lca",4,dag.lowestCommenAncestor(8,7));
		assertEquals("Test a normal lca",2,dag.lowestCommenAncestor(3,9));
		assertEquals("Test an lca with one node missing",-1,dag.lowestCommenAncestor(3,956));
		assertEquals("Test an lca with both nodes missing",-1,dag.lowestCommenAncestor(333,933));
		
		
	}

}
