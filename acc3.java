public class acc3 {
    public static void main(String[] args) {
        String s1="abcd";
        String s2="abcde";
        int k=0;
        for(int i=0; i<s1.length(); i++){
            k^=(int)s1.charAt(i);
        }
        for(int j=0; j<s2.length(); j++){
            k^=(int) s2.charAt(j);
        }
        System.out.println((char)k);
    }
}
