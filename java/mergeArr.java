public class mergeArr {
   public static void main(String[] args) {
       int[] mn={2,0,7,0,0,0,9,10,0, 0};
       int[] n={5,8,12,14, 19, 21};
       int j=0, k=0;
       int  i=j+1;
    //    if(mn[0]>n[0]){

    //    }
       while(i<mn.length&&j<mn.length){
           while(mn[j]!=0&&j+1<mn.length){j++;}
           if(j>=i)
           while(mn[i]==0&&i+1<mn.length){i++;}
           else{i--;}
           mn[j]=n[k++];
           if(mn[j]>mn[i]){
               int temp=mn[j];
               mn[j]=mn[i];
               mn[i]=temp;
           }
           j++;
           i++;
       }
       for(i=0; i<mn.length; i++){
           System.out.print(mn[i]+ " ");
       }
   }
}
