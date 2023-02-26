#include <string>
#include <vector>

using namespace std;

long long Combination(int n, int r){
    long long sum=1;
    for(int i=1; i<r+1; i++){
        sum = (sum * n) / i;
        n--;
    }
    return sum;
}

int solution(int balls, int share) {
    long long answer = 0;
    answer = Combination(balls, share);
    return answer;
}