package Task1;
import java.util.Scanner;
public class Online implements Course{
    String platform;
    String lectureName;
    @Override
    public void startCourse(){
        System.out.println("Online course session started.");
    }
    @Override
    public void endCourse(){
        System.out.println("Online course session ended.");
    }

    public void uploadLecture(){
        Scanner sc = new Scanner(System.in);
        lectureName = sc.nextLine();
        System.out.println("Lecture " + lectureName + " uploaded on " + platform);
        
    }
}
