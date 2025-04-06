package ASM;

public class Node {
    Student student;                                                                                        // Đối tượng sinh viên chứa trong nút
    Node next;
                                                                                // Constructor khởi tạo một Node chứa thông tin sinh viên
    public Node(Student student) {
        this.student = student;                                                      // Gán thông tin sinh viên
        this.next = null;                                                                   // Ban đầu chưa liên kết với nút nào
    }
}