import java.util.HashMap;
import java.util.LinkedList;

public class ConcateningArrays {
    public static void main(String[] args) {
        int[][] pieces = new int[][]{
                {98,19},
                {23,99},
                {97,80,56,85,60},
                {33,26},
                {34},
                {30, 66}
        };
        int[] array = new int[]{97,80,56,85,60,33,26,23,99,98,19,34,30,66};
        boolean result = canFormArray(array, pieces);
        System.out.println(result);
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, int[]> mapPieces = new HashMap<>();

        for (int i = 0; i < pieces.length; i++) {
            mapPieces.put(pieces[i][0], pieces[i]);
        }

        int i = 0;
        while (i < arr.length) {
            if (!mapPieces.containsKey(arr[i])) {
                return false;
            }

            if (mapPieces.get(arr[i]).length > 1) {
                int[] piece = mapPieces.get(arr[i]);
                int j = 0;
                while (j < piece.length) {
                    if (piece[j] != arr[i]) {
                        return false;
                    }
                    i++;
                    j++;
                }
            }else{
                i++;
            }
        }
        return true;
    }
}
