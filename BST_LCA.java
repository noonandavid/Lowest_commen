
public class BST_LCA<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST
    private int count = 0;
    int [] list;
    
    /**
     * Private node class.
     */
    private class Node {
        private int val;         // associated data
        private Node left, right;  // left and right subtrees

        public Node(int val) {
            this.val = val;
        }
    }

    public void put(int val) {
        root = put(root,val);
    }

    private Node put(Node x,int val) {
        int compare = 0;
    	if (x == null) return new Node(val);
        if (x.val > val)
        	 compare = -1;
        else if (x.val > val)
        	compare = 1;
    	
        if      (compare < 0) x.left  = put(x.left,val);
        else if (compare > 0) x.right = put(x.right,val);
        else              x.val   = val;
        list [count] = val;
        count++;
        return x;
    }

    public int lowestCommonAncestor(int p,int q)
    {
    	boolean p_ck = false;
    	boolean q_ck = false;
    	for(int i = 0; i < count; i++){
    		if (p == list[i] )
    			p_ck = true;
    	if (p == list[i] )
			q_ck = true;
    	}	
    	if (p_ck == true && q_ck == true)
		{return lowestCommonAncestor(root,p,q).val;}
    	else return -1;
    }
  
  private Node lowestCommonAncestor(Node root, int p, int q) {
    Node m = root;
 
    if(m.val > p && m.val < q){
        return m;  
    }else if(m.val>p && m.val > q){
        return lowestCommonAncestor(root.left, p, q);
    }else if(m.val<p && m.val < q){
        return lowestCommonAncestor(root.right, p, q);
    }
 
    return root;
}

}

