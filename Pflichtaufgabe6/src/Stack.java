import java.util.EmptyStackException;

public class Stack extends Liste implements StackSchnittstelle{

    public Stack(){
        super();
    }

    @Override
    public void push(int data) {
        Node n = new Node(data);
        n.next = start;  // start is the topmost element of the stack
         start = n;
    }

    @Override
    public int pop() throws EmptyStackException{
        if(start == null){
            throw new EmptyStackException();
        }
        Node n = start;
        start = start.next;
        return n.data;
    }

    @Override
    public int top() throws EmptyStackException {
        if(start == null){
            throw new EmptyStackException();
        }
        return start.data;
    }

    @Override
    public boolean isEmpty() {
       return super.isEmpty();
    }


    @Override
    public String toString() {
        Node n = start;
        String res = "";
        while(n != null){
            res = res +"** " + n.data +" **" + "\n";
            n = n.next;
        }
        return res + "*******";
    }
}
