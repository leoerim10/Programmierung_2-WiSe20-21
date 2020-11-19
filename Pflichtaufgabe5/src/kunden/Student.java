package kunden;

public class Student extends Privatperson{
    private String hochschuleName;

    public Student(){
    }

    public Student(String vorname, String nachname, String hochschuleName) {
        super(vorname, nachname);
        this.hochschuleName = hochschuleName;
    }

    public String getHochschuleName() {
        return hochschuleName;
    }

    public void setHochschuleName(String hochschuleName) {
        this.hochschuleName = hochschuleName;
    }


    public String toString() {
        return super.toString() + " ,Student, hochschuleName=" + hochschuleName;
    }




}
