public class PhoneBook extends BinTreeGen<Person> {

    public PhoneBook(BinNodeGen<Person> root) {
        super(root);
    }

    public PhoneBook(Person p) {
        super(p);
    }

    public PhoneBook(){
    }

    /**
     * count the number of person in the phone book
     * @return the number of person
     */
    public int countEntries() {
        return super.countNodes();
    }

    /**
     * add the new person to the phone book
     * @param p person to be added
     * @return true if the person was successfully added
     */
    public boolean insertPerson(Person p) {
        boolean result = super.insertNode(p);
        return result;
    }

    /**
     * search the person in the phone book with the surname
     * @param name surname that needed to be searched
     * @return the details of the searched person
     */
    public Person searchPerson(String name) {
        Person p = new Person("", name, 0);
        BinNodeGen<Person> toReturn = super.find(p);
        return toReturn.data;
    }


    /////////////////////////////////////////////


    public void print() {
        super.print2D();
    }
}