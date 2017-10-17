import java.util.NoSuchElementException;


public class BST_LCA<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST
    private int count = 0;
    int [] list;
    
    /**
     * Private node class.
     */
    private class Node {
        private Key key;           // sorted by key
        private int val;         // associated data
        private Node left, right;  // left and right subtrees
        private int N;             // number of nodes in subtree

        public Node(Key key, int val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public void put(Key key, int val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, int val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
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
  
 public Node lowestCommonAncestor(Node root, int p, int q) {
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
