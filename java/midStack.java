public class midStack {
    class Node {
        Node next;
        Node prev;
        int data;

        Node(int d) {
            data = d;
        }
    }

   public static class Stack {
        Node head;
        Node mid;
        int count;
    }

    void push(Stack st, int d) {
        Node temp = new Node(d);
        temp.prev = null;
        st.count++;
        if (st.count == 1) {
            temp.next=null;
            st.mid = temp;
        } else {
            temp.next = st.head;
            st.head.prev=temp;
            if((st.count % 2) != 0)
            st.mid=st.mid.prev; 
        }
        st.head = temp;
    }
    int pop(Stack st){
    
        if(st.count ==0){
            return -1;
        }
        int val=st.head.data;
        st.count--;
        if(st.count==0){
            st.head=null;
        }else{
            st.head=st.head.next;
        }
        if((st.count%2)==0){
            st.mid=st.mid.next;
        }
        return val;
    }
    int findMiddle(Stack ms) 
    { 
        if(ms.count == 0) 
        { 
            System.out.println("Stack is empty now"); 
            return -1; 
        } 
        return ms.mid.data; 
    } 

    public static void main(String args[]) 
    { 
        midStack ob = new midStack(); 
        Stack ms=new Stack();
        ms.count=0;
        ob.push(ms, 11); 
        ob.push(ms, 22); 
        ob.push(ms, 33); 
        ob.push(ms, 44); 
        ob.push(ms, 55); 
        ob.push(ms, 66); 
        ob.push(ms, 77); 
          
        System.out.println("Item popped is " + ob.pop(ms)); 
        System.out.println("Item popped is " + ob.pop(ms)); 
        System.out.println("Middle Element is " + ob.findMiddle(ms)); 
    } 
}
