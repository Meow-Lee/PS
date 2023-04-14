#include <vector>
#include <set>
#include <iostream>
using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    set<int> s;
    for(int i=0; i<nums.size(); i++){
        s.insert(nums[i]);
    }
    int can_choice = nums.size()/2, ani_num = s.size();
    if(can_choice < ani_num){
        answer = can_choice;
    }
    else{
        answer = ani_num;
    }
    return answer;
}