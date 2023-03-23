#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin>>n;

    string str;
    int cnt=0;
    for(int i=0; i<n; i++){
        cin>>str;
        bool isTrue=true;
        bool alpha[26];
        for (int k = 0; k < 26; k++) {
            alpha[k]=false;
        }
        for(int j=0; j<str.length(); j++){
            if(j==0){
                alpha[str[j] - 97] = true;
            } else if (str[j - 1] == str[j]) {
                continue;
            } else if (str[j - 1] != str[j] && !alpha[str[j] - 97]) {
                alpha[str[j] - 97] = true;
            }
            else{
                isTrue=false;
            }
        }
        if (isTrue) {
            cnt++;
        }
    }
    cout<<cnt;
}