import com.vti.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;

public class PositionApp {


    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        while (true) {
            ProgramPosition programPosition = new ProgramPosition();
            String leftAlignFormat = "| %-72s |%n";
            System.out.format("+--------------------------------------------------------------------------+%n");
            System.out.format("| Mời bạn chọn chức năng muốn sử dụng                                      |%n");
            System.out.format("+--------------------------------------------------------------------------+%n");
            System.out.format(leftAlignFormat, "1. Tạo mới Position");
            System.out.format(leftAlignFormat, "2. Lấy ra danh sách Position ");
            System.out.format(leftAlignFormat, "3. Cập nhật Position");
            System.out.format(leftAlignFormat, "4. Xóa Position");
            System.out.format(leftAlignFormat, "5. Thoát chương trình");
            System.out.format("+--------------------------------------------------------------------------+%n");
            switch (ScannerUtils.inputIntPositive()) {
                case 1:
                    programPosition.createPosition();
                    break;
                case 2:
                    programPosition.getAllPosition();
                    break;
                case 3:
                    programPosition.updatePosition();
                    break;
                case 4:
                    programPosition.deletePosition();
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
