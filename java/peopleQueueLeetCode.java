import java.util.Arrays;

public class peopleQueueLeetCode {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new java.util.Comparator<int[]>() {
    @Override
    public int compare(int[] s1, int[] s2) {
       if(s1[0]>s2[0]) return 1;
       if(s1[0]<s2[0]) return -1;
        if(s1[0]==s2[0]){
            return s2[1]-s1[1];
        }
        return 0;  
    }
});

int[][] ans=new int[people.length][2];
for(int i=0; i<people.length; i++){
    for(int j=0; j<people[0].length; j++){
        ans[i][j]=-1;
    }
}


        for(int i=0; i<people.length; i++){
            int pos=people[i][1];
            int k=0;
            System.out.println(pos);
            while((pos!=0)){
                if(Arrays.equals(ans[k], new int[]{-1,-1})) pos--;
                k=k+1;
            }
            while(!Arrays.equals(ans[k], new int[]{-1,-1})){
                k++;
            }
            ans[k]=people[i];
        }
        for(int i=0; i<people.length; i++){
            for(int j=0; j<people[0].length; j++){
                // System.out.println(ans[i][j]);
            }
            // System.out.println(Arrays.equals(ans[0], new int[]{0,0}));
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] v={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(v);
    }
}
