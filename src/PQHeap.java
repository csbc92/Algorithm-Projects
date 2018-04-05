import java.util.Arrays;

/**
 * Priority Queue Heap implementation.
 * Lavet af Christian Skafte Beck Clausen Chcla15 og Daniel Johansen Dajoh16
 */
public class PQHeap implements PQ {

    private Element[] elements;
    private int heapSize;

    public PQHeap(int maxElements) {
        elements = new Element[maxElements];
        heapSize = -1;

    }

    /**
     * Extracts the root element which is the min element
     *
     * @return
     */
    @Override
    public Element extractMin() {
        Element min = elements[0];
        elements[0] = elements[heapSize];
        heapSize--;
        minHeapify(0);
        return min;
    }

    /**
     * Inserts an element into the priority queue heap
     *
     * @param element
     */
    @Override
    public void insert(Element element) {
        heapSize++;
        int i = heapSize;

        elements[i] = element;
        if (elements[parent(i)] != null && elements[i] != null) {
            while (i > 0 && elements[parent(i)].key > elements[i].key) {
                Element temp = elements[parent(i)];
                elements[parent(i)] = elements[i];
                elements[i] = temp;
                i = parent(i);
            }
        }
    }

    /**
     * Rebuilds the heap based on a min heap structure. The call is recursive.
     *
     * @param i
     */
    private void minHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest;
        if (left <= heapSize && elements[left].key < elements[i].key) {
            smallest = left;
        } else {
            smallest = i;
        }
        if (right <= heapSize && elements[right].key < elements[smallest].key) {
            smallest = right;
        }
        if (smallest != i) {
            Element temp = elements[smallest];
            elements[smallest] = elements[i];
            elements[i] = temp;
            minHeapify(smallest);
        }
    }

    /**
     * returns the left node index
     * @param i
     * @return
     */
    private int left(int i) {
        return 2 * i + 1;
    }

    /**
     * Returns the right node index
     * @param i
     * @return
     */
    private int right(int i) {
        return 2 * i + 2;
    }

    /**
     *
     * Returns -1 if at root.
     *
     * @param i
     * @return
     */
    private int parent(int i) {
        return (int) (Math.ceil(i / 2) - 1);
    }
}


