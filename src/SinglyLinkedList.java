public class SinglyLinkedList {
    SinglyLinkedNode head;

    // Constructors
    public SinglyLinkedList() {
    }

    public SinglyLinkedList(SinglyLinkedNode head) {
        this.head = head;
    }

    public SinglyLinkedList(Object headData) {
        head = new SinglyLinkedNode(headData);
    }


    public void add(Object data) {
        addFirst(data);
    }

    public void addFirst(Object data) {
        SinglyLinkedNode e = new SinglyLinkedNode(data);
        e.next = head;

        head = e;
    }

    public void addLast(Object data) {
        if (head == null) {
            addFirst(data);
            return;
        }

        SinglyLinkedNode pivot = head;
        SinglyLinkedNode newElement = new SinglyLinkedNode(data);

        while (pivot.next != null) {
            pivot = pivot.next;
        }
        pivot.next = newElement;
    }

    public boolean add(int index, Object data) {
        if (index < 0 || size() < index) {
            return false;
        }

        if (index == 0) {
            addFirst(data);
        } else if (index == size()) {
            addLast(data);
        } else {

            SinglyLinkedNode pivot = head;

            for (int i = 0; i < index - 1; i++) {
                pivot = pivot.next;
            }

            SinglyLinkedNode temp = new SinglyLinkedNode(data);
            temp.next = pivot.next;
            pivot.next = temp;
        }
        return true;
    }

    public SinglyLinkedNode get(int index) {
        if (index < 0 || size() <= index) {
            return null;
        }

        SinglyLinkedNode pivot = head;
        for (int i = 0; i < index; i++) {
            pivot = pivot.next;
        }

        return pivot;
    }


    public int size() {
        int count = 0;
        SinglyLinkedNode pivot = head;

        while (pivot != null) {
            pivot = pivot.next;
            count++;
        }

        return count;
    }


    public boolean removeFirst() {
        if (size() != 0) {
            head = head.next;
            return true;
        } else {
            return false;
        }
    }

    public boolean removeLast() {
        if (size() == 0) {
            return false;
        } else if (size() == 1) {
            head = null;
            return true;
        } else {
            SinglyLinkedNode pivot = head;

            while (pivot.next.next != null) {
                pivot = pivot.next;
            }
            pivot.next = null;
            return true;
        }
    }

    public boolean remove() {
        return removeFirst();
    }

    public boolean remove(int index) {
        SinglyLinkedNode pivot = head;

        if (index < 0 || size() <= index) {
            return false;
        } else if (index == 0) {
            removeFirst();
            return true;
        } else {
            for (int i = 0; i < index - 1; i++) {
                pivot = pivot.next;
            }

            pivot.next = pivot.next.next;
            return true;
        }
    }

    public boolean remove(Object data) {
        return removeFirst(data);
    }

    public boolean removeFirst(Object data) {
        SinglyLinkedNode pivot = head;

        for (int i = 0; i < size(); i++) {
            if (pivot.data.equals(data)) {
                remove(i);
                return true;
            } else {
                pivot = pivot.next;
            }
        }
        return false;
    }

    public boolean removeLast(Object data) {
        SinglyLinkedNode pivot = head;
        int target = -1;

        for (int i = 0; i < size(); i++, pivot = pivot.next) {
            if (pivot.data.equals(data)) {
                target = i;
            }
        }

        if (target != -1) {
            remove(target);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeAll(Object data) {
        SinglyLinkedNode pivot = head;
        boolean isDeleted = false;

        for (int i = 0; i < size(); pivot = pivot.next) {
            if (pivot.data.equals(data)) {
                remove(i);
                isDeleted = true;
            } else {
                i++;
            }
        }

        return isDeleted;
    }

    public boolean clear() {
        if (head != null) {
            head = null;
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String stringView = "";
        if (head == null) {
            stringView = "null";
        } else {
            SinglyLinkedNode pivot = head;

            while (pivot != null) {
                stringView += pivot.toElementString();
                pivot = pivot.next;
            }
        }
        return stringView;
    }
}
