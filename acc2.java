import java.util.Arrays;

public class acc2 {
    public static void main(String[] args) {
        int a[]={12,1,5,9,10,1,11};
        int n=a.length;
        int ans[]=new int[n];
        Arrays.fill(ans, -1);
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(a[j]>a[i]){
                    ans[i]=a[j];
                    break;
                }
            }
        }
        for(int i=0; i<n; i++){
            System.out.println(ans[i]);
        }
    }
}
