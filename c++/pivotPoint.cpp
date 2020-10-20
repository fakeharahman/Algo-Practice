#include <iostream>
using namespace std;

int findKRotation(int arr[], int n) {
	    int l=0, r=n-1;
	    while(l<r){
	        int mid=(l+r)/2;
	        if(mid<r&&arr[mid]>arr[mid+1]){
	            return mid+1;
	        }
	        if(mid>l&&arr[mid]<arr[mid-1]){
	            return mid;
	        }
	        if(arr[l]<=arr[mid]){
	            l=mid-1;
	        }
	        if(arr[l]>=arr[mid]){
	            r=mid;
	        }
	        
	    }
	    return -1;
	    
	    // code here
	}

int main(){

    int arr[]={11,12,13,14,1,2,3,4,5,6,7,8,9,10};
    int n=14;
   cout<<findKRotation(arr, n);
    	
}