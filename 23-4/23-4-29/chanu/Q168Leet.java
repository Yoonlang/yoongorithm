public class Q168Leet {
    public static void main(String[] args) {

        System.out.println(convertToTitle(701));

    }

    public static String convertToTitle(int columnNumber) {
        if (columnNumber < 27) {
            return String.valueOf((char)(columnNumber + 'A' -1));
        }

        StringBuilder sd = new StringBuilder();
        columnNumber += 1;

        while(columnNumber > 0) {
            sd.append(getChar(columnNumber%26));
            columnNumber /= 26;
        }
        return sd.reverse().toString();
    }

    static String getChar(int n) {
        return String.valueOf((char)(n + 'A' -1));
    }
}
