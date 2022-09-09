#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    int people = stages.size();
    vector<pair<int, double>> v;
    
    for(int i=1; i<=N; i++){
        int count = 0;
        for(auto t : stages){
            if(i == t){
                count++;
            }
        }
        v.push_back({i, (double)count/people});
        people-=count;
    }
    
    stable_sort(v.begin(), v.end(), [](auto &a, auto &b) {return a.second > b.second;});
    
    for(auto t:v){
        answer.push_back(t.first);
    }
    return answer;
}