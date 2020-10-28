public class Student extends Person {

    private int matrikelNummer;

    public Student(){
    }

    public Student (String vorname, String nachname, char geschlecht, int matrikelNummer){
        super(vorname, nachname, geschlecht);
        this.matrikelNummer = matrikelNummer;

    }

    public int getMatrikelNummer() {
        return matrikelNummer;
    }

    public void setMatrikelNummer(int matrikelNummer) {
        this.matrikelNummer = matrikelNummer;
    }


    @Override
    public String toString() {
        return super.toString() + " matriculation number:" + matrikelNummer;
    }
}
