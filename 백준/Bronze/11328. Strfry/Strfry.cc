#include<bits/stdc++.h>
using namespace std;

int N;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin>>N;

    while(N--){
        int arr[26] = {0, };
        string str1, str2;

        cin>>str1>>str2;

        for(auto c : str1){
            arr[c-'a']++;
        }
        for(auto c : str2){
            arr[c-'a']--;
        }

        bool isTrue = true;
        for(int i : arr){
            if(i != 0){
                isTrue=false;
            }
        }

        if(isTrue){
            cout<<"Possible"<<'\n';
        }
        else{
            cout<<"Impossible"<<'\n';
        }
    }
}