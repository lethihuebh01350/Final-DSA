package ASM;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ASM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyList studentList = new MyList();
        MyStack studentStack = new MyStack();
        int section = 0;

        while (section != 8) {
            System.out.println("     MENU     ");
            System.out.println("1. Add Student");
            System.out.println("2. Display Student");
            System.out.println("3. Edit Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Sort Student");
            System.out.println("6. Search Student");
            System.out.println("7. Stack");
            System.out.println("8. Exitting...");

            // Nhập lựa chọn với kiểm tra lỗi
            while (true) {
                System.out.print("- Enter the choice : ");
                try {
                    section = sc.nextInt();
                    if (section < 1 || section > 8) {
                        System.out.println("Invalid choice! Please enter a number between 1 and 8.");
                    } else {
                        break; 
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number between 1 and 8.");
                    sc.next(); 
                }
            }

            // Xử lý lựa chọn
            switch (section) {
                case 1:
                    studentList.addStudentFromKeyBoard();
                    break;
                case 2:
                    studentList.traverse();
                    break;
                case 3:
                    studentList.editStudent();
                    break;
                case 4:
                    System.out.print("Enter the ID student delete: ");
                    int deleteId = sc.nextInt();
                    studentList.deleStudent(deleteId);
                    break;
                case 5:
                    System.out.println("1. Bubble Sort(By points)");
                    System.out.println("2. Quick Sort(By points)");
                    System.out.print("- Enter your choice: ");
                    int sortOption = sc.nextInt();
                    if (sortOption == 1) {
                        studentList.bubbleSort(true);
                    } else if (sortOption == 2) {
                        studentList.quickSort(false);
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    studentList.traverse();
                    break;
                case 6:
                    System.out.println("1. Linear Search");
                    System.out.println("2. Binary Search");
                    System.out.print("- Enter your choice: ");
                    int searchOption = sc.nextInt();
                    System.out.print("- Enter the ID student to search: ");
                    int searchId = sc.nextInt();
                    if (searchOption == 1) {
                        int index = studentList.linearSearch(searchId);
                        if (index != -1) {
                            Node p = studentList.head;
                            for (int i = 0; i < index; i++) {
                                p = p.next;
                            }
                            System.out.println("Student found: " + p.student.toString());
                        } else {
                            System.out.println("Student with ID " + searchId + " not found.");
                        }
                    } else if (searchOption == 2) {
                        int index = studentList.binarySearch(searchId);
                        if (index != -1) {
                            Node p = studentList.head;
                            for (int i = 0; i < index; i++) {
                                p = p.next;
                            }
                            System.out.println("Student found: " + p.student.toString());
                        } else {
                            System.out.println("Student with ID " + searchId + " not found.");
                        }
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;
                case 7:
                    System.out.println("1. Push student onto stack");
                    System.out.println("2. Pop student from stack");
                    System.out.println("3. Display stack");
                    System.out.print("Enter your choice: ");
                    int stackOption = sc.nextInt();
                    if (stackOption == 1) {
                        studentList.pushStack(studentStack);
                    } else if (stackOption == 2) {
                        studentStack.pop();
                    } else if (stackOption == 3) {
                        studentStack.displayStack();
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;
                case 8:
                    System.out.println("Exitting.");
                    break;
            }
        }
        sc.close();
    }
}
