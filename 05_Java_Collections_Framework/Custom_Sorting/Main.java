import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
    // Atrributes
    private String name;
    private int age;
    private String enrollNo;
    private float sgpa;

    // Default Constructor
    public Student() {
    }

    // Parameterized Constructor
    public Student(String name, int age, String enrollNo, float sgpa) {
        this.name = name;
        this.age = age;
        this.enrollNo = enrollNo;
        this.sgpa = sgpa;
    }

    // Copy Constructor
    public Student(Student SrcObj) {
        this.name = SrcObj.name;
        this.age = SrcObj.age;
        this.enrollNo = SrcObj.enrollNo;
        this.sgpa = SrcObj.sgpa;
    }

    // Methods
    public void setName(String n) {
        name = n;
    }

    public void setAge(int x) {
        age = x;
    }

    public void setEnrollNo(String x) {
        enrollNo = x;
    }

    public void setSGPA(float x) {
        sgpa = x;
    }

    public float getSGPA(){
        return sgpa;
    }

    public void Display() {
        System.out.println("Students Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Enrollment No.: " + enrollNo);
        System.out.println("SGPA: " + sgpa);
        System.out.println();
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", enrollNo='" + enrollNo + "', sgpa=" + sgpa + "}";
    }

    @Override
    public int compareTo(Student obj){
        // sorting by enrollment numbers
        return Integer.parseInt(this.enrollNo) - Integer.parseInt(obj.enrollNo);
        // return this.enrollNo.compareTo(other.enrollNo);
    }

}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Himanshu Singh", 19, "402166", 7.9f));
        students.add(new Student("Anuj Kumar", 20, "035166", 7.8f));
        students.add(new Student("Vinit Tiwari", 19, "104166", 8.6f));
        students.add(new Student("Kartik", 20, "251166", 7.5f));

        System.out.println(students);

        // By comparable Interface
        // Collections.sort(students);

        // System.out.println(students);

        // By comparator Interface
        // Collections.sort(students, new Comparator<Student>(){
        //     @Override
        //     public int compare(Student src, Student dest){
        //         return Float.compare(src.getSGPA(), dest.getSGPA());
        //     }
        // });

        //  OR By Lambda Function

        Collections.sort(students, (src, dest) -> Float.compare(src.getSGPA(), dest.getSGPA()));

        System.out.println(students);
    }
}
