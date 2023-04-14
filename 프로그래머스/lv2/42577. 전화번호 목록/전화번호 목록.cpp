#include <string>
#include <vector>
#include <map>
using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    map<string, int> m;
    for(int i=0; i<phone_book.size(); i++){
        m[phone_book[i]]=1;
    }
    
    for(int i=0; i<phone_book.size(); i++){
        for(int j=0; j<phone_book[i].size()-1; j++){
            string phone_number = phone_book[i].substr(0, j+1);
            if(m[phone_number]){
                return false;
            }
        }
    }
    return answer;
}