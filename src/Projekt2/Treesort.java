import java.util.Scanner;
/**
 * Treesort implementation
 *
 * Lavet af Christian Skafte Beck Clausen (chcla15) og Daniel Johansen (dajoh16)
 */
public class Treesort {
    /**
     * Treesort program.
     * @param args
     */
    public static void main(String[] args){
        Dict dict = new DictBinTree();
        System.out.println("Java Treesort");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            dict.insert(scanner.nextInt());
        }

        for (int i : dict.orderedTraversal()) {
            System.out.println(i);
        }
    }

}
