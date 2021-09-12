public class findTriplet {
    public static void main(String[] args) {
        int arr[] = { 3, 2, 4, 6, 5 };
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            max=Math.max(max, arr[i]);
        }
        int[] hash=new int[max+1];
        for(int i=0; i<n; i++){
            hash[arr[i]]++;
        }
        for(int i=1; i<max+1; i++){
            if(hash[i]==0) continue;
            for(int j=i; j<max+1; j++){
                if(hash[j]==0) continue;
                if(j==i&&hash[i]==1){
                    continue;
                }
                int k=(i*i)+j*j;
                k=(int)Math.sqrt(k);
                if(k!=Math.sqrt((i*i)+j*j)){
                    continue;
                }
                System.out.println(k);
                if(k>max) continue;
                if(hash[k]>=1){
                    System.out.println("ans="+k);
                    break;
                }
            }
        }
    }
}
