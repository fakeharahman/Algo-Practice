//this is important

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterFreq {
    void nextFreq(int[] a) {
        int[] freq = new int[a.length];
        int[] ans = new int[a.length];
        Stack<Integer> st = new Stack<Integer>();
        HashMap<Integer, Integer> f = new HashMap<Integer, Integer>();
        System.out.println(f.get(0));
        for (int i = 0; i < a.length; i++) {
            if (f.get(a[i]) == null) {
                f.put(a[i], 1);
            } else {
                int x = f.get(a[i]);
                f.put(a[i], x + 1);
            }
        }
        // for (int i : f.keySet()) {
        // System.out.println("key: " + i + " value: " + f.get(i));
        // }
        for (int i = 0; i < a.length; i++) {
            int x = f.get(a[i]);
            freq[i] = x;
            // System.out.println(freq[i]);
        }

        for (int i = a.length - 1; i >= 0; i--) {
            if (st.empty()) {
                ans[i] = -1;
                st.push(i);
                // System.out.println(ans[i]);
            } else {
                // System.out.println(freq[st.peek()] <= freq[i]);
                // System.out.println(freq[i]);
                while (freq[st.peek()] <= freq[i]) {
                    st.pop();
                    if(st.empty()){
                        break;
                    }
                }
                if(st.empty()){
                    ans[i] = -1;
                    st.push(i);
                    // System.out.println(ans[i]);
                    continue;
                }
                
                ans[i]=a[st.peek()];
                st.push(i);
                // System.out.println(ans[i]);
                // System.out.println(st.peek());

            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(ans[i]);
        }
       

    }

    public static void main(String[] args) {
        int[] a = { 1, 1, 2, 3, 4, 2, 1 };
        NextGreaterFreq ngf = new NextGreaterFreq();
        ngf.nextFreq(a);
    }
}
