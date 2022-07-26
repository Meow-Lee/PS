#include<iostream>
#define MAX 1000001
using namespace std;

int arr[MAX];
long long sum[MAX];

void table(){
    for(int i=1; i<MAX; i++){
        for(int j=1; i*j<MAX; j++){
            arr[i*j] += i;
        }
    }

    sum[1] = arr[1];
    for(int i=2; i<MAX; i++){
        sum[i] = sum[i-1] + arr[i];
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T, n;
    cin>>T;

    table();

    for(int i=0; i<T; i++){
        cin>>n;
        cout<<sum[n]<<'\n';
    }

    return 0;
}