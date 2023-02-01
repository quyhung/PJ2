
import com.vti.entity.Position;
import com.vti.entity.PositionName;
import com.vti.repository.PositionRepository;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class ProgramPosition {
    private PositionRepository positionRepository;

    public ProgramPosition() {
        positionRepository = new PositionRepository();
    }


    public void createPosition() {


        System.out.println("==== Create Position ====");
        System.out.println("Nhập vào tên position cần tạo \n (Chọn số tương ứng sau : 1.DEV, 2.SCRUMMASTER, 3.TEST, 4.PM)");
        int inputchoose = ScannerUtils.inputInt();
        PositionName positionName = null;
        switch (inputchoose) {
            case 1:
                positionName = PositionName.DEV;
                break;

            case 2:
                positionName = PositionName.SCRUMMASTER;
                break;

            case 3:
                positionName = PositionName.TEST;
                break;

            case 4:
                positionName = PositionName.PM;
                break;
            default:
                break;

        }
        Position createPosition = new Position();
        createPosition.setPositionName(positionName);
        positionRepository.createPosition(createPosition);
    }

    public void getAllPosition() {
        System.out.println("==== Get All Position ====");
        List<Position> list = positionRepository.getAllPosition();
        for (Position getAllPosition : list
        ) {
            System.out.println(getAllPosition);

        }
    }

    public void updatePosition() {
        System.out.println("====== Update Position ======");
        System.out.println("Nhập vào tên position cần tạo (DEV, SCRUMMASTER,TEST, PM)");
        System.out.println("Nhập vào Id cần cập nhật");
        short updateNId = (short) ScannerUtils.inputInt();
        System.out.println("Nhập vào tên position cần tạo \n ( Chọn số tương ứng sau : 1.DEV, 2.SCRUMMASTER, 3.TEST, 4.PM)");
        int inputchoose = ScannerUtils.inputInt();
        PositionName positionName = null;
        while (true) {
            switch (inputchoose) {
                case 1:
                    positionName = PositionName.DEV;
                    break;

                case 2:
                    positionName = PositionName.SCRUMMASTER;
                    break;

                case 3:
                    positionName = PositionName.TEST;
                    break;

                case 4:
                    positionName = PositionName.PM;
                    break;
                default:
                    break;

            }
            Position updatePosition = new Position();
            updatePosition.setPositionId(updateNId);
            updatePosition.setPositionName(positionName);
            if (positionRepository.getPositionById(updateNId) != null) {
                positionRepository.updatePosition(updatePosition);

            } else {
                System.out.println("Position có Id=" + updateNId + " không tồn tại, vui lòng kiểm tra lại.");

            }
        }


    }


    public void deletePosition() {
        System.out.println("====== Delete Position ======");
        System.out.println("Nhập vào Id muốn xóa");
        short deleteId = (short) ScannerUtils.inputInt();
        if (positionRepository.getPositionById(deleteId) != null) {
            positionRepository.deletePosition(deleteId);
        } else {
            System.out.println("Position có Id=" + deleteId + " không tồn tại, vui lòng kiểm tra lại.");

        }

    }


}

