package Projekt3;

public class Element<T> {
    public int key;
    public T data;

    public Element(int freq, T data) {
        this.key = freq;
        this.data = data;
    }
}
