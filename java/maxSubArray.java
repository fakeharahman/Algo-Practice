public class maxSubArray {

    public static int algo(int[] a) {
        int maxSoFar=-100000, maxHere=0;
        for(int i=0; i<a.length;i++){
            maxHere+=a[i];
            maxSoFar=Math.max(maxHere, maxSoFar);
                if(maxHere<0){
                    maxHere=0;
                }
        }

        return maxSoFar;

        
    }
    public static void main(String[] args) {
        
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3}; 
        System.out.println("Maximum contiguous sum is " + 
                                       algo(a)); 
    }
}
