public class twoCitiesLeetCode {
    public static int ans=Integer.MAX_VALUE;
    public static void rec(int[][] a, int cA, int cB, int i, int cur) {
        if(cA+cB==a.length){
            if(cA==cB)
            ans=Math.min(ans, cur);
            return;
        }
        if(cA==a.length/2){
            rec(a, cA, cB+1, i+1, cur+a[i][1]);
            return;
        }
        if(cB==a.length/2){
            rec(a, cA+1, cB, i+1, cur+a[i][0]);
            return;
        }
        rec(a, cA, cB+1, i+1, cur+a[i][1]);
        rec(a, cA+1, cB, i+1, cur+a[i][0]);
        
    }
    public static void main(String[] args) {
        int a[][]={{403,578},{406,455},{710,697},{155,861},{540,843},{911,753},{477,453},{378,936},{492,720},{915,382},{984,200},{449,448},{525,964},{875,767},{905,753},{18,84},{351,167},{554,582},{175,794},{677,301},{268,994},{631,627},{53,107},{995,390},{540,406},{932,808},{426,455},{997,735},{449,757},{90,869},{640,396},{573,536}};
        int cA=a.length/2;
        int cB=a.length/2;
        rec(a, 0, 0, 0, 0);
        System.out.println(ans);
    }
}
