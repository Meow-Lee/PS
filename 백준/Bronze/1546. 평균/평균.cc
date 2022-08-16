#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int n, m=INT_MIN;
    cin>>n;

    int arr[n];
    for(int i=0; i<n; i++){
        cin>>arr[i];

        if(arr[i]>m){
            m=arr[i];
        }
    }

    double sum=0;
    for(int i=0; i<n; i++){
        sum+=(double)arr[i]/m*100;
    }
    cout<<sum/n;
}