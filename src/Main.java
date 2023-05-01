import java.util.Random;

public class Main {
    public static void main(String[] args) {

        MyHashTable<MyTestingClass, Integer> MyHashtable = new MyHashTable<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            String randomStudentId = generateRandomStudentId();
            int[] randomGrade = generateRandomGrade();
            MyTestingClass test = new MyTestingClass(randomStudentId, randomGrade);
            Integer value = random.nextInt(100);
            MyHashtable.put(test, value);
        }


    }

    private static String generateRandomStudentId() {
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int LENGTH = 7;

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < LENGTH; i++) {
            int index = random.nextInt(CHARS.length());
            char c = CHARS.charAt(index);
            sb.append(c);
        }

        return sb.toString();
    }

    private static int[] generateRandomGrade() {
        Random random = new Random();
        int length = 4;
        int[] randomGrade = new int[length];
        for (int i = 0; i < length; i++) {
            randomGrade[i] = random.nextInt(1, 5);
        }
        return randomGrade;
    }

}
