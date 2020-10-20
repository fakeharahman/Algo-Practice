/*package whatever //do not write package name here */

import java.util.*;
// import java.lang.*;
// import java.io.*;

//how many swaps to get all the numbers equal to or lower than k together

class SlidingWindow {
	public static void main (String[] args) {
		//code
		 Scanner in = new Scanner(System.in);
		int t, n, k;
		t=in.nextInt();
		while(t>0){
		n=in.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n;i++){
		  arr[i]=  in.nextInt();
		}
		k=in.nextInt();
		int count=0;
		for(int i=0; i<n;i++){
		  if(arr[i]<=k){
		      count++;//size of our sliding window
		  }
		}
		int bad=0;
		for(int i=0; i<count; i++){
		    if(arr[i]>k){
		        bad++;
		    }
		}
		int j=count, ans=bad;
		int i=0;
		for(i=0, j=count; j<n; i++,j++){
		    if(arr[j]<=k){
		        bad--;
		    }
		    if(arr[i]<=k){
		        bad++;
		    }
		    
		    ans=Math.min(ans, bad);
		}
		
		System.out.println(ans);
// 		for(int i=0; i<n;i++){
// 		    System.out.print(arr[i]+" ");
// 		}
		    t--;
		}
		in.close();
	}
}
