import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LuckyNumber {
    public static void main(String[] args) {
        // int d=7;
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t!=0){
        int n=s.nextInt();
        int[] a= new int[n];
        for(int i=0; i<n; i++){
             a[i]=s.nextInt();
        }
        // int[] a={1,1,2,2,3};
        Map<Integer, Integer> m= new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++){
            if(m.get(a[i])==null){
                m.put(a[i], 1);
            }else{
                int x=m.get(a[i]);
                m.put(a[i], x+1);
            }
        }
        int max=Integer.MIN_VALUE;
        for(int x: m.keySet()){
            if(m.get(x)>max){
                max=m.get(x);
            }
        }
        System.out.println(max);
        t--;
    }
    s.close();
}
}
