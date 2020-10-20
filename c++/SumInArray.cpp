#include <iostream>
using namespace std;

int main(){
    int arr[]={4,5,6,7,8,1,2,3};
    int r=4, sum=18, n=8;
    bool ans=false;
    int f=(r+1)%n, l=r;
    while(f!=l&&ans==false){
        int t=arr[f]+arr[l];
            // cout<<t<<" "<<f<<" "<<l<<" ";
        if(t<sum){
            f=(f+1)%n;
            // cout<<"sum"<<"\n";
        }
        if(t>sum){
          l=(l-1)%n;
            // cout<<l<<"\n";

        }
        if(t==sum){
            ans=true;
        }
    }
    cout<<ans;

}