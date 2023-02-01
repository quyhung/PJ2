import com.vti.entity.Exam;

import com.vti.repository.ExamRepository;
import com.vti.utils.ScannerUtils;



import java.util.Date;
import java.util.List;

public class ProgramExam {
    private ExamRepository examRepository;
    public ProgramExam() {
        examRepository= new ExamRepository();
    }

    public void createExam() {
        System.out.println("=====Create Exam=====");
        System.out.println(new Date());
        System.out.println("Nhập vào mã đề thi");
        String code = ScannerUtils.inputString();
        System.out.println("Nhập vào tiêu đề của đề thi");
        String title = ScannerUtils.inputString();
        System.out.println("Nhập vào thời gian thi");
        short duration = (short) ScannerUtils.inputInt();
        Exam createExam = new Exam();
        createExam.setCode(code);
        createExam.setTitle(title);
        createExam.setDuration(duration);
        examRepository.createExam(createExam);
    }

    public void getAllExam() {
        System.out.println("=====Get All Exam=====");
        List<Exam> examList = examRepository.getAllExam();
        for (Exam exam : examList
        ) {
            System.out.println(exam);

        }
    }

    public void updateExam() {
        System.out.println("=====Update Exam=====");
        System.out.println("Nhập vào Id muốn cập nhật");
        short updateId = (short) ScannerUtils.inputInt();
        if (examRepository.getExamById(updateId)!=null){
            System.out.println("Nhập vào mã đề thi mới ");
            String updateCode = ScannerUtils.inputString();
            System.out.println("Nhập vào tiêu đề mới");
            String updateTitle = ScannerUtils.inputString();
            System.out.println("Nhập vào thời gian thi mới");
            short updateDuration = (short) ScannerUtils.inputInt();
            Exam updateExam = new Exam();
            updateExam.setExamId(updateId);
            updateExam.setCode(updateCode);
            updateExam.setTitle(updateTitle);
            updateExam.setDuration(updateDuration);
            examRepository.updateExam(updateExam);
        }else {
            System.out.println("Exam có Id=" + updateId + " không tồn tại, vui lòng kiểm tra lại.");

        }




    }

    public void deleteExam() {
        System.out.println("=====Delete Exam=====");
        System.out.println("Nhập vào id muốn xóa");
        short deleteId = (short) ScannerUtils.inputInt();
        if (examRepository.getExamById(deleteId)!=null){
            examRepository.deleteExam(deleteId);
        }else {
            System.out.println("Exam có Id=" + deleteId + " không tồn tại, vui lòng kiểm tra lại.");

        }

    }

}
