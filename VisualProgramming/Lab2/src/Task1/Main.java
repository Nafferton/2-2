package Task1;

public class Main {
    public static void main(String[] args) {
        Online online = new Online();
        Lab lab = new Lab();
        Theory theory = new Theory();
        online.startCourse();
        online.uploadLecture();
        online.endCourse();
        lab.startCourse();
        lab.endCourse();
        theory.startCourse();
        theory.endCourse();
        theory.takeQuiz();
    }
}
