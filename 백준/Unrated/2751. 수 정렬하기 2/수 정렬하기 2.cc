#include <bits/stdc++.h>

using namespace std;

int main(){
    int n;
    cin>>n;

    vector<int> v;
    for(int i=0; i<n; i++){
        int tmp;
        cin>>tmp;
        v.push_back(tmp);
    }
    sort(v.begin(), v.end());
    for (int i = 0; i < n; i++) {
        cout << v[i]<<'\n';
    }

    return 0;
}
