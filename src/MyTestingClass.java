import java.util.Objects;
public class MyTestingClass {

    private String studentId;
    private int[] grade;
    public MyTestingClass(String studentId, int[] grade) {
        this.studentId = studentId;
        this.grade = grade;
    }

    @Override
    public int hashCode() {
        int result = 17;
        for (int i = 0; i < grade.length; i++)
        {
            result = 31 * result + grade[i];
        }
        result = 31 * result + (studentId == null ? 0 : studentId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyTestingClass other = (MyTestingClass) obj;
        return grade == other.grade && Objects.equals(studentId, other.studentId);
    }

    @Override
    public String toString() {
        return "MyTestingClass{" + "studentId='" + studentId + '\'' + ", grade=" + grade + '}';
    }

}