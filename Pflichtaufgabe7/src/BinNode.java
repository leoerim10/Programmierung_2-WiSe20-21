public class BinNode {

    int data;
    BinNode left, right;

    BinNode(){
    }

    BinNode(int d){
        data = d;
        left = right = null;
    }

    BinNode(int d, BinNode l, BinNode r){
        data = d;
        left = l;
        right = r;
    }
}
