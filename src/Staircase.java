public class Staircase {
    public static void main(String[] args) {
        staircase(6);
    }

    public static void staircase(int n) {
        String stair = "#";
        for (int i = 0; i < n; i++) {
            System.out.printf("%"+n+"s\n", stair);
            stair +="#";
        }
    }
}
