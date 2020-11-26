import java.util.EmptyStackException;

public class Queue extends Liste implements QueueSchnittstelle{

    public Queue(){
        super();
    }

    @Override
    public void enqueue(int x) {
        Node n = new Node(x);
        Node curr = this.start; // temporary node
        if(this.start == null){ // start is the first element of the queue
            this.start = n;
        }else{
            while(curr.next != null){
                curr = curr.next; // overwrite curr with its next node
            }
            curr.next = n; // curr is the last element now, next element is null
        }
    }

    @Override
    public int dequeue() throws EmptyStackException {
        if(this.start == null){
            throw new EmptyStackException();
        }
        Node temp = this.start;
        this.start = this.start.next;
        return temp.data;
    }

    @Override
    public int first() throws EmptyStackException{
        if(this.start == null){
            throw new EmptyStackException();
        }
        return this.start.data;
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public String toString() {
        String res = "<--- ";
        Node n = this.start;
        while(n != null){
            res = res + n.data + " ";
            n  = n.next;
        }

        res = res + "<---";

        return res;
    }
}
