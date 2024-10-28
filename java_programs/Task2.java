import java.util.*;

class Student {
    int rollNumber;
    String name;

    Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public String toString(){
        return rollNumber + " " + name;
    }
}

public class Task2 {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        TreeMap<Integer,Student> studentmap=new TreeMap<>((Comparator.reverseOrder()));
        int n= sc.nextInt();

        for(int i=0;i<n;i++){
            int rollNumber=sc.nextInt();
            String name=sc.next();

            Student student=new Student(rollNumber, name);
            studentmap.put(rollNumber, student);
            System.out.println(studentmap);
        }
        sc.close();

    }
}
