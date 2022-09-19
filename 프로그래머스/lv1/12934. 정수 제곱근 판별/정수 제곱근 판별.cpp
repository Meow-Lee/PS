#include <string>
#include <vector>
#include <cmath>
#include<iostream>
using namespace std;

long long solution(long long n) {
    long long answer = 0;
    
    bool flag = false;
    if(sqrt(n)-(int)sqrt(n) == 0){
        flag = true;
    }
    
    if(sqrt(n)>0 && flag){
        answer = pow(sqrt(n)+1, 2);
    }
    else{
        answer=-1;
    }
    return answer;
}