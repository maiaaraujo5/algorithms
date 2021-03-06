import javax.xml.stream.events.Characters;
import java.util.HashSet;

public class SudokuValidate {
    public static void main(String[] args) {
        char[][] grid = new char[9][9];
    }

    public static boolean sudokuValidate(char[][] grid) {
        HashSet<String> characters = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current_value = grid[i][j];
                if (current_value != '.') {
                    if (!characters.add(current_value + " found in row" + i) ||
                            !characters.add(current_value + " found in column" + j) ||
                            !characters.add(current_value + " found in sub box" + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
