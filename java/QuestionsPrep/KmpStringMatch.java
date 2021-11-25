package QuestionsPrep;

public class KmpStringMatch {
    public static void main(String[] args) {
        String p="AAAA";
        String s="AAAAABAAABA";
        int[] lps=computeLps(p);
        for(int i: lps)
        System.out.println(i);
        int i=0;
        int j=0;
        while(i<s.length()){
            if(j==p.length()){
                System.out.println("true "+i);
                j=lps[j-1];
            }
            if(p.charAt(j)==s.charAt(i)){
                i++; j++;
            }
            else{
                if(j==0){
                    i++;
                }else{
                    j=lps[j-1];
                }
            }
        }
    }
    static int[] computeLps(String p){
        int[] lps=new int[p.length()];
        int i=1;
        int len=0;
        int n=p.length();
        while(i<n){
            if(p.charAt(i)==p.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len!=0){
                    len=lps[len-1];
                }
                else{
                    i++;
                }
            }
        }
        return lps;
    }
}
