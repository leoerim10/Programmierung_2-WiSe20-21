public class Component {

    private double price;
    private  boolean aktiv;
    private String description;


    public Component(){
        System.out.println("Warning, Constructor without parameter is called!!!");
    }

    public Component (double price,  boolean aktiv, String description){
        this.price = price;
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
        return aktiv;
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
