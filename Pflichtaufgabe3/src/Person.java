public class Person {

    private String vorname;
    private String nachname;
    private char geschlecht;

    public Person(){
    }

    public Person (String vorname, String nachname, char geschlecht){
        this.vorname = vorname;
        this.nachname = nachname;
        this.geschlecht = geschlecht;
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

    public void setGeschlecht(char geschlecht) {
        if(geschlecht == 'm'){
            this.geschlecht = geschlecht;
        }else if(geschlecht == 'f'){
            this.geschlecht = geschlecht;
        }else if(geschlecht == 'd'){
            this.geschlecht = geschlecht;
        }else{
            throw new IllegalArgumentException("wrong input given, please enter the valid input!");
        }

    }


    @Override
    public String toString() {
        return "vorname: " + vorname + " nachname: " + nachname  + ", geschlecht: " + geschlecht;
    }
}
