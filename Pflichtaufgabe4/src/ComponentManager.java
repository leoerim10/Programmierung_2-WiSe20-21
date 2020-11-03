public class ComponentManager {

    Component [] components = new Component[10];

    public ComponentManager(){
        System.out.println("constructor without parameters!!!!!!!");
    }

    public ComponentManager(Component [] components) throws IllegalArgumentException{
        if(components.length >= 10){
            throw new IllegalArgumentException("arrays length cannot be longer than 10");
        }else{
            this.components = components;
        }
    }



    /**
     * add the bought part to the component array
     * @param part parts which have been bought
     */
    public void buyComponent(Component part){
        for(int i = 0; i < this.components.length; i++) {
            if (this.components[i] == null) {
                this.components[i] = part;
                break;
            }else{
                throw new ArrayIndexOutOfBoundsException("No new parts can be added. The array is full.");
            }
        }
    }


    /**
     * outputs the bought components as a String
     * @return string representation of array component
     * @throws NullPointerException if the array is null
     */
    public String outputList() throws NullPointerException{
        String res = "{ ";
        if(this.components == null){
            throw new NullPointerException("Error!!! Null array");
        }else{
            for (int i = 0; i< this.components.length; i++){
                res = res + this.components[i].toString();
            }
        }
        return res + "}";
    }


    /**
     * counts the total components that has been bought
     * @return the total number of those components
     */
    public int getTotalNumber() {
        int sum = 0;
        if (this.components == null) {
            throw new NullPointerException("Error!!! Null array");
        } else {
            for (int i = 0; i < this.components.length; i++) {
                sum++;
            }
            return sum;
        }
    }

    /**
     * searches the given component in the array
     * @param name the component to be searched
     * @return the component if found else returns null
     */
    public Component searchComponent(String name){
        return null;
    }


    /**
     * calculate the total price of the bought components
     * @return the total amount
     */
    public double calculatePrice(){
        return 0;
    }


    /**
     * calculate the total price of both active and passive components
     * @param active active or passive components
     * @return the total amount
     */
    public double calculatePrice(boolean active){
        return 0;
    }


    /**
     * calculates the total time invested for the components
     * @return the total time
     */
    public int calculateOperatingHours(){
        return 0;
    }
}
