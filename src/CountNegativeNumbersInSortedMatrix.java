public class CountNegativeNumbersInSortedMatrix {
    public static void main(String[] args) {
//        int[][] grid = new int[][]{
//                {4,3,2,-1},
//                {3,2,1,-1},
//                {1,1,-1,-2},
//                {-1,-1,-2,-3}
//        };

        int[][] grid = new int[][]{
                {1, -1},
                {-1, -1},
        };

        int result = search(grid);
        System.out.println(result);
    }

    public static int search(int[][] grid) {
        int gridLength = grid.length;
        int countNegatives = 0;
        int position = -1;
        int end;

        for (int i = 0; i < gridLength; i++) {
            int start = 0;
            end = grid[i].length - 1;

            if (grid[i][0] < 0) {
                countNegatives += grid[i].length;
                continue;
            }

            while (start <= end) {
                int mid = (start + end) / 2;

                if (grid[i][mid] < 0) {
                    position = mid;
                    break;
                } else {
                    start = mid + 1;
                }
            }
            if (position != -1) {
                countNegatives += grid[i].length - position;
            }
        }

        return countNegatives;
    }
}
