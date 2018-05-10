/**
 * Element implementation.
 * Lavet af Christian Skafte Beck Clausen Chcla15 og Daniel Johansen Dajoh16
 */
public class Element<T> {
    public int key;
    public T data;

    public Element(int freq, T data) {
        this.key = freq;
        this.data = data;
    }
}
