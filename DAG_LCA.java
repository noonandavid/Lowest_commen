
import java.util.ArrayList;
import java.util.HashMap;

public class DAG_LCA<Key extends Comparable<Key>, Value> {
	 public Node root = new Node (0);
	 HashMap<Integer,Node> tree = new HashMap<>();

	 private class Node {  
		 private int val;         // associated data
	        private ArrayList<Integer> parents;
	        private int rank;
	        
	        public Node(int val) {
	            this.val = val;
	            this.rank = 0;
	            parents = new ArrayList<Integer>();
	        }
	    }

	public void create (int x){
		if (!tree.containsKey(x))
		{
		Node a = new Node (x);
		a.parents.add(x);
		tree.put(a.val, a);}
	}
	
	public boolean addParent(int a, int b){
		Node x = tree.get(a);
		if (b == 0){
				x.rank = 1;
				return true;
			}
		else{
			Node y = tree.get(b);
			if (y.parents.contains(a)){
				System.out.println(a + " is an invalid input as it creates a cycle.");
				return false;
				}else{
				smartCombine(x.parents, y.parents);
				if (y.rank  > x.rank)
				{ x.rank = y.rank + 1;}
				return true;
			}
		}
	}
	public static void smartCombine(ArrayList<Integer> first, ArrayList<Integer> second) {
	     for(Integer num : second) {      // iterate through the second list
	         if(!first.contains(num)) {   // if first list doesn't contain current element
	             first.add(num);          // add it to the first list
	         }
	     }
	}  

	public int lowestCommenAncestor(int a,int b){
		Node x;
		Node y;
		if (tree.containsKey(a)){
		x = tree.get(a);}
		else {
			System.out.println(a + " is not present in the graph.");
			return -1;
		}
		if (tree.containsKey(b)){
		y = tree.get(b);}
		else {
			System.out.println(b + " is not present in the graph.");
			return -1;
		}
		int rankx = 0;
		int lca = 0;
		ArrayList<Integer> duplicatevalues = new ArrayList<Integer>();
		
		for (Integer finalval : x.parents) {
		    if (y.parents.contains(finalval)) {
		        duplicatevalues.add(finalval);
		    } 
		}
		    for (int i = 0; i < duplicatevalues.size(); i++) {
				
		    	if (tree.get(duplicatevalues.get(i)).rank > rankx ){
					 lca = duplicatevalues.get(i);
				rankx = tree.get(duplicatevalues.get(i)).rank;
				}
			}
		return lca;
	}
	
}
