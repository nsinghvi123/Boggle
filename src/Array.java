import java.util.ArrayList;
import java.util.List;

public class Array {
    public static void main(String[] args) {
        try {
            List<Integer> myList = new ArrayList<>(3);
            myList.add(1);
            myList.add(2);
            myList.add(3);
            System.out.print(myList.get(3));
        } catch (RuntimeException e) {
            System.out.println(e);
            e.printStackTrace();
        }

        System.out.println("NATASHA IS A POOPY");
    }
}
