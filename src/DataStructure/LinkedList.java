package DataStructure;

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

public class LinkedList {
    Node head;

    public LinkedList() {
        head = null;
    }

    public void add(int value) {
        if (head != null) {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        } else {
            head = new Node(value);
        }
    }

    // How to tranversal throught all element in linkedlist ?
    public void print() {
        int count = 0;
        Node current = head;
        while (current != null) {
            System.out.print(current.value);
            current = current.next;
            if (current != null) {
                System.out.print("->");
            } else {
                System.out.println("");
            }
        }
    }
}