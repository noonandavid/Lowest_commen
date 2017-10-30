import static org.junit.Assert.*;

import org.junit.Test;

public class LCA_DAG_TEST {

	
	
	@Test
	public void test() {
		DAG_LCA<Integer, Integer> dag  = new DAG_LCA<Integer, Integer>();
		assertEquals(-1,dag.lowestCommenAncestor(3,4));
		dag.create(1);
		dag.create(2);
		dag.create(3);
		dag.create(4);
		dag.create(5);
		dag.create(6);
		dag.create(8);
		dag.create(9);
		dag.create(7);
		dag.addParent(1, 0);
		dag.addParent(2, 0);
		dag.addParent(3, 2);
		dag.addParent(4, 2);
		dag.addParent(5, 4);
		dag.addParent(5, 3);
		dag.addParent(6, 1);
		dag.addParent(7, 6);
		dag.addParent(7, 4);
		dag.addParent(9, 4);
		dag.addParent(8, 5);
		assertEquals(2,dag.lowestCommenAncestor(3,4));
		assertEquals(0,dag.lowestCommenAncestor(5,6));
		assertEquals(4,dag.lowestCommenAncestor(8,7));
		assertEquals(2,dag.lowestCommenAncestor(3,9));
		assertEquals(-1,dag.lowestCommenAncestor(3,956));
		
	}

}
