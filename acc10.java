import java.util.HashSet;

public class acc10 {
    public static void main(String[] args) {
        String s="Learn more javascript";
        func(s);
    }
    static void func(String s){
        HashSet<Character> h=new HashSet<>();
        String ans="";
        for(int i=0; i<s.length(); i++){
            if(h.contains(s.charAt(i)))continue;
            ans+=s.charAt(i)+"";
            h.add(s.charAt(i));
        }
        System.out.println(ans);
    }
}
