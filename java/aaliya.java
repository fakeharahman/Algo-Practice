public class aaliya {
    public static void main(String[] args) {
        aa("m0y i2s coun1try thi3s");
    }

    static void aa(String s) {
        String[] a = s.split(" ");
        String[] k = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            String at = "";
            for (int j = 0; j < a[i].length(); j++) {
                if (Character.isDigit(a[i].charAt(j))) {
                    at += a[i].charAt(j);
                }
            }
            k[Integer.parseInt(at)] = a[i];
        }
        String ans = "";
        for (int i = 0; i < a.length; i++) {
            ans = ans + k[i] + " ";
        }
        System.out.println(ans);
    }
}
