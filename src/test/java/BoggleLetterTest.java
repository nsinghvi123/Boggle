import com.boggle.BoggleLetter;

public class BoggleLetterTest {

    public static void main(String[] args) {
        BoggleLetter boggleLetter = new BoggleLetter(0, 2, 't');
        char[][] board = {
                {'d', 'h', 't', 'm', 'e'},
                {'o', '\0', 'o', '\0', 'l'},
                {'\0', 'g', 'b', 'a', 'c'},
                {'r', '\0', 'e', '\0', 'r'},
                {'e', 't', 'h', 'n', 'p'},
        };
        System.out.println(boggleLetter.adjacentLetters(board));

    }
}
