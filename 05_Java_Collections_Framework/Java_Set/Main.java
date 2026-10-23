import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Set only add unique elements
        // Set is a abstract class implemented by many classes like HashSet
        // HashSet doesnt preserve Ordering , so ordering may change everytime.
        Set<Integer> s1 = new HashSet<Integer>();
        Set<Integer> s2 = new HashSet<Integer>();

        s1.add(10);
        s1.add(20);
        s1.add(20);
        s1.add(20);
        s1.add(20);
        s1.add(30);
        s1.add(50);

        System.out.println("s1: " + s1);

        s2.add(20);
        s2.add(20);
        s2.add(70);
        s2.add(50);
        s2.add(60);

        System.out.println("s2: " + s2);

        System.out.println("S1 containsALL elements of S2? : " + s1.containsAll(s2));

        // AddAll takes the Union of both Sets and stores it 
        s1.addAll(s2);
        System.out.println("s1 after adding s2: " + s1);

        System.out.println("S1 containsALL elements of S2? : " + s1.containsAll(s2));

        // Retain all takes the intersection and stores it
        System.out.println(s1);
        System.out.println(s2);
        s1.retainAll(s2);
        System.out.println("S1 intersection S2: " + s1);

        // In Sets we have methods like:
        // add(); addAll(); iterator(); remove(); remooveAll();
        // retain(); retainAll(); clear(); size(); toArray();
        // contains(); containsAll(); hashCode();


        // Time Complexity
        // HashSet -> O(1)
        // LinkedHashSet -> O(n)
        // TreeSet -> BST -> O(log n)
    }
}
