import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class accedentalVictory {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t!=0){
            int n=s.nextInt();
            int[] a = new int[n];
            // int ans=0;
            int[] arr=new int[n];
            for(int i=0; i<n; i++){
                a[i]=s.nextInt();
                arr[i]=a[i];
            }
            Arrays.sort(arr);
            Map<Integer, Boolean> m=new HashMap<Integer, Boolean>();
            // boolean bool[]=new boolean[n];
            int sum=arr[0];
            int ans=1;
            m.put(arr[n-1], true);
            // bool[n-1]=true;
            if(arr.length>1){
                if(arr[0]==arr[1]){
                    ans++;
                }
            }
            for(int i=1; i<n-1; i++){
                if(arr[i]+sum>=arr[i+1]){
                    ans++;
                    m.put(arr[i], true);
                }
                sum+=arr[i];

            }
            System.out.println(ans);
            for(int i=0; i<n; i++){
                if(m.get(a[i])!=null){
                    System.out.println(i+1);
                }
            }

            t--;
        }
        s.close();
    }
}
