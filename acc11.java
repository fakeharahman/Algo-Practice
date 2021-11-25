public class acc11 {
    public static void main(String[] args) {
        func("hello", "rti");
    }
    static void func(String a, String b){
        //check if b is substring of a
        if(a.length()==0||b.length()==0){
            System.out.println("String is empty");
        }
        if(a.length()<b.length()){
            System.out.println("No");
        }
        for(int i=0; i<a.length(); i++){
            if((a.length()-i)<b.length()){
                System.out.println("No"); break;
            }
            if(a.substring(i, b.length()+i).equals(b)) {
                System.out.println("Yes");
                break;
            }
        }
    }
}
