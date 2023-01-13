#include<iostream>
using namespace std;

int main(){
    int N, K;
    cin>>N>>K;

    int arr[N];
    for(int i=0; i<N; i++){
        cin>>arr[i];
    }

    int cnt=0;
    for(int i=N-1; i>=0; i--){
        if(K==0){
            break;
        }
        if(arr[i] > K){
            continue;
        }
        else{
            while(arr[i] <= K){
                K -= arr[i];
                cnt++;
            }
        }
    }

    cout<<cnt;
    return 0;
}