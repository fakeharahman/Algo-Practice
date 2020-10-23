import java.util.*;
import java.lang.*;
import java.io.*;
public class sumSubArr {
 /*package whatever //do not write package name here */



	public static void main (String[] args) {
		//code
	
		
        
        int a[]={1, 2, 3, 7 ,5, 2, 4};
		    int n=a.length;
		    int k=14;
		  
		    int l=0, r=0, sum=a[l];
		    while(r<n&&l<n){
                // System.out.println(l+" "+ r+ " "+ sum);
		        if(sum==k){
		            System.out.println(l+" "+ r);
	                break;
                }
		        if(sum<k){
                    if(r+1>=n) break;
		            r++;
                    sum+=a[r];
                    // System.out.println( " "+ a[3]);
		        }else if(sum>k){
                if(l+1>=n) break;
				sum-=a[l];
		            l++;
		        }
		    }

		
	}
 
}
