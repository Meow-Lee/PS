#include<bits/stdc++.h>
using namespace std;

int arr[500005];

int lower_func(int target, int len){
    int st = 0;
    int en = len;

    while(st < en){
        int mid = (st+en)/2;

        if(arr[mid] >= target){
            en = mid;
        }
        else{
            st = mid + 1;
        }
    }
    return st;
}

int upper_func(int target, int len){
    int st = 0;
    int en = len;

    while(st < en){
        int mid = (st+en)/2;

        if(arr[mid] > target){
            en = mid;
        }
        else{
            st = mid + 1;
        }
    }
    return st;
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int n;
    cin>>n;

    for(int i=0; i<n; i++){
        cin>>arr[i];
    }
    sort(arr, arr+n);

    int m;
    cin>>m;

    while(m--){
        int t;
        cin>>t;

        int a = lower_func(t, n);
        int b = upper_func(t, n);

        cout<<b-a<<' ';
    }
}