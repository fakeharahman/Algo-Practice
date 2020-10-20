#include <iostream>
using namespace std;


int binarySearch(int arr[], int f, int l, int x){
    if(f<=l){
        int mid =(f+l)/2;
    if(x==arr[mid]){
        return mid;
    }
    else if(x>arr[mid]){
        return binarySearch(arr, mid+1, l, x);
    }
    else if(x<arr[mid]){
        return binarySearch(arr, f, mid-1, x);
    } 
    }
    return -1;
   
}

int main() {
	//code
	int t=1, n, k, i, r=-1;
	// cin>>t;
	while(t){
	    // cin>>n;
	    // int arr[n];
	    // for(i=0; i<n; i++){
	    //     cin>>arr[i];
	    //     if(i!=0 && arr[i]<arr[i-1]){
	    //       r=i-1;  
	    //     }
	    // }
	    // cin>>k;
        int* arr= new int [10];
        for(i=0; i<10; i++){
            arr[i]=i+1;
        }
        n=10;
    r=-1;
    k=17897;
	int index=binarySearch(arr, 0, n-1, k);
	cout<<index;
	//     i=0;
    //     if(r==-1){
	//         r=n;
	//     }
	// int index;
	//    if(arr[0]<=k){
	//     index=binarySearch(arr, 0, r, k);
	//     cout<<index<<"\n";
	//    }else{ 
	//    // if(index!=-1){
	//    //     cout<<index<<"\n";
	//    // }
	//    // else{
	//         index=binarySearch(arr, r+1, n, k);
	//         cout<<index<<"\n";
	//    // }
	    
	// }
	    t--;
	free(arr);
	}
	
	return 0;
}