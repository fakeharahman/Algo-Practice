public class inflation {
    public static void main(String[] args) {
        int p=1;
        int n=4;
        int [] a={20100,1,202,202};
        double ans=0.0;
        double sum=a[0];
        for(int i=1;i<n;i++){
            sum+=a[i];
        }

        for(int i=n-1; i>0; i--){
            // sum+=a[i];
            double temp=a[i]/sum;
            System.out.println(a[i]+" "+sum+" "+temp);
            if(temp>p/100.0){
                double x=(100.0*a[i]-p*sum)/p-100.0;
                ans+=x;
                a[i-1]+=x;
                sum+=x;
            }
            sum-=a[i];
           
            
        }
        System.out.println(ans);
    }
}
