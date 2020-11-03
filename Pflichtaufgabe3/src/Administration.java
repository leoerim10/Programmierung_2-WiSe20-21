public class Administration {


    /**
     * creates a list from any number of persons and returns it
     * @param persons who will be included in the list
     * @return array of Person-objects
     */
    public static Person[] createList(Person... persons){
    Person[] people = persons;
        return people;
    }



    /**
     * outputs a given list of persons as a String
     * @param list array of persons
     * @return String representation of the array of persons
     * @throws NullPointerException if the array of persons is null
     */
    public static String outputList(Person[] list) throws NullPointerException {
        if (list == null) {
            throw new NullPointerException("Error!!! array cannot be null.");
        } else {
            String res = "[";
            for (int i = 0; i <list.length-1; i++) {
                res = res + list[i].toString() + ", ";
            }
            res = res + list[list.length-1].toString() +"]";
            return res;
        }
    }



    /**
     * sorts in ascending order a given list of persons by last name
     * @param list array of persons to be sorted
     * @return sorted array of persons
     * @throws NullPointerException if the array of persons is null
     */
    public static Person[] sortList(Person[] list) throws NullPointerException{
        if (list == null) {
            throw new NullPointerException("Error!!! array cannot be null.");
        }else {
            // sorting by bubble sort algorithm
            for (int j = 0; j <( list.length); j++) {
                for (int i = 0; i < list.length-1; i++) {
                if (list[i].getNachname().compareTo(list[i+1].getNachname()) >= 0) {
                    Person temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                }
                }
            }
        }
        return list;
    }




    /**
     * counts female persons in a given list of persons
     * @param list array of persons
     * @return number of female
     * @throws NullPointerException  if the array of persons is null
     */
    public static int countFemale(Person[] list) throws NullPointerException{
        if (list == null) {
            throw new NullPointerException("Error!!! array cannot be null.");
        } else{
            int count = 0;
            for (int i = 0; i< list.length; i++){
                if(list[i].getGeschlecht() == 'f'){
                    count++;
                }
            }
            return count;
        }
    }



}
