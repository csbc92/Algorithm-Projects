import java.util.ArrayList;

/**
 * Created by danie on 02-03-2018.
 */
public class PQHeap3 implements PQ {

    private ArrayList<Element> elementList;
    private int maxElements;

    public PQHeap3(int maxElements){
        elementList = new ArrayList<>();
        this.maxElements = maxElements;

    }

    @Override
    public Element extractMin() {
       Element min = elementList.get(0);
       elementList.add(0,elementList.get(elementList.size()-1));
       maxElements--;
       minHeapify(0);
       return min;
    }

    @Override
    public void insert(Element element) {
        maxElements++;
        int i = maxElements;
        elementList.add(i,element);
        while(i > 0 && elementList.get(parent(i)).key > elementList.get(i).key){
            Element temp = elementList.get(parent(i));
            elementList.add(parent(i),elementList.get(i));
            elementList.add(i,temp);
            i = parent(i);
        }
    }

    private void minHeapify(int i){
        int left = left(i);
        int right = right(i);
        int smallest;
        if(left < elementList.size() && elementList.get(left).key < elementList.get(i).key){
            smallest = left;
        } else {
            smallest = i;
        }
        if(right < elementList.size() && elementList.get(right).key < elementList.get(smallest).key){
            smallest = right;
        }
        if(smallest != i){
            Element temp = elementList.get(smallest);
            elementList.add(smallest,elementList.get(i));
            elementList.add(i,temp);
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
