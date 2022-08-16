#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int c,n;
    cin>>c;

    while(c--){
        cin>>n;
        int arr[n], tot=0;
        for(int i=0; i<n; i++){
            cin>>arr[i];
            tot+=arr[i];
        }

        int avg = tot/n, cnt=0;
        for(auto i : arr){
            if(i>avg){
                cnt++;
            }
        }

        cout.precision(3);
        cout<<fixed;
        cout<<(double)cnt/n*100<<"%"<<'\n';
    }
}