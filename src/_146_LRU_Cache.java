import java.util.HashMap;

/**
 *
 */
public class _146_LRU_Cache {
    static int CAPACITY;
    HashMap<Integer, Integer> store = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
    int clock = 0;

    public _146_LRU_Cache(int capacity) {

        CAPACITY = capacity;
    }

    public int get(int key) {
        clock++;
        if(store.containsKey(key)){
            counter.put(key,clock);
            return store.get(key);
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {

        clock++;
        if(store.size() == CAPACITY && !store.containsKey(key)){
            int k = findEvKey();
            store.remove(k);
            counter.remove(k);
        }

        store.put(key,value);
        counter.put(key,clock);
    }

    int findEvKey(){

        int minK = -1;
        int minV = 0;
        for (int i : counter.keySet()) {
            if(minK == -1 || counter.get(i) <= minV){
                minV = counter.get(i);
                minK = i;
            }
        }
        return minK;
    }
}
