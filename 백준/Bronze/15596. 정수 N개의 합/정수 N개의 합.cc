#include <vector>
long long sum(std::vector<int> &a) {
	long long ans = 0;
    for(auto t : a){
        ans+=t;
    }
	return ans;
}
