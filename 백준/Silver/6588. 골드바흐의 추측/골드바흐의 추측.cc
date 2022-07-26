#include<iostream>
#define MAX 10000001

using namespace std;
bool prime_arr[MAX];

void make_table(){
    std::ios::sync_with_stdio(0);
    for(int i=2; i<MAX; i++){
        prime_arr[i] = true;
    }

    for(int i=2; i*i <MAX; i++){
        if(prime_arr[i]){
            for(int j=i*i; j<MAX; j+=i){
                prime_arr[j] = false;
            }
        }
    }
}

void printAns(int n){
    bool flag = false;
    int min, max;
    for(int i=2; i<=n; i++){
        int temp = n-i;
        if(prime_arr[i] && prime_arr[temp]){
            flag = true;
            min = i;
            max = temp;
            break;
        }
    }
    if(flag){
        cout<<n<<" = "<<min<<" + "<<max<<'\n';
    }
    else{
        cout<<"Goldbach's conjecture is wrong."<<'\n';
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    make_table();
    while(true){
        int n;
        cin>>n;

        if(n==0){
            break;
        }
        printAns(n);
    }
    return 0;
}