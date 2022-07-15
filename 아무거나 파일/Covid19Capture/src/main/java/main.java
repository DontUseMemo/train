import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class main {
    public static void main(String[] args) {
        String saveFilePath = "D:\\";
        //파일명을 시간 수치를 더하여 저장
        String saveFileName = "test";
        String saveFileExtension = "png";
        
        //시간을 불러오는 변수
        
        //시간을 불러오는 변수의 수치를 확인하여 캡쳐 메서드 실행

        

        try {
            Robot robot = new Robot();
            Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage image = robot.createScreenCapture(rectangle);
            image.setRGB(0,0,100);

            File file = new File(saveFilePath+saveFileName+"."+saveFileExtension);
            ImageIO.write(image, saveFileExtension, file);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
