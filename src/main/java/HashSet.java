import com.sun.tools.javac.util.JCDiagnostic;
import com.sun.tools.javap.TypeAnnotationWriter;

public class HashSet {
    public static final int SIZE = 16;
    public static final float LOAD = 0.8f;
    public Node[] cells;
    public int size;

    public HashSet() {
        cells = new Node[SIZE];
        size = 0;
    }

    public HashSet(Node[] cells, int size) {
        this.cells = cells;
        this.size = size;
    }

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }


    public void add(int value) {
        if (contains(value)) {
            return;
        }
        int index = getIndex(value);
        Node node= new Node(value);
        node.next = cells[index];
        cells[index] = node;
        size += 1;
        if (size > LOAD * cells.length) {
            rehash();
        }
    }

    public void remove(int value) {
        int index = getIndex(value);
        Node first = cells[index];
        Node previous = null;

        while (first != null) {
            if (first.value == value) {
                if (previous == null) {
                    cells[index] = first.next;
                } else {
                    previous.next = first.next;
                }
                size -= 1;
                return;
            }
            previous = first;
            first = first.next;
        }
    }

    private int getIndex(int value) {
        return hash(value) % (cells.length - 1);
    }

    private void rehash() {
        Node[] previousCell = cells;
        cells = new Node[2 * previousCell.length];
        size = 0;

        for (Node first : previousCell) {
            while (first != null) {
                add(first.value);
                first = first.next;
            }
        }
    }

    private int hash(int value) {
        int hash = value * cells.length;
        return hash ^ (hash >>> 16);
    }

    public boolean contains(int value) {
        int index = getIndex(value);
        Node first = cells[index];
        while (first != null) {
            if (first.value == value) {
                return true;
            }
            first = first.next;
        }
        return false;
    }
}

