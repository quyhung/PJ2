import com.vti.repository.ExamRepository;
import com.vti.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;

public class ExamApp {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        while (true) {
            ProgramExam programExam = new ProgramExam();
            String leftAlignFormat = "| %-72s |%n";
            System.out.format("+--------------------------------------------------------------------------+%n");
            System.out.format("| Mời bạn chọn chức năng muốn sử dụng                                      |%n");
            System.out.format("+--------------------------------------------------------------------------+%n");
            System.out.format(leftAlignFormat, "1. Tạo mới Exam");
            System.out.format(leftAlignFormat, "2. Lấy ra danh sách Exam ");
            System.out.format(leftAlignFormat, "3. Cập nhật Exam");
            System.out.format(leftAlignFormat, "4. Xóa Exam");
            System.out.format(leftAlignFormat, "5. Thoát chương trình");
            System.out.format("+--------------------------------------------------------------------------+%n");
            switch (ScannerUtils.inputIntPositive()) {
                case 1:
                    programExam.createExam();
                    break;
                case 2:
                    programExam.getAllExam();
                    break;
                case 3:
                    programExam.updateExam();
                    break;
                case 4:
                    programExam.deleteExam();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Nhập lại:");
                    break;
            }
        }

    }
}
