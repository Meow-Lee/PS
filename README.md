# PS
Problem Solving(BOJ, Programmers, etc..)

# Note (22-07-25~)
1. GCD(최대공약수), LCM(최소공배수)
- 유클리드 호제법(Euclidean Algorithm) 사용.

2. Prime(소수)
- 에라토스테네스의 체 사용

3. 시간초과 문제 해결
- <ios_base::sync_with_stdio(false);>  
  = C의 stdio와 CPP의 iostream을 동기화 시켜주는 역할, iostream과 stdio의 버퍼를 모두 사용함으로 딜레이 발생  
    -> false로 동기화 비활성화  
    -> CPP만의 독립적인 버퍼가 생성되어 실행속도 UP  
    -> PS는 대부분 Single Thread 환경이라 해당 코드를 추가해줘도 괜찮음(대부분)  
    
- <cin.tie(NULL);> , <cout.tie(NULL);>
  = 읽고 출력할 때 버퍼를 비워줌
