public class CH3 {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(10);
        list.addLast(20);
        list.addFirst(5);
        
        System.out.println("First Element: " + list.toString()); // Output: 5
        System.out.println("First Element: " + list.first()); // Output: 5
        System.out.println("Last Element: " + list.last());   // Output: 20
        System.out.println("Size: " + list.size());           // Output: 3
        System.out.println("Removed Element: " + list.removeFirst()); // Output: 5
        System.out.println("New First Element: " + list.first()); // Output: 10
    }
}


class SinglyLinkedList<E>{
    private static class Node<E>{
        private E elem;
        private Node<E> next;

        //constructor
        public Node(E elem, Node<E> next){
            this.elem = elem;
            this.next = next;
        }

        //getters
        public E getElem(){
            return this.elem;
        }
        public Node<E> next(){
            return this.next;
        }

        //setters
        public void setElem(E elem){
            this.elem = elem;
        }
        public void setNext(Node<E> next){
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    //constructor
    public SinglyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    //add first
    public void addFirst(E elem){
        Node<E> newHead = new Node<E>(elem, head);
        if(size == 0){
            tail = newHead;
        }
        head = newHead;
        size++;
    }

    public void addLast(E elem){
        Node<E> newTail = new Node<>(elem, null);
        if (size ==0){
            head = newTail; 
        } else {
            tail.setNext(newTail);
        }
        tail = newTail;
        size++;
    }
 
    public int size(){
        return size;
    }
 
    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if(isEmpty()) return null;
        return head.getElem();
    }
 
    public E last(){
        if(isEmpty()) return null;
        return tail.getElem();
    }
 
    public E removeFirst(){
        if (size==0)return null;
        E returnedElement = head.getElem();
        head = head.next();
        size--;
        return returnedElement;
   } 

    public SinglyLinkedList<E> reverseList(SinglyLinkedList<E> sll) {
        SinglyLinkedList<E> reversed = new SinglyLinkedList<>();

        while (!sll.isEmpty()){
            reversed.addFirst(sll.first());
            sll.removeFirst();
        }
        return reversed;
    }

    
}


class DoublyLinkedList<E>{
    private static class Node<E>{
        private E elem;
        private Node<E> next;
        private Node<E> prev;

        //constructor
        public Node(E elem, Node<E> next, Node<E> prev){
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }

        //getters
        public E getElem(){
            return this.elem;
        }
        public Node<E> next(){
            return this.next;
        }
        public Node<E> prev(){
            return this.prev;
        }

        //setters
        public void setElem(E elem){
            this.elem = elem;
        }
        public void setNext(Node<E> next){
            this.next = next;
        }
        public void setPrev(Node<E> prev){
            this.prev = prev;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size;

    //constructor
    public DoublyLinkedList(){
        header = null;
        trailer = null;
        size = 0;
    }

   public int size(){
        return size;
    }

    public boolean isEmpty(){
          return size == 0;
    }

    //Getters
    public E first(){
        if (isEmpty())return null;
        return header.next().getElem();
    }
    public E last(){
        if (isEmpty())return null;
        return trailer.prev().getElem();
    }
    
    public void addBetween(E elem, Node<E> next,Node<E>prev){
        Node<E> newest = new Node<>(elem, next, prev);
        prev.setPrev(newest); 
        next.setNext(newest);
        size++;
    }

    public void addFirst(E elem){
        addBetween(elem, header.next(), header);
    }
    
    public void addLast(E elem){
        addBetween(elem, trailer, trailer.prev());
    }

    public E remove(Node<E> elem){
        Node<E> prevNode = elem.prev();
        Node<E> nextNode = elem.next();
        nextNode.setPrev(prevNode);
        prevNode.setNext(nextNode);
        size--;
        return elem.getElem();
    }
    
    public E removeFirst(){
        if (isEmpty()) return null; 
        return remove(header.next());
    }

    public E removeLast(){
        if (isEmpty()) return null; 
        return remove(trailer.prev());
    };
}

class CircularlyLinkedList<E>{
    private static class Node<E>{
        private E elem;
        private Node<E> next;

        //constructor
        public Node(E elem, Node<E> next){
            this.elem = elem;
            this.next = next;
        }

        //getters
        public E getElem(){
            return this.elem;
        }
        public Node<E> next(){
            return this.next;
        }

        //setters
        public void setElem(E elem){
            this.elem = elem;
        }
        public void setNext(Node<E> next){
            this.next = next;
        }
    }

    private Node<E> tail;
    private int size;

    //constructor
    public CircularlyLinkedList(){
        tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()) return null;
        return tail.next().getElem();
    }

    public E last(){
        if (isEmpty()) return null;
        return tail.getElem();
    }

    public void addFirst(E elem){
        if (isEmpty()){
            tail = new Node<>(elem, null);
            tail.setNext(tail); //MOST IMPORTANT LINE IN THE CODE
        } else {
            Node<E> newHead = new Node<>(elem, tail.next());
            tail.setNext(newHead);
        }
        size++;
    }

    public void addLast(E elem){
        addFirst(elem);
        tail = tail.next();
    }

    public E removeFirst(){
        if (isEmpty()) return null;
        Node<E> head = tail.next();
        if (head == tail){
            tail = null;
        } else {
            tail.setNext(head.next());
        }
        size--;
        return head.getElem();
    }
}