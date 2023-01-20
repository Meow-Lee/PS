#include <string>
#include <vector>

using namespace std;

int solution(string t, string p) {
    int answer = 0;
    
    for(int i=0; i<=t.size()-p.size(); i++){
        long t_num = stol(t.substr(i, p.size()));
        long p_num = stol(p);
        if(t_num<=p_num){
            answer++;
        }
    }
    return answer;
}