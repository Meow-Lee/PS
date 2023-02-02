#include <string>
#include <vector>

using namespace std;

double solution(vector<int> numbers) {
    double answer = 0;
    int p = 0;
    for(auto cur : numbers){
        p += cur;
    }
    answer = (double)p / numbers.size();
    return answer;
}