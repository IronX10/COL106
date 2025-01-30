
class Node {
    String data;
    Node next;

    public Node(String var1) {
        this.data = var1;
        this.next = null;
    }
}


public class Number{
    public Node numlink(int num) {
        if (num == 0) {
            return new Node("0");
        }


        Node right;
        if (num>0) {
            right = new Node("+");
        } else {
            right = new Node("-");
        }
        
        num = Math.abs(num);
         int size = (int) (Math.log(num) / Math.log(10)) + 1;
        Node left = right;
        for (int i = 0; i < size; i++) {
            Node str = new Node(String.valueOf(num % 10));
            num = num / 10;
            left.next = str;
            left = str;
        }
        return right;
    }

    public void printList(Node head) {
        Node current = head;
        while (current.next != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
System.out.print(current.data);
        System.out.println("");
    }

    public Node add(Node head1, Node head2) {
        Node a = head1;
        Node b = head2;
        Node store;
        boolean carry = false;
        if (a.data == b.data) {
            store = new Node(a.data);
            Node curr = store;
            while (a.next != null && b.next != null) {

                a = a.next;
                b = b.next;
                int car = 0;
                if (carry) {
                    car = 1;
                }
                int sum = Integer.parseInt(a.data) + Integer.parseInt(b.data) + car;
                car = 0;
                Node str = new Node(String.valueOf(sum % 10));
                if (sum > 9) {
                    carry = true;
                }
                curr.next = str;
                curr = str;
            }

            while (a.next != null) {
                int car = 0;
                if (carry) {
                    car = 1;
                }
                Node str = new Node(String.valueOf(Integer.parseInt(a.data) + car));
                car = 0;
                a = a.next;
                curr.next = str;
                curr = str;
            }
            while (b.next != null) {
                int car = 0;
                if (carry) {
                    car = 1;
                }
                Node str = new Node(String.valueOf(Integer.parseInt(b.data) + car));
                car = 0;
                b = b.next;
                curr.next = str;
                curr = str;
            }
            if (carry) {
                Node str = new Node("1");
                curr.next = str;
                curr = str;
            }
            return store;
        }
        return null;
    }

    public Node operation(Node A ,Node B) {
        Node store;
        Node dummy;
        Node a = A;
        Node b = B;
        a = a.next;
        b = b.next;
        if (Integer.parseInt(a.data) < Integer.parseInt(B.data)) {
             dummy = a;
             a = a.next;
             store = dummy;
             dummy = dummy.next;
        }
        else{
            dummy = b;
        b = b.next;
        store = dummy;
        dummy = dummy.next;
    }


    while (a != null && b != null) {
        if (Integer.parseInt(a.data) < Integer.parseInt(b.data)) {
            dummy = a;
            a = a.next;
            dummy = dummy.next;
        } else {
            dummy = b;
            b = b.next;
            dummy = dummy.next;
        }
    }
    if (a != null) {
        dummy = a;
    }
    if (b != null) {
        dummy = b;
    }
       
    return store;

     }

    public static void main(String[] args) {
        Number num = new Number();

        Node digit1 = num.numlink(-744);
        Node digit2 = num.numlink(-7976);
        Node sum = num.operation(digit1, digit2);
        num.printList(sum);

    }
}
