public class CH6 {

    interface Stack<E>{
        E pop();
        void push(E elem);
        boolean isEmpty();
        int size();
        E top();
    }

    interface Queue<E>{
        E dequeue();
        void enqueue();

        boolean isEmpty();
        int size();
        
        E front();
        E rear();
    } 
    

    class StackArray<E> implements Stack<E>{
        E[] data;
        int top;

        public StackArray (int capacity){
            data = (E[]) new Object[capacity];
            top = -1;
        }

        public void push(E elem){
            if (top == data.length-1) throw new IllegalStateException("stack is full");
            data[top] = elem;
            top++;
        }
        
        public E top(){return data[top];}

        public E pop(){
            if(top == -1) throw new IllegalStateException("Stack is Empty");
            E temp = data[top];
            data[--top] = null;
            return temp;
        }

        public int size(){
            return top + 1;
        }

        public boolean isEmpty() {
            return size()==0;
        }
    }

    //Reverse an array using a stack
    public void rverseArray(int[] arr){
        Stack<Integer> stk = new StackArray<Integer>(arr.length); 
        for(int i =0; i < arr.length; i++){
            stk.push(arr[i]);
        }
        for(int i =0; i < arr.length; i++){
            arr[i] = stk.pop();
        }
    }

    //Parentheses Matching
    public boolean parMatch(String s){
        String open = "({[";
        String close = ")}]";
        Stack<Character> stk = new StackArray<Character>(s.length());
        for (char k: s.toCharArray()){
            if (open.indexOf(k)!=-1){ 
                stk.push(k);
            }       
            else if(close.indexOf(k)!=-1){
                if(stk.isEmpty()){ 
                    return false;
                }
                if (close.indexOf(k)!= open.indexOf(stk.pop())){
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
    

    //HTML tag matching


    //Arethmatic Expression (3 methods - Dijkstra's Two-Stack Algorithm)
    
    //Counting Spans (Array)
    public int[] spansArray(int[] prices){
        int[] spans = new int[prices.length];
        for(int i = 0; i<prices.length; i++){
            spans[i] = 1;
            while (spans[i] <= i && prices[i-spans[i]]>=prices[i]){
                spans[i]+=1;
            }
        }
        return spans;
    }
    
    //Counting Spans (Stack)
    public int[] spansStack(int[] prices){
        int[] spans = new int[prices.length];
        Stack<Integer> stk = new StackArray<Integer>(prices.length);
        for(int i = 0; i<prices.length; i++){
            while (!stk.isEmpty() && prices[stk.top()]<=prices[i]){
                stk.pop();
            }
            spans[i] = stk.isEmpty() ? i+1 : i-stk.top();
            stk.push(i);
        }
        return spans;
    }


    // class StackLinkedList<E> implements Stack<E>{
    //     // same as SLL, except the part of removefirst and addfirst
    //     // will be pop and push respectively.
    //     private class Node<E>{
    //         private E elem;
    //         private Node<E> next;

    //         public Node<E>(E e, Node<E> nxt){
    //             this.elem = e; 
    //             this.next = next; 
    //         }
    //     }

    // } 

    class QueueArray<E> implements Queue<E>{
        //enqueue

        //dequeue
        
        //front
        
        //rear
        
        //isEmpty

        //size
    }

    class QueueLinkedList<E> implements Queue<E>{
        //enqueue

        //dequeue
        
        //front
        
        //rear
        
        //isEmpty

        //size
    }

    public interface CircularQueue<E> extends Queue<E> {
        void rotate();
        void process();
    }

    public class CircularQueueLinkedList<E> implements CircularQueue<E>{
        //7 methods to implement
    } 

    public class Deque<E>{
        //constructor

        //size

        //isEmpty

        //first

        //last

        //addFirst

        //addLast

        //removeFirst

        //removeLast
    }
}