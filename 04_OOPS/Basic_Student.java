class Student {
    // Atrributes
    private String name;
    private int age;
    private long enrollNo;
    private float sgpa;


    // Default Constructor
    public Student(){}

    // Parameterized Constructor 
    public Student(String name, int age, long enrollNo, float sgpa){
        this.name = name;
        this.age = age;
        this.enrollNo = enrollNo;
        this.sgpa = sgpa;
    }


    // Methods
    public void setName(String n){
        name = n;
    }

    public void setAge(int x){
        age = x;
    }

    public void setEnrollNo(long x){
        enrollNo = x;
    }

    public void setSGPA(float x){
        sgpa = x;
    }

    public void Display(){
        System.out.println("Students Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Enrollment No.: " + enrollNo);
        System.out.println("SGPA: " + sgpa );
        System.out.println();
    }

}

public class Basic_Student {
    public static void main(String[] args) {
        Student S1 = new Student();
        S1.Display();

        Student S2 = new Student("Himanshu Singh", 19, 40216449825L, 8.56F);
        S2.Display();

        S1.setName("Anuj Kumar");
        S1.setAge(20);
        S1.setEnrollNo(3516449825L);
        S1.setSGPA(7.7F);

        S1.Display();
    }
}

