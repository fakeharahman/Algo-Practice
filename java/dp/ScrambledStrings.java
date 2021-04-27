package dp;

import java.util.HashMap;
import java.util.Map;

public class ScrambledStrings {
    // boolean ans=false;
    // static boolean rec(char[] a, int i , int j, String s2, String temp){
    // if(j-i==1){
    // // return a[i]+"";
    // // System.out.println();
    // // if(s2.substring(0, 1)==a[i]+""||s2.substring(s2.length()-1)==a[i]+"")
    // return true;
    // // return false;
    // }
    // boolean an=false;
    // for(int k=i+1; k<j-1; k++){
    // System.out.println(" "+s2.substring(a.length-(k-i)));
    // boolean t1=rec(a, i, k, s2.substring(a.length-(k-i)), temp);
    // boolean t2=rec(a, k+1, j, s2.substring(i, a.length-(j-k-1) ), temp);
    // System.out.println(i+" "+ k+ " "+j);
    // boolean t3=rec(a, i, k, s2.substring(i, k),temp);
    // boolean t4=rec(a, k+1, j, s2.substring(k+1), temp);
    // if(t1&&t2){
    // return true;
    // }
    // if(t3&&t4){
    // return true;
    // }
    // }
    // return false;
    // // return an;
    // }

    static boolean str(String a, String b, Map<String, Boolean> dp) {
        if (a.length() != b.length())
            return false;
        int n = a.length();
        if (a.length() == 0) {
            return true;
        }
        if (a.equals(b))
        return true;
        
        if(a.length()<=1){
            return false;
        }
        for (int k = 1; k < n; k++) {
            if(!(dp.containsKey(a.substring(0, k)+" "+ b.substring(n - k, n)))){
                dp.put(a.substring(0, k)+" "+ b.substring(n - k, n), str(a.substring(0, k), b.substring(n - k, n), dp));
            }
            if (str(a.substring(0, k), b.substring(n - k, n), dp)
                    && str(a.substring(k, n), b.substring(0, n - k), dp)) {
                return true;
            }
            if (str(a.substring(0, k), b.substring(0, k), dp) && str(a.substring(k, n), b.substring(k, n), dp)) {
                return true;
            }
        }
        return false;

    }

    static int boolToInt(boolean a) {
        if (a) {
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "abcdefghijklmnopq";
        String s2 = "efghijklmnopqcadb";
        // char[] a =s1.toCharArray();
        int n = s1.length();
        Map<String,Boolean> dp=new HashMap<String,Boolean>();  
        // System.out.println(dp[0][2]);
        // System.out.println(s1.substring(0, 1));
        // System.out.println(rec(a, 0, a.length-1, s2, ""));
        System.out.println(str(s1, s2, dp));
    }
}
