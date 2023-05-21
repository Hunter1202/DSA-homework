package homework5;

public class LinkedBinaryTree<E,T> implements BinaryTreeInterface<T> {
    public static class Node<E> {
        public E element;
        public Node<E> parent;
        public Node<E> left;
        public Node<E> right;

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild){
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public Node<E> getParent() {
            return parent;
        }
    }

    public Node<E> root;
    public int size;

    public LinkedBinaryTree(){
        root = null;
        size = 0;
    }

    public Node<E> validate(T p) throws IllegalArgumentException {
        if(!(p instanceof Node)){
            throw new IllegalArgumentException ("Vị trí không hợp lệ");
        }
        Node<E> node = (Node<E>) p;
        if (node.parent == node){
            throw new IllegalArgumentException ("p không có ở trong tree");
        }
        return node;
    }

    public T root(){
        return (T) root;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int numChildren(T p) throws IllegalArgumentException  {
        Node<E> node = validate(p);
        int count = 0;
        if (node.left != null){
            count++;
        }
        if (node.right != null){
            count++;
        }
        return count;
    }

    public T parent(T p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return (T) node.parent;
    }

    public T left(T p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return (T) node.left;
    }

    public T right(T p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return (T) node.right;
    }

    public T sibling(T p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> parent = node.parent;
        if(parent == null){
            return null;
        }
        if(node == parent.left){
            return (T) parent.right;
        } else {
            return (T) parent.left;
        }
    }

    public Node<E> addRoot(E element) throws IllegalStateException{
        // Add element to root of an empty tree
        if(!isEmpty()){
            throw new IllegalStateException("Tree is not empty");
        }
        root = new Node<>(element, null, null, null);
        size = 1;
        return root;
    }

    public Node<E> addLeft(T p, E element) throws IllegalArgumentException{
        // Add element to left child node of p if empty
        Node<E> parent = validate(p);
        if(parent.left != null){
            throw new IllegalArgumentException("p already has left child");
        }
        Node<E> child = new Node<>(element, parent, null, null);
        parent.left = child;
        size++;
        return child;
    }

    public Node<E> addRight(T p, E element) throws IllegalArgumentException{
        // Add element to right child node of p if empty
        Node<E> parent = validate(p);
        if(parent.right != null){
            throw new IllegalArgumentException("p already has right child");
        }
        Node<E> child = new Node<>(element, parent, null, null);
        parent.right = child;
        size++;
        return child;
    }

    public void set(T p, E element) throws IllegalArgumentException {
        // set element to node p
        Node<E> node = validate(p);
        node.element = element;
    }
}
