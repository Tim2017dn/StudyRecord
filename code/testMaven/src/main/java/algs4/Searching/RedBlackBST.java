package algs4.Searching;

public class RedBlackBST<Key extends Comparable<Key>,Value> {


    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node{
        private Key key;
        private Value val;
        private Node left,right;
        private boolean color;
        private int size;

        public Node(Key key,Value val,boolean color,int size){
            this.key = key;
            this.val = val;
            this.color = color;
            this.size = size;
        }

    }

    public RedBlackBST(){}

    public boolean isEmpty(){
        return root == null;
    }

    private boolean isRed(Node x) {
        if (x == null) {return false;}
        return x.color == RED;
    }

    public Value get(Key key){
        if(key == null) {throw new IllegalArgumentException("argument to get() is null");}
        return get(root,key);
    }

    private Value get(Node x,Key key){
        while(x != null){
            int cmp = key.compareTo(x.key);
            if (cmp<0)      {x=x.left;}
            else if(cmp>0)  {x=x.right;}
            else            {return x.val;}
        }
        return null;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public void put(Key key,Value val){

        root = put(root,key,val);
        root.color = BLACK;
    }

    private Node put(Node h,Key key,Value val){
        if (h == null) {return new Node(key,val,RED,1);}
        int cmp = key.compareTo(h.key);
        if       (cmp<0)  {h.left = put(h.left ,key ,val);}
        else if (cmp > 0) {h.right = put(h.right, key ,val);}
        else              {h.val = val;}

        h.size = size(h.left) + size(h.right) + 1;


        if( isRed(h.right) && !isRed(h.left)) {h = rorateLeft(h);}
        if( isRed(h.left) && isRed(h.left.left)) {h = rotateRight(h);}
        if( isRed(h.left) && isRed(h.right)) {flipColors(h);}
        h.size = size(h.left) + size(h.right) +1;

        return h;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {return 0;}
        return x.size;
    }


    private Node rotateRight(Node h){

        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }


    private Node rorateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    private void flipColors(Node h) {
        // h must have opposite color of its two children
        // assert (h != null) && (h.left != null) && (h.right != null);
        // assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
        //    || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }


    public static void main(String[] args) {

        RedBlackBST<String,Integer> st = new RedBlackBST<String, Integer>();
        //SEARCHXMPL
        String[] key = {"S","E","A","R","C","H","X","M","P","L"};
        for(int i= 0 ;i<10;i++){
            st.put(key[i],i);
        }


    }

}
