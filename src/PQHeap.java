import java.util.Arrays;

/**
 * Created by danie on 02-03-2018.
 */
public class PQHeap implements PQ {

        private Element[] elements;
        private int maxElements;

        public PQHeap(int maxElements){
            elements = new Element[maxElements];
            this.maxElements = maxElements;

        }

        @Override
        public Element extractMin() {
            Element min = elements[0];
            elements[0] = elements[elements.length-1];
            maxElements--;
            minHeapify(0);
            return min;
        }

        @Override
        public void insert(Element element) {
            maxElements++;
            int i = maxElements-1;
            elements = Arrays.copyOf(elements,maxElements);

            elements[i] = element;

            while(i > 0 && elements[parent(i)].key > elements[i].key){
                Element temp = elements[parent(i)];
                elements[parent(i)] = elements[i];
                elements[i] = temp;
                i = parent(i);
            }
        }

        private void minHeapify(int i){
            int left = left(i);
            int right = right(i);
            int smallest;
            if(left < elements.length && elements[left].key < elements[i].key){
                smallest = left;
            } else {
                smallest = i;
            }
            if(right < elements.length && elements[right].key < elements[smallest].key){
                smallest = right;
            }
            if(smallest != i){
                Element temp = elements[smallest];
                elements[smallest] = elements[i];
                elements[i] = temp;
                minHeapify(smallest);
            }
        }

        private int left(int i){
            return 2*i;
        }

        private int right(int i){
            return 2*i+1;
        }
        private int parent(int i){
            return (i/2);
        }
    }


