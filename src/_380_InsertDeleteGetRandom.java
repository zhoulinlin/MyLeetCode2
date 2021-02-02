import java.util.*;

public class _380_InsertDeleteGetRandom {
}

class RandomizedSet {

    Map<Integer, Integer> dict;
    List<Integer> list;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        dict = new HashMap<>();
        list = new ArrayList<>();

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(dict.containsValue(val)) return false;
        dict.put(list.size(),val);
        list.add(val);

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!dict.containsValue(val)) return false;

        int index = dict.get(val);

        list.set(index,list.get())
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
       return list.get(rand.nextInt(list.size()));
    }
}