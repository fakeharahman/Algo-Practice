public class celeb {
    int findCeleb(int[][] a){
        int zeroI=-1;
        for(int i=0; i<a.length; i++){
            if(a[0][i]==1){
                for(int j=1; j<a.length; j++){
                    if(a[j][i]==0&&zeroI!=-1){
                        zeroI=-1;
                        break;
                    }else if(a[j][i]==0){
                        zeroI=j;
                    }
                }
                boolean t=false;
                if(zeroI!=-1){
                    for(int k=0; k<a.length; k++){
                        if(a[zeroI][k]==1){
                            t=true;
                            break;
                        }
                    }
                    if(t==false){
                        return zeroI;
                    }
                }

            }
        }
        return -1;
    }
   public static void main(String[] args) {
       int a[][]={{0, 0, 1, 1,1}, 
       {1, 0, 0,0, 0}, 
       {1, 0, 0,1, 0}, 
       {0, 0, 0,0, 0},
       {0,1,0,1,0}}; 
       celeb c=new celeb();
       int t=c.findCeleb(a);
       System.out.println(t);
   } 
}
