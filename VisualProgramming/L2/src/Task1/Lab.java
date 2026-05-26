package Task1;

public class Lab implements Course {
    String[] equipments;
    @Override
    public void startCourse(){
        System.out.println("Lab course session started.");
    }
    @Override
    public void endCourse(){
        System.out.println("Lab course session ended.");
    }

    public void showEquipment(){
        System.out.println("Lab equipments are:" + equipments);
    }
}
