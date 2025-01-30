

class Node {
   int data;
   Node next;

   public Node(int var1) {
      this.data = var1;
      this.next = null;
   }
}


public class list {
    
    public int middle_ele(Node head) {

        int size = 0;
        Node track = head;
        Node mid = head;
        while (track.next != null) {
            if (size % 2 == 1) {
                mid = mid.next;
            }
            size++;
            track = track.next;
        }
         return mid.data;
    }


   
}
