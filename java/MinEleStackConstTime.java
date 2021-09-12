public class MinEleStackConstTime {
    int st[]=new int[100];
    int i=0;
    int minEle=0;
    void push(int e){
        st[i]=e;
        if(i==0){
            minEle=e;
        }else{
            if(st[i]<minEle){
                st[i]=2*e-minEle;
                // System.out.println(st[i]+" "+minEle);
                minEle=e;
            }
        }
        i++;
    }
    int pop(){
        i--;
        if(i<0) return -1;
        // System.out.println(st[i]+" "+minEle);
        if(st[i]<minEle){
            minEle=2*minEle-st[i];
        }
        return st[i];
    }
    public static void main(String[] args) {
        MinEleStackConstTime st=new MinEleStackConstTime();
        st.push(1);
        st.push(2);
        System.out.println(st.minEle);
        st.push(1);
        System.out.println(st.minEle);
        st.pop();
        System.out.println(st.minEle);
    }
}
