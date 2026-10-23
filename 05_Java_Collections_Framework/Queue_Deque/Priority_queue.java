import java.util.PriorityQueue;
import java.util.Queue;

public class Priority_queue{
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();

        // In priority queue , By default
        // the lowest integer has the highest priority.
        // Interger -> less Value -> highest Priority -> MinHeap
        // If we reverse it, then it will show qualities like -> MaxHeap
        //  like by using lambda function (a, b) -> b - a
        pq.offer(10);
        pq.offer(40);
        pq.offer(20);
        pq.offer(50);
        pq.offer(30);

        System.out.println(pq.poll());
        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq);
    }
}