#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    
    char board[n][n];
    string str1;
    for(int i=0; i<arr1.size(); i++){
        str1 = "";
        for(int j=n-1; j>=0; j--){
            str1 += to_string(arr1[i]>>j&1);
        }
        for(int k=0; k<n; k++){
            board[i][k] = str1[k];
        }
    }
    
    string str2;
    for(int i=0; i<arr2.size(); i++){
        str2 = "";
        for(int j=n-1; j>=0; j--){
            str2 += to_string(arr2[i]>>j&1);
        }
        for(int k=0; k<n; k++){
            if(board[i][k]=='0' && str2[k]=='1'){
                board[i][k] = str2[k];
            }
        }
    }
    
    for(int i=0; i<n; i++){
        string tmp;
        for(int j=0; j<n; j++){
            if(board[i][j]=='1'){
                tmp += '#';
            }
            else{
                tmp += ' ';
            }
        }
        answer.push_back(tmp);
    }
    return answer;
}