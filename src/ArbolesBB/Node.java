package ArbolesBB;

public class Node <T> {
    private T data;
    private long key;
    private Node right;
    private Node left;
    
    /**
     * Constructor de la clase
     * @param data 
     * @param key
     */
    public Node(T data, long key) {
        this.data = data;
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public boolean isLeaf() {
        return (this.left == null && this.right == null);
    }
    
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
    
    
}
