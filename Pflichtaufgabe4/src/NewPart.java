public class NewPart extends Component{

    private boolean packaget;

    public NewPart(){
        super();
        System.out.println("Construct without parameter is called");
    }

    public NewPart(String description, double price, boolean aktiv, boolean packaget){
        super(description, price, aktiv);
        this.packaget = packaget;
    }

    public boolean isPackaget() {
        return packaget;
    }

    public void setPackaget(boolean packaget) {
        this.packaget = packaget;
    }

    @Override
    public String toString() {
        return super.toString() + ", packaget:" + packaget;
    }
}
