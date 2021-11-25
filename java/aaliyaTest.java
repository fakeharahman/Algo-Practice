import java.util.*;
public class aaliyaTest {
    static int findLeastNumOfUniqueInts(int[] arr, int k, int[] dp, int t) {
        if(k>arr.length) return 0;
        int i=0;
        int tt=t;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) map.put(n, map.getOrDefault(n, 0) + 1);
        List<Integer> l = new ArrayList<>(map.keySet());
        Collections.sort(l, (a, b) -> map.get(a) - map.get(b));
        int n = map.size(), remove = 0, idx = 0;
        while (k > 0 && idx < n) {
            t-=map.get(l.get(idx++));
            if(t==0){
                dp[i++]=n-remove;
                t=tt;
            }else if(t<0){
                dp[i++]=n-remove+1;
                while((tt+t)<=0){
                    t=tt+t;
                    dp[i++]=n-remove+1;
                }
                t=tt+t;
            }
            k -= map.get(l.get(idx++));
            if (k >= 0) remove++;
        }
        dp[i++]=n-remove;
        return n - remove;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int k=s.nextInt();
        int q=s.nextInt();
        int a[]=new int[n];
        int query[]=new int[q];
        for(int i=0; i<n; i++){
            a[i]=s.nextInt();
        }
        for(int i=0; i<q; i++){
            query[i]=s.nextInt();
        }
        Arrays.sort(query);
        int[] dp=new int[query[q-1]+1];
        if(query[q-1]*k<=n)
        findLeastNumOfUniqueInts(a, query[q-1]*k,dp, k);
        else{
        findLeastNumOfUniqueInts(a, (int)(n/k)*k, dp, k);
        }
        for(int i=0; i<q; i++){
            System.out.println(dp[query[i]]);
            // if(query[i]*k<=n)
            //     System.out.println(findLeastNumOfUniqueInts(a, query[i]*k));
            // else{
            //     System.out.println(findLeastNumOfUniqueInts(a, (int)(n/k)*k));
            // }
        }
    }
}