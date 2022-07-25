#include<iostream>
#include<vector>
using namespace std;

int M,N;

void TakePrime(vector<int> &arr){
    arr[0]=0, arr[1]=0;
    for(int i=2; i<=N; i++){
        arr[i] = i;
    }

    for(int i=2; i<=N; i++){
        if(arr[i]==0){
            continue;
        }
        for(int j=i+i; j<=N; j+=i){
            arr[j] = 0;
        }
    }

    for(int i=M; i<=N; i++){
        if(arr[i]!=0){
            cout<<arr[i]<<'\n';
        }
    }
}

int main(){
    cin>>M>>N;
    vector<int> arr(N+1);
    TakePrime(arr);

    return 0;
}