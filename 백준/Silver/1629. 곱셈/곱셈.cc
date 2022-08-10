#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

long long func1(int a, int b, int c){
    if(b==1){
        return a%c;
    }
    ll val = func1(a, b/2, c);
    val = val*val%c;

    if(b%2==0){
        return val;
    }
    return val*a%c;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int a,b,c;
    cin>>a>>b>>c;

    long long ans = func1(a,b,c);
    cout<<ans;
}