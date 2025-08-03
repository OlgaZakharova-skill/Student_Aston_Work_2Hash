import java.util.Arrays;

public class ArrayList {
    public static int SIZE = 10;
    public int[] array = new int[SIZE];
    public int elements = 0;

    ArrayList() {
    }

    public void add(int x) {
        array[elements] = x;
        elements += 1;
    }

    public int get(int i) {
        checkIndex(i);
        return array[i];
    }

    public void remove(int x) {
        checkIndex(x);
        for (int i = x; i < elements; i++) {
            array[i] = array[i + 1];
        }
        elements -= 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, elements));
    }

    public void addAll(int[] x) {
        for (int i = 0; i < x.length; i++) {
            array[elements] = x[i];
            elements += 1;
        }
    }

    private void checkIndex(int i) {
        if (i < 0 || i >= elements) {
            throw new IndexOutOfBoundsException("Index: " + i + "elements:" + elements);
        }
    }


}
