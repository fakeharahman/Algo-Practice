#include <iostream>
using namespace std;

void printArray(int arr[], int n){
    for(int i=0; i<n; i++){
        printf("%d ", arr[i]);
    }
}

int* leftRotate(int arr[], int n, int d){
    int *newArr= new int [n];
    int i, j=0, k;
    for(i=d; i<n; i++){
        newArr[j]= arr[i];
        j++;
    }
    j=n-d;
    for(k=0; k<d; k++){
        newArr[j]=arr[k];
        j++;
        // cout<<j<<"\t";
    }
    return newArr;
}

int main() {
    int noOfTests=0, arrSize=0, rotations=0;
    scanf("%d", &noOfTests);
    for(int i=0; i<noOfTests; i++){
        cin>>arrSize>>rotations;
        int *numbers= new int [arrSize];
        for(int j=0; j<arrSize; j++){
            cin>>numbers[j];
        }
            numbers=leftRotate(numbers, arrSize, rotations);
            printArray(numbers, arrSize);
            free(numbers);
            cout<<"\n";
        
    }
    
	return 0;
}