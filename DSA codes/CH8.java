
import java.util.Iterator;

import javax.swing.text.Position;
public class CH8 {
    public interface Tree<E> extends Iterable<E> {
        //Note that this definition do NOT determine an exact number of children for each node.
        Position<E> root();
        Position<E> parent(Position<E> p) throws IllegalArgumentException;
        Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;
        int numChildren(Position<E> p) throws IllegalArgumentException;       
        
        int size();
        boolean isEmpty();
        Iterator<E> iterator();
        Iterable<Position<E>> positions();
        
        boolean isInternal(Position<E> p) throws IllegalArgumentException;
        boolean isExternal(Position<E> p) throws IllegalArgumentException;
        boolean isRoot(Position<E> p) throws IllegalArgumentException;
    }

    public abstract class AbstractTree<E> implements Tree<E>{
        public boolean isInternal(Position<E> p) throws IllegalArgumentException{
            return numChildren(p) > 0;
        }

        public boolean isExternal(Position<E> p) throws IllegalArgumentException{
            return numChildren(p) == 0;
        }
        
        public boolean isRoot(Position<E> p) throws IllegalArgumentException{
            return p == root();
        }
    }
        
        //depth (tail recursive)
        //hight (Bad implementation)
        //hight (Good implementation)
       
        public int goodHeigth(){
            return height(root());
        }

        private int height (Position<E> p){
            int h = 0;
            for(position<E> c: p.children()){
                h = Math.max(h,1+height(c));
            }
            return h;
        }

    public boolean isProper (){
    return proper(root());
    }

    private boolean proper (Position<E> p){
        int c = numChildren(p);
        
        if (numChildren(p)==0) return true;
        
        if (numChildren(p)==2){
            for (Position<E> b: children(p)){
                if (!proper(b)) return false; 
            }
            return true;
        }
        return false;
    }

    //perfect BT (poper && 2^h - 1 nodes)

    //skewed BT (numNodes == h + 1)

    //complete BT (I think this is the hardest one)
    
    public interface BinaryTree<E> extends Tree<E>{
        Position<E> left(Position<E> p) throws IllegalArgumentException;
        Position<E> right(Position<E> p) throws IllegalArgumentException;
        Position<E> sibling(Position<E> p) throws IllegalArgumentException;
    }

    public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E>{
        //sibling(position) method => position
        //numChildren(position) method =>integer
        //Children(position) method => iterable 
    }

    public class LinkedBinaryTree<E> extends AbstractBinaryTree<E>{
        //protected static class, not private, as it will be implemented later
        protected static class Node<E> implements Position<E>{
            private E element;
            // ...
        }

        //instance variables

        //constructor

        //utility protected methods (validate, createNode)
        // No need for addBetween method
    }


    // AI code (SHAME)
        /**
     * An implementation of a Binary Tree using an array-based structure with Integers.
     * This approach uses "Level Numbering" where:
     * - Root is at index 0
     * - Left Child of i is at 2*i + 1
     * - Right Child of i is at 2*i + 2
     * - Parent of i is at (i - 1) / 2
     * * Note: This version replaces the generic Position<E> abstraction with direct 
     * integer indices and uses Integer elements.
     */
    public class ArrayBinaryTree {

        // --- Instance Variables ---
        private Integer[] data; // The storage array (null means empty)
        private int size = 0;   // Number of valid elements
        private static final int DEFAULT_CAPACITY = 128;

        // --- Constructors ---
        public ArrayBinaryTree() {
            this(DEFAULT_CAPACITY);
        }

        public ArrayBinaryTree(int capacity) {
            data = new Integer[capacity];
        }

        // --- Accessor Methods ---

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Returns the index of the root (always 0).
         * Returns -1 if the tree is empty.
         */
        public int root() {
            if (isEmpty()) return -1;
            return 0;
        }

        /**
         * Returns the index of the parent of node at index i.
         * Returns -1 if i is the root.
         */
        public int parent(int i) {
            if (i == 0) return -1;
            return (i - 1) / 2;
        }

        /**
         * Returns the index of the left child of node at index i.
         * Returns -1 if no left child exists.
         */
        public int left(int i) {
            int leftIndex = 2 * i + 1;
            if (leftIndex >= data.length || data[leftIndex] == null) return -1;
            return leftIndex;
        }

        /**
         * Returns the index of the right child of node at index i.
         * Returns -1 if no right child exists.
         */
        public int right(int i) {
            int rightIndex = 2 * i + 2;
            if (rightIndex >= data.length || data[rightIndex] == null) return -1;
            return rightIndex;
        }

        /**
         * Returns the element stored at index i.
         */
        public Integer getElement(int i) {
            if (i < 0 || i >= data.length || data[i] == null)
                throw new IllegalArgumentException("Invalid index: " + i);
            return data[i];
        }

        // --- Update Methods ---

        /**
         * Places element e at the root of an empty tree.
         */
        public void addRoot(Integer e) {
            if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
            data[0] = e;
            size = 1;
        }

        /**
         * Creates a new left child of index i storing element e.
         * Returns the index of the new child.
         */
        public int addLeft(int i, Integer e) {
            if (i < 0 || i >= data.length || data[i] == null)
                throw new IllegalArgumentException("Parent node does not exist");
                
            int leftIndex = 2 * i + 1;
            
            if (leftIndex >= data.length) 
                throw new IllegalStateException("Tree capacity exceeded");
            if (data[leftIndex] != null)
                throw new IllegalArgumentException("Node already has a left child");
                
            data[leftIndex] = e;
            size++;
            return leftIndex;
        }

        /**
         * Creates a new right child of index i storing element e.
         * Returns the index of the new child.
         */
        public int addRight(int i, Integer e) {
            if (i < 0 || i >= data.length || data[i] == null)
                throw new IllegalArgumentException("Parent node does not exist");

            int rightIndex = 2 * i + 2;
            
            if (rightIndex >= data.length) 
                throw new IllegalStateException("Tree capacity exceeded");
            if (data[rightIndex] != null)
                throw new IllegalArgumentException("Node already has a right child");
                
            data[rightIndex] = e;
            size++;
            return rightIndex;
        }

        /**
         * Replaces the element at index i with e and returns the old element.
         */
        public Integer set(int i, Integer e) {
            if (i < 0 || i >= data.length || data[i] == null)
                throw new IllegalArgumentException("Node does not exist");
                
            Integer temp = data[i];
            data[i] = e;
            return temp;
        }
    }

    public void preorder(){
        PreOrder(root());
    }

    private void PreOrder(Position<E> p){
        //visit(p);
        System.out.println(p.getElement());
        for (Position<E> c: children(p)){
            PreOrder(c);
        } 
    }

    public void postorder(){
        PostOrder(root());
    }

    private void PostOrder(Position<E> p){
        System.out.println(p.getElement());
        for (Position<E> c: children(p)){
            PostOrder(c);
        } 
    }

    public void postorder(){
        PostOrder(root());
    }

    private void PostOrder(Position<E> p){
        System.out.println(p.getElement());
        for (Position<E> c: children(p)){
            PostOrder(c);
        } 
    }

    //Inorder

    //level order (BFS)

    //Euler tour

    //DFS
}
