import java.util.Scanner;

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
