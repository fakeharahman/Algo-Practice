package QuestionsPrep;

public class heapify {
    public static void main(String[] args) {
        int[] heap={ 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
        int k=(heap.length-1-1)/2;
        for(; k>=0; k--){
            heapifyy(heap, k);
        }
        for(int i=0; i<heap.length; i++){
            System.out.println(heap[i]);
        }
    }
    static void heapifyy(int[] heap, int i){
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<heap.length&&heap[left]>heap[largest]){
            largest=left;
        }
        if(right<heap.length&&heap[right]>heap[largest]){
            largest=right;
        }
        if(i!=largest){
            int temp=heap[largest];
            heap[largest]=heap[i];
            heap[i]=temp;
            heapifyy(heap, largest);
        }
    }
}
