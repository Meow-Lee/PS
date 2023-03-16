#include <bits/stdc++.h>

using namespace std;

int main(){
    int k, n;
    cin>>k>>n;
    vector<int> arr;
    long long start=0, end;
    for(int i=0; i<k; i++){
        long long x;
        cin>>x;
        arr.push_back(x);
        end = max(x, end);
    }

    long long result = 0;
    while (start <= end) {
        int total = 0;
        long long mid = (start + end) / 2;
        for(int i=0; i<k; i++){
            total += arr[i] / mid;
        }
        if(total<n) {
            end = mid-1;
        }
        else{
            start = mid+1;
            result = max(result, mid);
        }
    }
    cout<<result;

    return 0;
}
