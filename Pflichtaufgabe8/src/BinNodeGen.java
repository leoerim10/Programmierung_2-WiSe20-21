
public class BinNodeGen<E extends Comparable<E>> {
    E data;
    BinNodeGen<E> left, right;

    public BinNodeGen(E data) {
        this(data, null, null);
    }

    public BinNodeGen(E data, BinNodeGen left, BinNodeGen right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }


    public BinNodeGen() {
        this(null, null, null);
    }

}
