#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int N;
    cin>>N;

    stack<pair<int, int>> S;
    S.push({100000001, 0});

    for(int i=1; i<=N; i++){
        int t;
        cin>>t;

        while(S.top().first < t){
            S.pop();
        }
        cout<<S.top().second<<" ";
        S.push({t, i});
    }
}