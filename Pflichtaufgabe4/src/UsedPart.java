public class UsedPart extends Component {

    private int operatingHours;

    public UsedPart(){
        System.out.println("Construct without parameter is called");
    }

    public UsedPart(String description, double price, boolean aktiv,  int operatingHours) {
        super(price, aktiv, description);
        this.operatingHours = operatingHours;
    }

    public int getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(int operatingHours) {
        this.operatingHours = operatingHours;
    }

    @Override
    public String toString() {
        return super.toString() + ", operatingHours: " + operatingHours;
    }
}
