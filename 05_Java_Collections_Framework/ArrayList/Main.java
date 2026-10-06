import java.util.ArrayList;
// import java.util.List; 
import java.util.Collections;

public class Main {

    public static void display(ArrayList<Integer> list){
        System.out.println(list);
        System.out.println("Size: " + list.size());
    }
    public static void main(String[] args) {
        // Collection is the main class 
        // List extends to Collection
        // ArrayList implements List

        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        // Collection<Integer> collection = new ArrayList<Integer>();

        list.add(10);
        list.add(20);
        list.add(50);


        tempList.add(30);
        tempList.add(40);
        tempList.add(80);

        list.addAll(tempList);

        display(list);

        list.remove(2);
        display(list);

        list.removeAll(tempList);
        display(list);

        display(tempList);
        tempList.clear();
        display(tempList);

        ArrayList<Integer> list3 = new ArrayList<>();

        list3.add(10);
        list3.add(30);
        list3.add(40);

        System.out.println(list3.get(1));
        System.out.println(list3.get(2));
        list3.set(1, 20);
        System.out.println(list3.get(1));
        System.out.println(list3.contains(20));
        System.out.println(list3.contains(30));

        ArrayList<Integer> list4 = new ArrayList<Integer>();
        list4.addAll(list3);
        list4.add(60);
        list4.add(80);
        display(list4);

        Collections.sort(list4);

        display(list4);

        // creates only shallow copies 
        ArrayList<Integer> newList = (ArrayList<Integer>) list4.clone();
        display(newList);

        ArrayList<Integer> marks = new ArrayList<>();
        // ensure minimum cpacity
        marks.ensureCapacity(100);
        System.out.println(newList.isEmpty());
        
    }
}