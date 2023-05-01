import java.util.Objects;

public class Attendance extends Object {
    private String attendance;

    public Attendance(String attendance){
        this.attendance = attendance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        String strKey = String.valueOf(this.attendance);
        for (int i = 0; i < strKey.length(); i++) {
            hash += (int) strKey.charAt(i);
        }
        return hash;
    }

    @Override
    public String toString() {
        return "%s".formatted(this.attendance);
    }
}
