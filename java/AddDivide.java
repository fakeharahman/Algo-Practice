import java.util.Scanner;

public class AddDivide {

    
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int q=s.nextInt();
        int k=s.nextInt();
        int a[] = new int[n];
        for(int i=0; i<n; i++){
            a[i]=s.nextInt();
        }
        while(q!=0){
            int l=s.nextInt();
            int r=s.nextInt();
            int al=a[l-1];
            int ar=a[r-1];
            int lans=0;
            if(k<al){
                lans=0;
            }else{
                lans=k-al-1;
                
            }
            int rans=0;
            if(ar>k){
                rans=0;
            }else{
                rans=ar-2;
            }
            System.out.println("ans "+rans+" "+lans);
            System.out.println(rans+lans);
            q--;
        }


        // sort(mp, mh, 0, n-1);
    
    s.close();
}
}
