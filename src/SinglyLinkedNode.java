public class SinglyLinkedNode {
    Object data;
    SinglyLinkedNode next;

    // Constructor
    public SinglyLinkedNode(Object data) {
        this.data = data;
    }

    public SinglyLinkedNode(Object data, SinglyLinkedNode next) {
        this.data = data;
        this.next = next;
    }

    public String toElementString() {
        String stringView = "";

        stringView += '[';
        stringView += data.toString();
        stringView += ']';

        if (next != null) {
            stringView += '-';
        }

        return stringView;
    }

    public String toString() {
        return data.toString();
    }
}


