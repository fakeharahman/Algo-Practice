import java.util.Scanner;

public class ShiftingStacks {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
    
            while (t > 0) {
                --t;
                int n = sc.nextInt();
                boolean checker = true;
                double[] h = new double[n];
                double extra = 0;
                for (int i = 0; i < n; i++) {
                    h[i] = sc.nextInt();
                }
    
                for (int i = 0; i < n; i++) {
                    if (h[i] >= i) {
                        extra = extra + (h[i] - i);
                    } else {
                        if ((extra + h[i]) >= i) {
                            extra = extra - (i - h[i]);
                        } else {
                            checker = false;
                            break;
                        }
                    }
                }
                if (checker == true) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
    
            }
        }
}
