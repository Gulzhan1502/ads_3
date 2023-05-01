public class MyTestingClass {
    private String fname;
    private String lname;

    public MyTestingClass(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        String strKey = String.valueOf(this.fname + " " + this.lname);
        for (int i = 0; i < strKey.length(); i++) {
            hash += (int) strKey.charAt(i);
        }
        return hash;
    }


    @Override
    public String toString() {
        return "%s".formatted(this.fname, this.lname);    }
}
