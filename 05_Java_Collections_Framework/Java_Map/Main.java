import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>();

        m.put("RUPPEE", "India");
        // m.put("rs", "India2"); It just updates the old value of same key
        m.put("USD", "United States of America");
        m.put("YEN", "Japan");

        Map<String, String> mt = new HashMap<>();
        mt.put("RUBLE", "Russia");

        System.out.println("Before merging m and mt hashmap:");
        System.out.println(m);

        System.out.println("After merging m and mt hashmap:");
        m.putAll(mt);
        System.out.println(m);

        m.remove("RUBLE");
        System.out.println("m after removal of Ruble: \n"+ m);

        System.out.println(m.size());
        System.out.println(mt.size());

        mt.clear();

        System.out.println(mt);

        System.out.println(mt.isEmpty());


        System.out.println(mt.getOrDefault("RUBLE", "nhi hai"));

        System.out.println(m.containsKey("RUPPEE"));
        System.out.println(m.containsValue("India"));

        mt.putIfAbsent("RUBLE", "Russia");
        System.out.println(mt);

        m.replace("YEN", "South Korea");
        System.out.println(m);

        System.out.println(m.keySet());
        System.out.println(m.entrySet());
        System.out.println(m.values());

        Set<String>  s = m.keySet();
        System.out.println(s);

        // getting all entries and saving it in a typed Set
        Set<Map.Entry<String, String>> entryset = m.entrySet();
        System.out.println("Entries: " + entryset);

    }
}
