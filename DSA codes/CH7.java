public class CH7 {
    public interface List<E>{
        int size();
        boolean isEmpty();
        void add(int i, E elem) throws IndexOutOfBoundsException;
        E get(int index)throws IndexOutOfBoundsException;
        E remove(int index)throws IndexOutOfBoundsException;
        E set(int index, E elem)throws IndexOutOfBoundsException;

    }

    //When implementing List Class, there is a mthod called checkindex
    //method resize is responsible for resizing the array when it is full.
    
    //position interface
    //positional list interface
    //linked positional list class (with inner class node), both implemening the interfaces above. 

    //implement the travese method "abstractly"

    //nethods of the pisition inner class
    // 3 setters + 3 getters (Element, next, prev)

    //private methods of the positional list:
    //validate
    //addbetween
    //position (private - for casting)
    
    //public the rest is common with the DLL
    //addBetween (private)
    //addBefore
    //addAfter
    //addFirst
    //addLast
    //remove
    //set
    //size 
    //isEmpty
    //first 
    //last
    //before
    //after
}
