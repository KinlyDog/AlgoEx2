import java.util.*;

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        this.head = null;
        this.tail = null;
    }

    // ok
    public void addInTail(Node _item) {
        if (this.head == null) {
            this.head = _item;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }

        this.tail = _item;
    }

    // ok
    public Node find(int _value) {
        Node node = this.head;

        while (node != null) {
            if (node.value == _value) {
                return node;
            }

            node = node.next;
        }

        return null;
    }

    // ok
    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<>();
        Node node = this.head;

        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }

            node = node.next;
        }

        return nodes;
    }

    // ok
    public boolean remove(int _value) {
        if (find(_value) == null) {
            return false;
        }

        Node node = this.head;

        if (node.next == null) {
            clear();
            return true;
        }

        if (this.head.value == _value) {
            this.head = node.next;
            this.head.prev = null;
            node.next = null;

            return true;
        }

        while (node.value != _value) {
            node = node.next;
        }

        if (node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.prev = null;
            node.next = null;

            return true;
        }

        this.tail = node.prev;
        this.tail.next = null;
        node.prev = null;

        return true;
    }

    // ok
    public void removeAll(int _value) {
        while (remove(_value));
    }

    // ok
    public void clear() {
        this.head = null;
        this.tail = null;
    }

    // ok
    public int count() {
        Node node = this.head;
        int c = 0;

        while (node != null) {
            c++;
            node = node.next;
        }

        return c;
    }

    // ok
    public void insertFirst(Node _nodeToInsert) {
        if (this.head == null) {
            this.head = _nodeToInsert;
            this.tail = _nodeToInsert;

            return;
        }

        _nodeToInsert.next = this.head;
        this.head.prev = _nodeToInsert;
        this.head = _nodeToInsert;

        if (count() == 1) {
            this.tail = _nodeToInsert;
        }
    }

    // ok
    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null) {
            insertFirst(_nodeToInsert);
            return;
        }

        if (this.tail == _nodeAfter) {
            addInTail(_nodeToInsert);

            return;
        }

        Node node = this.head;

        while (node != _nodeAfter) {
            node = node.next;
        }

        _nodeToInsert.prev = node;
        _nodeToInsert.next = node.next;

        node.next.prev = _nodeToInsert;
        node.next = _nodeToInsert;
    }
}