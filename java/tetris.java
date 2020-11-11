
//Hi Bihariii xD
public class tetris {
    public static void main(String args[]) {
        int a[] = { 0,0,1,1,0,1};
        int n = a.length;
        int x = a[0]; // we keep track of the first element i.e. whether it's a '1' or '0'
        int count = 0;
        for (int i = 0; i < n; i++) {/*
                                      * this is the crucial part where we look for things where the middle part is
                                      * different than the corners and thus increment count i.e. when '1001' OR '010'
                                      * OR '000100' occurs anywhere in the middle
                                      */
            if (i != n - 1) {
                if (a[i] != x) {
                    if (a[i + 1] == x)
                        ++count;
                }
            } else { // special case for the last element
                if (a[n - 1] != x) // if the last element is different than the first one there should be an extra
                                   // count to delete it.
                    ++count;
                ++count; // haan, this one is for set of the last leftover elements that are all
                         // equal,hence +1
            }
        }
        System.out.println(count);
    }

}

