import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable <MyTestingClass, Attendance> table = new MyHashTable<>(10000);
        Random rand = new Random();
        for (int i = 0; i < 10000; i++){
            Attendance attendance = new Attendance(rand.nextInt(2) == 0 ? "Present" : "Absent");
            MyTestingClass myTestingClass = new MyTestingClass("first name" + i, "last name" + i);
            table.put(myTestingClass, attendance);
        }
    }
}
