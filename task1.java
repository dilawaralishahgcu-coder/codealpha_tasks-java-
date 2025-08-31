/*✅ TASK 1: Student Grade Tracker
● Build a Java program to input and manage student grades.
● Calculate average, highest, and lowest scores.
● Use arrays or ArrayLists to store and manage data.
● Display a summary report of all students.
● Make the interface console-based or GUI-based as desired.*/

import java.util.ArrayList;
import java.util.*;    // or we can also import java.util.scanner

public class task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Store student names and grades
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Integer> studentGrades = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Input student data
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = sc.nextLine();
            studentNames.add(name);

            System.out.print("Enter grade of " + name + ": ");
            int grade = sc.nextInt();
            sc.nextLine(); // consume newline
            studentGrades.add(grade);
        }

        // Calculate average, highest, lowest
        int total = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;
        int highestIndex = -1, lowestIndex = -1;

        for (int i = 0; i < n; i++) {
            int grade = studentGrades.get(i);
            total += grade;

            if (grade > highest) {
                highest = grade;
                highestIndex = i;
            }

            if (grade < lowest) {
                lowest = grade;
                lowestIndex = i;
            }
        }

        double average = (double) total / n;

        // Display summary
        System.out.println("\n===== Student Grade Summary =====");
        for (int i = 0; i < n; i++) {
            System.out.println(studentNames.get(i) + " : " + studentGrades.get(i));
        }

        System.out.println("\nAverage Grade: " + average);
        System.out.println("Highest Grade: " + highest + " (Student: " + studentNames.get(highestIndex) + ")");
        System.out.println("Lowest Grade: " + lowest + " (Student: " + studentNames.get(lowestIndex) + ")");
        sc.close();
    }
    
}
