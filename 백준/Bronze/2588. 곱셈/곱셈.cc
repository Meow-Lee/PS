#include<bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int a,b;
    cin>>a>>b;

    int temp=b;

    int num1=temp%10;
    cout<<a*num1<<'\n';
    temp/=10;

    int num2=temp%10;
    cout<<a*num2<<'\n';
    temp/=10;

    int num3=temp%10;
    cout<<a*num3<<'\n';

    cout<<a*b;
}