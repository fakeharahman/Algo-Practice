// package dp;

// public class supersequenceWr {
//     static String s1 = "abcd";
//     static String s2 = "cdefg";

//     String rec(char[] x, char[] y, int n, int m, String str) {
//         if (n - 1 == 0) {
//             String t="";
//             for (int i = 0; i < m; i++) {
//                 t+=y[i];
//             }
//             return t+s1;
//         }
//         if (m - 1 == 0) {
//             String t="";
//             for (int i = 0; i < n; i++) {
//                 t+=x[i];
//             }
//             System.out.println(t+s2);
//             return t+s2;
//         }
//         // if(n==0||m==0){
//         // return str;
//         // }
//         if (x[n - 1] == y[m - 1]) {
//             return rec(x, y, n - 1, m - 1, str + x[n - 1]);
//             // return str;
//         }

//         if (rec(x, y, n - 1, m, "").length() < rec(x, y, n, m - 1, "").length()) {
//             return rec(x, y, n - 1, m, "");
//         } else {
//             return rec(x, y, n, m - 1, "");
//         }
//         // return Math.min(rec(x, y, n-1, m, "").length(), rec(x, y, n, m-1,
//         // "").length());

//     }

//     public static void main(String[] args) {
//         // String s1 = "geek";
//         // String s2 = "ege";

//         char[] x = s1.toCharArray();
//         char[] y = s2.toCharArray();
//         int n = x.length;
//         int m = y.length;
//         System.out.println(new supersequenceWr().rec(x, y, n, m, ""));
//     }
// }
