#include <string>
#include <vector>

using namespace std;

int solution(int a, int b, int n) {
    int answer = 0;
    while(n>=a){
        int new_bottle = (n/a) * b;
        answer += new_bottle;
        n = new_bottle + n%a;
    }
    return answer;
}