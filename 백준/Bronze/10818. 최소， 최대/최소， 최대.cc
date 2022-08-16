#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int n;
    cin>>n;

    int max=INT_MIN, min=INT_MAX;
    int arr[n];
    for(int i=0; i<n; i++){
        cin>>arr[i];
    }

    for(auto t : arr){
        if(t<min){
            min = t;
        }
        if(t>max){
            max = t;
        }
    }
    cout<<min<<' '<<max;
}