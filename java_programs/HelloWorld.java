// package java_programs;
// @SuppressWarnings("all") // This can help suppress some warnings
//----normal program in java

// public class HelloWorld
// {
//     public static void main(String []args)
//     {
//         System.out.println("My First Java Program.");
//     }
// };


//----input in java

// import java.util.Scanner;  // Import the Scanner class

// public class HelloWorld {
//   public static void main(String[] args) {
//     Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//     System.out.println("Enter username");

//     String userName = myObj.nextLine();  // Read user input
//     System.out.println("Username is: " + userName);  // Output user input
//   }
// }


//----multiple inputs and outputs in java

import java.util.Scanner;

class HelloWorld {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);

    System.out.println("Enter name, age and salary:");

    // String input
    String name = myObj.nextLine();

    // Numerical input
    int age = myObj.nextInt();
    double salary = myObj.nextDouble();

    // Output input by user
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Salary: " + salary);
  }
}
