import javax.swing.*;

public class ComponentManager {

    private Component [] components = new Component[10]; // components should hold 10 elements, by design.
    public ComponentManager() {
        System.out.println("Parameter without constructor is called!!!");
    }


    /**
     * add the bought part to the component array
     * @param part parts which have been bought
     */
    public void buyComponent(Component part){
        for(int i = 0; i < this.components.length; i++) {
            if (this.components[i] == null) {
                this.components[i] = part;
                return;
            }
        }
        throw new ArrayIndexOutOfBoundsException("No new parts can be added. The array is full.");
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
                if(components[i] != null){
                    sum++;
                }
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
        for(int i = 0; i < this.components.length; i++) {
            if( this.components[i] == null){   // checks if the component is null
                return null;
            }
            else if (name == this.components[i].getDescription()) {
                return this.components[i];
            }else{
                continue; // if the compared String is not same
            }
        }
        return null;
    }


    /**
     * calculate the total price of the bought components
     * @return the total amount
     */
    public double calculatePrice(){
        double sum = 0;
        if (this.components == null) {
            throw new NullPointerException("Error!!! Null array");
        } else {
            for (int i = 0; i < this.components.length; i++) {
                if(components[i] != null){
                    sum += components[i].getPrice();
                }
            }
        }
        return sum;
    }


    /**
     * calculate the total price of both active and passive components
     * @param active active or passive components
     * @return the total amount
     */
    public double calculatePrice(boolean active){
        double sum = 0;
        if (this.components == null) {
            throw new NullPointerException("Error!!! Null array");
        } else {
            for (int i = 0; i < this.components.length; i++) {
                if(components[i] != null && components[i].isAktiv() == active){
                    sum = sum+ components[i].getPrice();
                }
            }
        }
        return sum;
    }


    /**
     * calculates the total time invested for the components
     * @return the total time
     */
    public int calculateOperatingHours(){
        int sum = 0;
        if (this.components == null) {
            throw new NullPointerException("Error!!! Null array");
        } else {
            for (int i = 0; i < this.components.length; i++) {
                if(components[i] != null && components[i] instanceof UsedPart){
                    sum += ((UsedPart) components[i]).getOperatingHours();
                }
            }
            return sum;
        }
    }
}
