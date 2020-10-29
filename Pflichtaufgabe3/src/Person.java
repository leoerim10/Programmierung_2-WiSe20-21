public class Person {

    private String vorname;
    private String nachname;
    private char geschlecht;

    public Person(){
        System.out.println("Warning, Constructor without parameter is called!!!");
    }

    public Person (String vorname, String nachname, char geschlecht) throws IllegalArgumentException{
        this.vorname = vorname;
        this.nachname = nachname;
        if(geschlecht == 'm' || geschlecht == 'f' || geschlecht == 'd'){
            this.geschlecht = geschlecht;
        }else{
            throw new IllegalArgumentException("wrong input given, please enter the valid input!");
        }
    }


    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public char getGeschlecht() {
        return geschlecht;
    }


    @Override
    public String toString() {
        return  vorname + " " + nachname;
    }
}
