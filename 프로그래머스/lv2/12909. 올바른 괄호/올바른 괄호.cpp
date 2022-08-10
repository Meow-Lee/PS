#include<string>
#include<iostream>
#include<stack>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    stack<char> S;
    
    for(auto c:s){
        if(c=='('){
            S.push(c);
        }
        else if(c==')'){
            if(S.empty() || S.top()!='('){
                answer=false;
                break;
            }
            else{
                S.pop();
            }
        }
    }
    if(!S.empty()){
        answer=false;
    }
    

    return answer;
}