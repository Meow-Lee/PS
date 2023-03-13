#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<string> spell, vector<string> dic) {
    int answer = 2;
    
    string str;
    for(int i=0; i<spell.size(); i++){
        str += spell[i];
    }
    sort(str.begin(), str.end());

    for(auto d : dic){
        if(d.length()!=spell.size()){
            continue;
        }
        sort(d.begin(), d.end());
        if(str == d){
            answer=1;
        }
    }
    
    return answer;
}