import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.add(10);
        st.add(20);
        st.add(30);

        System.out.println(st);
        st.peek();

        st.push(40);
        System.out.println(st);
        st.pop();
        System.out.println(st);

        // search returns the distance from the topmost element in the stack
        // on a 1 based positioning and 1 for the topmost element
        System.out.println(st.search(30));
        System.out.println(st.search(10));

        System.out.println(st.empty());

        // implementing same List class so the methods will remain same

    }
}
