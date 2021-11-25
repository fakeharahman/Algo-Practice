public class accolite {
    public static void main(String[] args) {
        int[] arr={0,1,2,3,4,5,6,7,8,9,10};
        int sum=0;
        for(int i=1; i<arr.length; i=i+2){
            // if(i%2!=0){
                sum+=arr[i];
            // }
            // System.out.println(arr[i]);
        }
        System.out.println(sum);
    }
}
