#include<iostream>
using namespace std;

int GCD_MAX(int a, int b){
    while(b!=0){
        int c = a % b;
        a = b;
        b = c;
    }
    return a;
}

int main(){
    int a,b;
    cin>>a>>b;
    int gcd = GCD_MAX(a,b);
    int lcm = a * b / gcd;
    
    cout<<gcd<<'\n'<<lcm;
}