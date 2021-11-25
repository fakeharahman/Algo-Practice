public class acc09 {
    public static void main(String[] args) {
        int a=3;
        int b=6;
        func(a, b);
       
    }
    static void func(int a, int b){
        b=a+b;
        a=b-a;
        b=b-a;
        System.out.println(a+" "+b);
    }
}
