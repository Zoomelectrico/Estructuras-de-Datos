/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolesBB;

/**
 *
 * @author Jose Roberto Quevedo
 */
public class BinarySearchTree <T> {
    // Atributos
    private Node<T> root;
    /**
     *
     */
    public BinarySearchTree() {
        this.root = null;
    }
    /**
     *
     */
    public BinarySearchTree(Node<T> root) {
        this.root = root;
    }
    public boolean isEmpty() {
        return this.root == null;
    }
    /**
     *
     * @param root
     * @return 
     */
    public int countLeafs(Node<T> root) {
        if (root != null) {
            if (root.isLeaf()) {
                return 1;
            } else {
                return (this.countLeafs(root.getLeft()) + this.countLeafs(root.getRight()));
            }
        } else {
            return 0;
        }
    }
    /*
    public T search(Node<T> root, T key) {
        if (root != null) {
            if (root.getData().equals(key)) {
                return root.getData();
            } else if (root.getData().) {
            }
        } else {
            return null;
        } 
    }
    */
}
