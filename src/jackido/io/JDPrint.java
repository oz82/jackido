package jackido.io;

public class JDPrint {
    public static void printNS(int n, String s) {
        for (int i = 0; i < n; i++) {
            System.out.print(s);
        }
        System.out.print("\n");
    }

    public static void printPlus(int cc, int quanta) {
        if (cc / quanta <= 100 && cc % quanta == 0) {
            System.out.print("+");
        }
    }

    public static boolean printPlus(long cc, long quanta, int p) {
        int x = (int) (cc / quanta);
        if (x >= p + 1) {
            System.out.print("+");
            return true;
        }
        return false;
    }

    public static String getDashed(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += "-";
        }
        return result;
    }

    public static String padRight(String s, int n) {
        String ss = "";
        for (int i = 0; i < n - s.length(); i++) {
            ss += " ";
        }
        return s + ss;
        //return String.format("%-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);
    }
}