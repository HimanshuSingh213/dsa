import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void display(List<Integer> list){
        System.out.println(list);
        System.out.println("Size: " + list.size());
    }
    
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        List<Integer> tempList = new LinkedList<Integer>();

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

        List<Integer> list3 = new LinkedList<>();

        list3.add(10);
        list3.add(30);
        list3.add(40);

        System.out.println(list3.get(1));
        System.out.println(list3.get(2));
        list3.set(1, 20);
        System.out.println(list3.get(1));
        System.out.println(list3.contains(20));
        System.out.println(list3.contains(30));

        List<Integer> list4 = new LinkedList<Integer>();
        list4.addAll(list3);
        list4.add(60);
        list4.add(80);
        display(list4);

        Collections.sort(list4);

        display(list4);

        // in LinkedList we cant clone list by any pre-built method
        // creates only shallow copies 
        // List<Integer> newList = (ArrayList<Integer>) list4.clone();
        // display(newList);

        // List<Integer> marks = new LinkedList<>();
        // ensure minimum cpacity
        // marks.ensureCapacity(100);
        // System.out.println(newList.isEmpty());

        display(list);
        System.out.println(list.indexOf(40));
        System.out.println(list.indexOf(20));
        System.out.println(list.indexOf(10));
    }
}
