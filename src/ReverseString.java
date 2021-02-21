public class ReverseString {

    public static void main(String[] args) {
        String result = Reverse("Oi eu sou Lucas");
        System.out.println(result);
    }

    public static String Reverse(String text) {
        char[] array;
        String reversed = "";
        array = text.toCharArray();
        for (int i = array.length - 1; i >= 0; i--) {
            reversed += (array[i]);
        }
        return reversed;
    }

}
