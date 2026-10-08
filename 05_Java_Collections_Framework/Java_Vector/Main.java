import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        // The vector class is the implementation of list interface that allows to create resizable array like ArrayList 
        // difference between ArrayList class and Vector class is
        // The Vector class is Synchronus and synchronizes each operation
        // this means if a person is performing some operation on a vector,
        // no other person can perform any operation on the same vector as its locked by the vector class

        // This lockling unlocking etc takes time and resources so although its safer than Arraylist but not as Efficient as that .

        Vector<Integer> v = new Vector<>();
        Vector<String> vs = new Vector<>();

        // it has all the methods present in ArrayList

        v.add(10);
        v.add(20);
        v.add(30);

        System.out.println("v vector: " + v);
        System.out.print("v to Array: ");
        v.toArray();
        for (Integer num : v) {
            System.out.print(num + " ");
        }
        System.out.println();

        vs.add("one");
        vs.add("two");
        vs.add("three");

        System.out.println("vs vector: " + vs);
        System.out.println("vs to String: " + vs.toString());
    }
}
