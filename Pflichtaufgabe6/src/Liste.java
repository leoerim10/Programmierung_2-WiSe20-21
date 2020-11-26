/**
 * super class to both stack and queue classes
 * @author Sameer Dhimal, Wojciech Maximilian Frackowski
 */
public class Liste {
    Node start = null;

   public Liste(){
   }

   /**
    * finds the size of the given data structure by counting next node recursively
    * @return its size
    */
   public int size(){
      Node current = start;
      int counter = 0;
      while(current != null){
         counter++;
         current = current.next;
      }
      return counter;
   }


   /**
    * check if the given data structure is empty
    * @return true if empty
    */
   public boolean isEmpty(){
      return this.start == null;
   }

}
