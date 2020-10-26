public class shares {
    public static int maxProfit(int[] a) {
        int p1=0, p2=0, buyAt=0, sellAt=0, i;
        for( i=0; i<a.length-1; i++){
            if(a[i]<a[i+1]&& buyAt==0){
                buyAt=a[i];
                System.out.println("Buy at : "+ buyAt);
            }
            else if(a[i]>a[i+1]&&buyAt!=0){
                sellAt=a[i];
                int p=sellAt-buyAt;
                System.out.println(p+ " "+sellAt+ " "+ buyAt);
                buyAt=0;
                if(p>p1&&p2!=0){
                    p1=p;
                }else if(p>p2){
                    p2=p;
                }
            }
        }
        if(buyAt!=0&&a[i]>a[i-1]){
            sellAt=a[i];
            int p=sellAt-buyAt;
            System.out.println(p+ " "+sellAt+ " "+ buyAt);
            if(p>p1){
                p1=p;
            }else if(p>p2){
                p2=p;
            }
        }
        System.out.println("p1 "+ (p1)+" p2 "+ p2);
        return p1+p2;
    }
    public static void main(String[] args) {
        int price[] = {10, 22, 5, 75, 65, 80};
        System.out.println(maxProfit(price));
    }
    
}
