import java.util.LinkedList;

public class Queue_deque_by_linkedList{
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();

        // add to front and add to end in the queue 
        ll.addFirst(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addFirst(40);

        System.out.println(ll);

        // Retrieves, but does not remove, the head (first element) of this list
        System.out.println("peek: " + ll.peek());
        
        // Retrieves and removes the head (first element) of this list
        System.out.println("poll: " + ll.poll());

        // Adds the specified element as the tail (last element) of this list
        ll.offer(40);
        System.out.println("after offer: " + ll);

        ll.addFirst(60);
        System.out.println("ll after addFirst: " + ll);

        ll.removeFirst();
        System.out.println("ll after removing first: " + ll);

        System.out.println("Hashcode of the  list ll: " + ll.hashCode());
    }
}