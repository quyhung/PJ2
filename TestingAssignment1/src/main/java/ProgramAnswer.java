import com.vti.entity.Answer;
import com.vti.repository.AnswerRepository;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class ProgramAnswer {
    private AnswerRepository answerRepository;
    public ProgramAnswer(){
        answerRepository= new AnswerRepository();
    }


    public void createAnswer() {
        System.out.println("==== Create Answer ====");
        System.out.println("Nhập vào nội dung câu hỏi");
        String content = ScannerUtils.inputString();
        System.out.println("Câu hỏi này là đúng hay sai \n Lựa chọn 1.True 2.False");
        int choose = ScannerUtils.inputIntPositive();
        Answer answer = new Answer();
        while (true){
        switch (choose){
            case 1:
                answer.setCorrect(true);
                break;
            case 2:
                answer.setCorrect(false);
                break;
            default:
                System.out.println("Nhập lại");
                break;

        }
        answer.setContent(content);
        answerRepository.createAnswer(answer);
        }
    }

    public void getAllAnswer() {
        System.out.println("==== Get All Answer ====");
        List<Answer> list = answerRepository.getAllAnswer();
        for (Answer getAllAnswer : list
        ) {
            System.out.println(getAllAnswer);

        }
    }

    public void updateAnswer() {
        System.out.println("====== Update Answer ======");
        System.out.println("Nhập vào thông tin cần cập nhật");
        System.out.println("Nhập vào Id cần cập nhật");
        short updateId = (short) ScannerUtils.inputInt();
        if (answerRepository.getAnswerById(updateId)!=null){
            System.out.println("Nhập vào nội dung câu hỏi");
            String updateContent = ScannerUtils.inputString();
            System.out.println("Câu hỏi này là đúng hay sai");
            boolean isCorrect = ScannerUtils.inputString().isEmpty();
            Answer updateAnswer = new Answer();
            updateAnswer.setAnswerId(updateId);
            updateAnswer.setContent(updateContent);
            updateAnswer.setCorrect(isCorrect);
            answerRepository.updateAnswer(updateAnswer);

        }else {
            System.out.println("Department có Id=" + updateId + " không tồn tại, vui lòng kiểm tra lại.");

        }

    }


    public void deleteAnswer() {
        System.out.println("====== Delete Answer ======");
        System.out.println("Nhập vào Id muốn xóa");
        short deleteId = (short) ScannerUtils.inputInt();
        if (answerRepository.getAnswerById(deleteId)!=null){
            answerRepository.deleteAnswer(deleteId);

        }else {
            System.out.println("Department có Id=" + deleteId + " không tồn tại, vui lòng kiểm tra lại.");

        }

    }



}

