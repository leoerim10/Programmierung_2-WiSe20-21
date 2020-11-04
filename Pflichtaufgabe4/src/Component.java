public class Component {

    private double price;
    private final boolean aktiv;
    private String description;

    public Component(){
        this.aktiv = false; //a blank final instance variable must be definitely assigned at the end of every constructor.
        System.out.println("Warning, Constructor without parameter is called!!!");
    }

    public Component (String description, double price, boolean aktiv) throws IllegalArgumentException{
        if(price<0){
            throw new IllegalArgumentException("price for a component cannot be negative.");
        }else{
            this.price = price;
        }
        this.aktiv = aktiv;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAktiv() {
        return this.aktiv;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "price: " + price + ", aktiv: " + aktiv + ", description='" + description ;
    }
}
