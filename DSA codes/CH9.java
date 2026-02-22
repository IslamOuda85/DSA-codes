import java.sql.PseudoColumnUsage;

public class CH9 {
    public interface iEntry<K,V>{
        K getKey();
        V getValue();
    }

    public interface PriorityQueue<K,V>{
        iEntry<K,V> insert(K key,V value) //NOT receiving an Entry 
            throws IllegalArgumentException;
        iEntry<K,V> min();
        iEntry<K,V> removeMin();
    } 

    public class UnsoertedPriorityQueue<K,V> implements PriorityQueue<K,V>{
        private static class Entry<K,V> implements iEntry<K,V>{
            K key;
            V value;
            
            public Entry(K key, V value){
                this.key = key;
                this.value = value;
            }
            
            public K getKey(){
                return this.key;
            }   
            
            public V getValue(){
                return this.value;
            }

        }

        //Creteing the List + constructor
        private PositionalList<Entry<K,V>> list = LinkedPositionalList<>();

        public UnsoertedPriorityQueue(){super()}

        //findMin
        private Position<Entry<K,V>> findMin(){
            position<Entry<K,V>> small = list.first();
            for(Position<Entry<K,V>> walk: list.positions()){
                if (compare(walk.getElement(),small.getEelement())<0)
                    small = walk;
            }
            return small;
        }

        //insert

        //min

        //removeMin
    }


    //heaps

    //Adaptable Priority Queue
    
    
}

