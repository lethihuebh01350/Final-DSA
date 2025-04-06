package ASM;

public class Student {
    private int id;
    private String name;
    private Double mark;
                                                                             // Constructor khởi tạo sinh viên với ID, tên và điểm số
    public Student(int id, String name, double mark) {
        this.id = id;                                                   // Gán ID
        this.name = name;                                                       // Gán tên
        this.mark = mark;                                                                   // Gán điểm số
    }
                                                                                     // Getters để lấy giá trị các thuộc tính
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getMark() {
        return mark;
    }
                                                                                    // Trả về xếp loại dựa trên điểm số
    public String getRanks() {
        if (mark < 5.0) return "Fail";                                                          // Dưới 5 điểm: Trượt
        else if (mark < 6.5) return "Medium";                                                       // 5-6.4: Trung bình
        else if (mark < 7.5) return "Good";                                                      // 6.5-7.4: Khá
        else if (mark < 9.0) return "Very Good";                                                                // 7.5-8.9: Giỏi
        else return "Excellent";                                                            // 9 trở lên: Xuất sắc
    }
                                                                                                        // Phương thức hiển thị thông tin sinh viên
    @Override
    public String toString() {
        return "Student{" + "ID:" + id + ", Name:" 
                + name + ", Mark:" + mark + ", Rank:" + getRanks() + '}';
    } 
}