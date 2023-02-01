import com.vti.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;

public class AppAnswer {


    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        while (true) {
            ProgramAnswer programAnswer = new ProgramAnswer();
            String leftAlignFormat = "| %-72s |%n";
            System.out.format("+--------------------------------------------------------------------------+%n");
            System.out.format("| Mời bạn chọn chức năng muốn sử dụng                                      |%n");
            System.out.format("+--------------------------------------------------------------------------+%n");
            System.out.format(leftAlignFormat, "1. Tạo mới Answer");
            System.out.format(leftAlignFormat, "2. Lấy ra danh sách Answer ");
            System.out.format(leftAlignFormat, "3. Cập nhật Answer");
            System.out.format(leftAlignFormat, "4. Xóa Answer");
            System.out.format(leftAlignFormat, "5. Thoát chương trình");
            System.out.format("+--------------------------------------------------------------------------+%n");
            switch (ScannerUtils.inputIntPositive()) {
                case 1:
                    programAnswer.createAnswer();
                    break;
                case 2:
                    programAnswer.getAllAnswer();
                    break;
                case 3:
                    programAnswer.updateAnswer();
                    break;
                case 4:
                    programAnswer.deleteAnswer();
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
