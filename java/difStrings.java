import java.util.HashMap;
import java.util.Map;

public class difStrings {
    public static void main(String[] args) {
        String s="sstkk";
        HashMap<Character, Integer> h=new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            char k=s.charAt(i);
            if(h.get(k)==null){
                h.put(k, 1);
            }else{
                int t=h.get(k);
                h.put(k, t+1);
            }
        }
        int ans=0;
        for(int i=s.length()-1; i>=0; i--){
            char k=s.charAt(i);
            int amt=h.get(k);
            ans=ans+i-amt+1;
            h.put(k, amt-1);
        }
        System.out.println(ans+1);
    }
}
