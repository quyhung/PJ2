

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class ProgramDepartment {
    private static DepartmentRepository departmentRepository;

    public ProgramDepartment() {
        departmentRepository = new DepartmentRepository();
    }

    public void createDepartment() {
        System.out.println("==== Create Department ====");
        System.out.println("Nhập vào tên department cần tạo");
        String inputName = ScannerUtils.inputString();
        Department createDepartment = new Department();
        createDepartment.setName(inputName);
        departmentRepository.createDepartment(createDepartment);
    }

    public void getAllDepartment() {
        System.out.println("==== Get All Department ====");
        List<Department> list = departmentRepository.getAllDepartment();
        for (Department getAllDepartment : list
        ) {
            System.out.println(getAllDepartment);

        }
    }


    public void updateDepartment() {
        System.out.println("====== Update Department ======");
        System.out.println("Nhập vào thông tin cần cập nhật");
        System.out.println("Nhập vào Id cần cập nhật");
        short updateNId = (short) ScannerUtils.inputInt();
        if (departmentRepository.getDepartmentById(updateNId) != null) {
            System.out.println("Nhập vào tên mới");
            String updateName = ScannerUtils.inputString();
            Department updateDepartment = new Department();
            updateDepartment.setId(updateNId);
            updateDepartment.setName(updateName);
            departmentRepository.updateDepartment(updateDepartment);
        } else {
            System.out.println("Department có Id=" + updateNId + " không tồn tại, vui lòng kiểm tra lại.");
        }
    }

    public void deleteDepartment() {
        System.out.println("====== Delete Department ======");
        System.out.println("Nhập vào Id muốn xóa");
        short deleteId = (short) ScannerUtils.inputInt();
        if (departmentRepository.getDepartmentById(deleteId) != null) {
            departmentRepository.deleteDepartment(deleteId);
        } else {
            System.out.println("Department có Id=" + deleteId + " không tồn tại, vui lòng kiểm tra lại.");
        }


    }
}