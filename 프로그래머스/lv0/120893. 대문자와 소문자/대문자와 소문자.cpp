#include <string>
#include <vector>

using namespace std;

string solution(string my_string) {
    string answer = "";
    
    for(auto ch:my_string){
        if(islower(ch)){
            answer += toupper(ch);
        }
        else{
            answer += tolower(ch);
        }
    }
    return answer;
}