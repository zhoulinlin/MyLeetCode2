### 1. Using StringBuilder instead of string
### 2. Hashmap(pro.14)
```java
Map<Character, Integer> dic = new HashMap<>();<br>
dic.put('I',1);<br>
cur = dic.get(key);
```
### 3.Arrays(pro.15)
```java
Arrays.asList(num1,num2,num3) //return a fixed-size list backed by the specified array.
Arrays.sort(nums); //This method doesn't return any value.
Integer.MAX_VALUE;
Integer.MIN_VALUE;
```
### 4.stack(pro.20)
```java
Stack<Character> stack = new Stack<>();
stack.push(c);
stack.pop();
stack.peek()
```
### 5.HashMap
```java
//Create a HashMap
HashMap<String, String> capitalCities = new HashMap<String, String>();
capitalCities.put("England", "London");//Add Items
capitalCities.get("England");//Access an Item
capitalCities.remove("England");//Remove an Item
capitalCities.clear();//Remove all items
capitalCities.size();//HashMap Size
capitalCities.containsKey("England")//Check if key exists in HashMap
capitalCities.getOrDefault(key, -1);//get value or default
//Loop Through a HashMap
for (String i : capitalCities.keySet()) {
  System.out.println(i);// Print keys
}
for (String i : capitalCities.values()) {
  System.out.println(i);// Print values
}
```
### 6.Queue
```java
Queue<Integer> q = new LinkedList<>();
// To remove the head of queue.
 int removedele = q.remove();
// To view the head of queue
int head = q.peek();
//Adds elements  to queue
q.add(i);
```
### 7.Arrays.sort(pro.56)
```java
//int[][] intervals
Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

// Sorts arr[] in descending order
Arrays.sort(arr, Collections.reverseOrder());


class Sortbyroll implements Comparator<Student>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Student a, Student b)
    {
        return a.rollno - b.rollno;
    }
}
Arrays.sort(arr, new Sortbyroll());
```
### 8.-> operator(pro.56)
This one is useful as well when you want to implement a functional interface
```java
Runnable r = ()-> System.out.print("Run method");
//is equivalent to
Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.print("Run method");
        }
};
```
### 9.PriorityQueue(pro.253)
```java
// Min heap
    PriorityQueue<Integer> allocator =
        new PriorityQueue<Integer>(
            intervals.length,
            new Comparator<Integer>() {
              public int compare(Integer a, Integer b) {
                return a - b;
              }
            });
//using lambada
Queue<Integer> que = new PriorityQueue<Integer>(intervals.length, (a, b) -> a - b);
```
Constructors:<br>
(1)PriorityQueue<E> pq = new PriorityQueue<E>();<br>
(2)PriorityQueue<E> pq = new PriorityQueue<E>(Collection<E> c);<br>
(3)PriorityQueue<E> pq = new PriorityQueue<E>(int initialCapacity);<br>
(4)PriorityQueue<E> pq = new PriorityQueue(int initialCapacity, Comparator<E> comparator);<br>
(5)PriorityQueue<E> pq = new PriorityQueue(PriorityQueue<E> c);<br>
(6)PriorityQueue<E> pq = new PriorityQueue<E>(SortedSet<E> c);<br>

*Example:
The example below explains the following basic operations of the priority queue.*
<br>**boolean add(E element):** This method inserts the specified element into this priority queue.
<br>**public peek():** This method retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
<br>**public poll():** This method retrieves and removes the head of this queue, or returns null if this queue is empty.