import java.util.*;

class Student implements Comparable<Student> {
    int rollNumber;
    String name;

    Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public String toString(){
        return rollNumber + " " + name;
    }

    public int compareTo(Student other) {
        return Integer.compare(this.rollNumber, other.rollNumber);
    }
}

public class Task3 {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        TreeSet<Student> studentset=new TreeSet<>();
        int n= sc.nextInt();

        for(int i=0;i<n;i++){
            int rollNumber=sc.nextInt();
            String name=sc.next();

            Student student=new Student(rollNumber, name);
            studentset.add(student);
            System.out.println(studentset);
        }
        sc.close();

    }
}
