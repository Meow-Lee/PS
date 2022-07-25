#include<iostream>
using namespace std;

bool isPrime(int n){
    if(n<2){
        return false;
    }
    for(int i=2; i<n; i++){
        if(n%i==0){
            return false;
        }
    }
    return true;
}

int main(){
    int n;
    cin>>n;

    int sum=0;
    for(int i=0; i<n; i++){
        int k;
        cin>>k;
        if(isPrime(k)){
            sum+=1;
        }
    }
    cout<<sum;
    
    return 0;
}