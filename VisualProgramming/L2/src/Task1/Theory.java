package Task1;

public class Theory implements Course {
    String instructorName;

    
    public void startCourse(){
        System.out.println("Theory course session started.");
    }
    @Override
    public void endCourse(){
        System.out.println("Theory course session ended.");
    }

    public void takeQuiz(){
        System.out.println("Quiz running.");
    }
}
