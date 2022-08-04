#include<bits/stdc++.h>
using namespace std;

int freq1[26], freq2[26], cnt;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    string s1, s2;
    cin>>s1>>s2;

    for(char c : s1){
        freq1[c-'a']++;
    }
    for(char c : s2){
        freq2[c-'a']++;
    }

    for(int i=0; i<26; i++){
        cnt+=abs(freq1[i] - freq2[i]);
    }
    cout<<cnt;
}