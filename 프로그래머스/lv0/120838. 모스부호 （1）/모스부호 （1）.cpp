#include <string>
#include <vector>
#include <unordered_map>
#include <sstream>
using namespace std;

string solution(string letter) {
    string answer = "";
    
    unordered_map<string, string> m = { {".-","a"},{"-...","b"},{"-.-.","c"},{"-..","d"},{".","e"},{"..-.","f"},{"--.","g"},{"....","h"},{"..","i"},{".---","j"},{"-.-","k"},{".-..","l"},{"--","m"},{"-.","n"},{"---","o"},{".--.","p"},{"--.-","q"},{".-.","r"},{"...","s"},{"-","t"},{"..-","u"},{"...-","v"},{".--","w"},{"-..-","x"},{"-.--","y"},{"--..","z"}};

    stringstream str(letter);
    while(str >> letter){
        answer += m[letter];
    }

    return answer;
}