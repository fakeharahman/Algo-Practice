// package codeforces;

import java.util.Scanner;

public class boulder {
    static int sol(int arr[], int n, int k){
        int ans=0;
        for(int i=0; i<n; i++){
            if(k==0){
                return ans;
            }
            if(i==n-1){
                return -1;
            }
            if(arr[i]<arr[i+1]){
                while(arr[i]<arr[i+1]&&k!=0){
                    arr[i]+=1;
                    ans=i;
                    k--;
                    if(k==0){
                        return ans;
                    }
                    if(i==n-1){
                        return -1;
                    }
                }
                i=0;
            }
        }


        return ans;
    }

    static int sol2(int[] a, int n, int k){
        int ans=0;
        while(k>0){
            k--;
            int i=0;
            while(i<n-1){
                if(a[i]<a[i+1]){
                    a[i]++;
                    break;
                }
                i++;
            }
            if(i==n-1){
                return -1;
            }else{
                ans=i;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t!=0){
        int n=s.nextInt();
        int k=s.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=s.nextInt();
        }
        // int[] arr= {1,8};
        // int n=2;
        // int k=7;
        int x=(sol2(arr, n, k));
        if(x==-1){
            System.out.println(x);
        }else{
            System.out.println(x+1);
        }
    t--;}
    s.close();
    }
        
       
    }

