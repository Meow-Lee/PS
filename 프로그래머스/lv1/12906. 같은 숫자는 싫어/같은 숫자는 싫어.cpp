#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;

    for(auto n : arr){
        if(answer.size()==0){
            answer.push_back(n);
        }
        else{
            if(answer.back()==n){
                continue;
            }
            else{
                answer.push_back(n);
            }
        }
    }

    return answer;
}