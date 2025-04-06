package ASM;

import java.util.Scanner;

public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
                                                                                                    //---------------------------Case1: AddStudent với kiểm tra lỗi ngoại lệ---------------------------
    public void addStudentFromKeyBoard() {
        int id = 0; 
        String name = ""; 
        double mark = 0.0; 
        boolean validInput = false; 
                                                                                                                 // Nhập ID (không được trùng lặp)
        while (!validInput) {
            try {
                System.out.println("Enter the ID student: ");
                String idInput = System.console().readLine();                                                                                // Nhập ID từ bàn phím
                id = Integer.parseInt(idInput);                                                                         // Chuyển đổi chuỗi thành số

                                                                                                                        // Kiểm tra xem ID có trùng lặp không
                if (isDuplicateId(id)) {
                    System.out.println("ID already exists! Please enter a different ID.");
                } else {
                    validInput = true;                                                                                          // ID hợp lệ, thoát khỏi vòng lặp
                }
            } catch (NumberFormatException e) {
                                                                                                                         // Bắt lỗi nếu người dùng nhập không phải là số
                System.out.println("Invalid input! ID must be a number. Please try again.");
            }
        }
                                                                                                                                // Nhập tên (không được chứa số hoặc ký tự đặc biệt)
        validInput = false;                                                                                     // Đặt lại biến kiểm tra
        while (!validInput) {
            System.out.println("Enter the name student: ");
            name = System.console().readLine();                                                                 // Nhập tên từ bàn phím

                                                                                                                                // Kiểm tra tên không được chứa số hoặc ký tự đặc biệt
            if (name.matches("[a-zA-Z\\s]+")) {                                                                     // Chỉ cho phép chữ cái và khoảng trắng
                validInput = true;                                                                                  // Tên hợp lệ, thoát khỏi vòng lặp
            } else {
                System.out.println("Invalid input! " + "Name must not contain numbers or special characters." 
                        + " Please try again.");
            }
        }
                                                                                                                                // Nhập điểm (chỉ từ 1 đến 10)
        validInput = false;                                                                                                                         // Đặt lại biến kiểm tra
        while (!validInput) {
            try {
                System.out.println("Enter the mark student (1-10): ");
                String markInput = System.console().readLine();                                                                                 // Nhập điểm từ bàn phím
                mark = Double.parseDouble(markInput);                                                                       // Chuyển đổi chuỗi thành số

                                                                                                                             // Kiểm tra điểm có nằm trong khoảng 1 đến 10 không
                if (mark >= 1 && mark <= 10) {
                    validInput = true;                                                                                              // Điểm hợp lệ, thoát khỏi vòng lặp
                } else {
                    System.out.println("Invalid input! Mark must be between 1 and 10. Please try again.");
                }
            } catch (NumberFormatException e) {
                                                                                                                                                 // Bắt lỗi nếu người dùng nhập không phải là số
                System.out.println("Invalid input! Mark must be a number. Please try again.");
            }
        }

                                                                                                                                      // Thêm sinh viên vào danh sách
        add(new Student(id, name, mark));
        System.out.println("Student added successfully!");
    }

                                                                                                                        // Thêm student mới vào list
    public void add(Student s) {
        Node newNode = new Node(s);
        if (isEmpty() == true) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

                                                                                                        // Phương thức kiểm tra ID trùng lặp
    private boolean isDuplicateId(int id) {
        Node current = head;                                                                                // Bắt đầu từ đầu danh sách
                                                                                                             // Duyệt qua danh sách sinh viên
        while (current != null) {
            if (current.student.getId() == id) {
                return true;                                                                                                // ID trùng lặp
            }
            current = current.next;                                                                                              // Di chuyển đến sinh viên tiếp theo
        }
        return false;                                                                                                           // ID không trùng lặp
    }
                                                                                            //---------------------------Case3: editStudent với kiểm tra lỗi ngoại lệ---------------------------    

    public void editStudent() {
        int id = 0;                                                                                                                          // Biến lưu ID của sinh viên cần chỉnh sửa
        String newName = "";                                                                                                                              // Biến lưu tên mới của sinh viên
        double newMark = 0.0;                                                                                                                        // Biến lưu điểm mới của sinh viên
        boolean validInput = false;                                                                                                                      // Biến kiểm tra dữ liệu nhập vào có hợp lệ không
                                                                                                                                            // Nhập ID của sinh viên cần chỉnh sửa
        while (!validInput) {
            try {
                System.out.println("Enter the ID student update: ");
                String idInput = System.console().readLine();                                                                               // Nhập ID từ bàn phím
                id = Integer.parseInt(idInput);                                                                                  // Chuyển đổi chuỗi thành số
                                                                                                                            // Kiểm tra xem ID có tồn tại trong danh sách không
                if (!isIdExist(id)) {
                    System.out.println("Student with ID " + id + " does not exist. Please try again.");
                } else {
                    validInput = true;                                                                                           // ID hợp lệ, thoát khỏi vòng lặp
                }
            } catch (NumberFormatException e) {
                                                                                                                                    // Bắt lỗi nếu người dùng nhập không phải là số
                System.out.println("Invalid input! ID must be a number. Please try again.");
            }
        }
                                                                                                                                     // Nhập tên mới (không được chứa số hoặc ký tự đặc biệt)
            validInput = false;                                                                                                      // Đặt lại biến kiểm tra
            while (!validInput) {
            System.out.println("Enter the new name student: ");
            newName = System.console().readLine();                                                                               // Nhập tên mới từ bàn phím
                                                                                                                                    // Kiểm tra tên không được chứa số hoặc ký tự đặc biệt
            if (newName.matches("[a-zA-Z\\s]+")) {                                                                                  // Chỉ cho phép chữ cái và khoảng trắng
                validInput = true;                                                                                                      // Tên hợp lệ, thoát khỏi vòng lặp
            } else {
                System.out.println("Invalid input! Name must not contain numbers or special characters. Please try again.");
            }
        }
                                                                                                                                                    // Nhập điểm mới (chỉ từ 1 đến 10)
        validInput = false;                                                                                                             // Đặt lại biến kiểm tra
        while (!validInput) {
            try {
                System.out.println("Enter the new mark student: ");
                String markInput = System.console().readLine();                                                                                 // Nhập điểm mới từ bàn phím
                newMark = Double.parseDouble(markInput);                                                                                        // Chuyển đổi chuỗi thành số
                                                                                                                                        // Kiểm tra điểm có nằm trong khoảng 1 đến 10 không
                if (newMark >= 1 && newMark <= 10) {
                    validInput = true;                                                                                                      // Điểm hợp lệ, thoát khỏi vòng lặp
                } else {
                    System.out.println("Invalid input! Mark must be between 1 and 10. Please try again.");
                }
            } catch (NumberFormatException e) {
                                                                                                                                            // Bắt lỗi nếu người dùng nhập không phải là số
                System.out.println("Invalid input! Mark must be a number. Please try again.");
            }
        }
                                                                                                                                             // Tìm sinh viên có ID trùng khớp và cập nhật thông tin
        Node p = head;                                                                                                                                       // Bắt đầu từ đầu danh sách
        while (p != null) {
            if (p.student.getId() == id) {
                p.student = new Student(id, newName, newMark);                                                                                                      // Cập nhật thông tin sinh viên
                System.out.println("The student with ID " + id + " has been updated.");
                return;                                                                                                                  // Kết thúc phương thức sau khi cập nhật
            }
            p = p.next;                                                                                                                          // Di chuyển đến sinh viên tiếp theo
        }
    }
                                                                                                                                        // Phương thức kiểm tra ID có tồn tại trong danh sách không
    private boolean isIdExist(int id) {
        Node current = head;                                                                                                            // Bắt đầu từ đầu danh sách
                                                                                                                                         // Duyệt qua danh sách sinh viên
        while (current != null) {
            if (current.student.getId() == id) {
                return true;                                                                                                                    // ID tồn tại
            }
            current = current.next;                                                                                                          // Di chuyển đến sinh viên tiếp theo
        }
        return false;                                                                                                                       // ID không tồn tại
    }
    // Phương thức kiểm tra ID có tồn tại trong danh sách không

    
//---------------------------------Case 4: deleStudent------------------------------------
    public void deleStudent(int id) {
        try {
           
            if (head == null) {
                System.out.println("No student to delete. The list is empty.");
                return;
            }
            if (head.student.getId() == id) {
                head = head.next; // Di chuyển head đến phần tử tiếp theo
                System.out.println("The student with ID " + id + " has been deleted.");
                return;
            }

            Node p = head;
            while (p.next != null) {
                if (p.next.student.getId() == id) {
                    p.next = p.next.next;
                    System.out.println("The student with ID " + id + " has been deleted.");
                    return;
                }
                p = p.next; 
            }

            System.out.println("Student with ID " + id + " not found.");
        } catch (Exception e) {
            System.out.println("An error occurred while deleting the student: " + e.getMessage());
        }
    }
//---------------------------------Case 5: Sort------------------------------------
    public void bubbleSort(boolean ascending) {
        if (head == null || head.next == null) {
            System.out.println("The list is empty or has only one element. No sorting needed.");
            return;
        }
        try {
            boolean swapped;
            do {
                swapped = false; 
                Node p = head; 
                while (p.next != null) { 
                    boolean condition;
                    if (ascending) {
                        condition = p.student.getMark() > p.next.student.getMark();
                    } else {
                        condition = p.student.getMark() < p.next.student.getMark();
                    }
                    if (condition) {
                        Student temp = p.student;
                        p.student = p.next.student;
                        p.next.student = temp;
                        swapped = true; 
                    }
                    p = p.next; 
                }
            } while (swapped);
            System.out.println("Sorting completed successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred during sorting: " + e.getMessage());
        }
    }

    public void quickSort(boolean ascending) {
        head = quickSortRec(head, ascending);
        Node p = head;
        while (p != null && p.next != null) {
            p = p.next;
        }
        tail = p;
    }
    private Node quickSortRec(Node start, boolean ascending) {
        try {
            if (start == null || start.next == null) {
                return start;
            }
            Node pivot = start;
            Node less = null, greater = null;
            Node current = start.next;
            while (current != null) {
                Node next = current.next;
                boolean condition;
                if (ascending) {
                    condition = current.student.getMark() < pivot.student.getMark();
                } else {
                    condition = current.student.getMark() > pivot.student.getMark();
                }
                if (condition) {
                    current.next = less;
                    less = current;
                } else {
                    current.next = greater;
                    greater = current;
                }
                current = next;
            }
            less = quickSortRec(less, ascending);
            greater = quickSortRec(greater, ascending);
            if (less == null) {
                pivot.next = greater;
                return pivot;
            } else {
                Node temp = less;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = pivot;
                pivot.next = greater;
                return less;
            }
        } catch (Exception e) {
            System.out.println("An error occurred during Quick Sort: " + e.getMessage());
            return start; 
        }
    }
//---------------------------------Case 6: Search------------------------------------
    // Phương thức searchStudent sử dụng LinearSearch

    public int linearSearch(int id) {
        try {
            Node p = head;
            int index = 0; 

            while (p != null) {
                if (p.student.getId() == id) {
                    return index; 
                }
                p = p.next;
                index++; 
            }
            return -1; 
        } catch (Exception e) {
            System.out.println("An error occurred during Linear Search: " + e.getMessage());
            return -1; 
        }
    }

    public int binarySearch(int id) {
        try {
            bubbleSort(true);
            Node p = head; 
            int low = 0, high = 0;

            while (p != null) {
                high++;
                p = p.next;
            }
            high--;
            while (low <= high) {
                int mid = (low + high) / 2;
                p = head;
                for (int i = 0; i < mid; i++) {
                    p = p.next;
                }
                if (p.student.getId() == id) {
                    return mid;
                } else if (p.student.getId() < id) {
                    low = mid + 1; 
                } else {
                    high = mid - 1; 
                }
            }
            return -1; 
        } catch (Exception e) {
            System.out.println("An error occurred during Binary Search: " + e.getMessage());
            return -1; 
        }
    }
    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.println(p.student.toString());
            p = p.next;
        }
    }

    // Push cho Stack
    public void pushStack(MyStack stack) {
        Node p = head;
        while (p != null) {
            stack.push(p.student);
            p = p.next;
        }
    }
}