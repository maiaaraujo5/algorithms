public class TimeConversion {
    public static void main(String[] args) {
        String date = timeConversion("12:05:45PM");
        System.out.println(date);
    }

    public static String timeConversion(String s) {
        String trateDate = s.replaceAll("PM","").replaceAll("AM", "");
        String[] splitDate = trateDate.split(":");
        int hour = Integer.parseInt(splitDate[0]);
        int minute = Integer.parseInt(splitDate[1]);
        int seconds = Integer.parseInt(splitDate[2]);

        if (s.contains("PM") && hour < 12) {
            hour += 12;
        } else if (hour == 12 && s.contains("AM")) {
            hour = 0;
        }

        return String.format("%02d:%02d:%02d", hour, minute, seconds);
    }
}
