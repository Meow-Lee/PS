#include <bits/stdc++.h>
using namespace std;

int main(){
    string str;
    getline(cin, str);

    istringstream ss(str);
    string tmp;
    int cnt=0;
    while (getline(ss, tmp, ' ')) {
        if(tmp.empty()){
            continue;
        }
        cnt++;
    }
    cout<<cnt;
}