// Name : Pavan Pandya
// NetID : pjpandya@syr.edu
// Su ID : 340197894

package edu.syr.hw3;

public class Node<Generic> {
    private Generic value;
    public Node<Generic> next;

    public Node (Generic i) {
        this.value = i;
    }

    public static <Generic> Node<Generic> build(Generic[] data) {
        Node<Generic> list = new Node<>(null);
        Node<Generic> iter = list;
        for (Generic d: data) {
            iter.next = new Node<>(d);
            iter = iter.next;
        }
        return list.next;
    }

    public static void main(String[] args) {
        Node<String> s1 = new Node<String>("hello");
        Node<Integer> i1 = new Node<Integer>(Integer.valueOf(99));
        //s1.next = i1; //this should be a compile error

        String[] data = new String[]{"one", "two", "three"};
        Node<String> head = Node.build(data);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
        StringBuffer[] sbData = new StringBuffer[]{new StringBuffer("uno"), new StringBuffer("dos"), new StringBuffer("tres")};
        Node<StringBuffer> h2 = Node.build(sbData);
        while (h2 != null) {
            System.out.println(h2.value.toString());
            h2 = h2.next;
        }
    }
}