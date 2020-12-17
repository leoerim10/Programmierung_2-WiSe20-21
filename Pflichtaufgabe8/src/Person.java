public class Person implements Comparable<Person>{

    String firstName, lastName;
    int phoneNumber;

    public Person(){
    }

    public Person(String firstName, String lastName, int phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Person p) {
        if(this.lastName == p.lastName) {
            return 0;
        }
        return this.lastName.compareTo(p.lastName);
    }

    public String toString() {
        return String.format("%s, %s: %d", lastName, firstName, phoneNumber);
    }
}