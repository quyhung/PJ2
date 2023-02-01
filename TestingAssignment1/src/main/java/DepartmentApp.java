import com.vti.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;

public class DepartmentApp {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        while (true) {
            ProgramDepartment programDepartment = new ProgramDepartment();
            String leftAlignFormat = "| %-72s |%n";
            System.out.format("+--------------------------------------------------------------------------+%n");
            System.out.format("| Mời bạn chọn chức năng muốn sử dụng                                      |%n");
            System.out.format("+--------------------------------------------------------------------------+%n");
            System.out.format(leftAlignFormat, "1. Tạo mới Department");
            System.out.format(leftAlignFormat, "2. Lấy ra danh sách Department ");
            System.out.format(leftAlignFormat, "3. Cập nhật Department");
            System.out.format(leftAlignFormat, "4. Xóa Department");
            System.out.format(leftAlignFormat, "5. Thoát chương trình");
            System.out.format("+--------------------------------------------------------------------------+%n");
            switch (ScannerUtils.inputIntPositive()) {
                case 1:
                    programDepartment.createDepartment();
                    break;
                case 2:
                    programDepartment.getAllDepartment();
                    break;
                case 3:
                    programDepartment.updateDepartment();
                    break;
                case 4:
                    programDepartment.deleteDepartment();
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
