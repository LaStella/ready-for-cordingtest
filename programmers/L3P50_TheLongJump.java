// 멀리 뛰기
// https://programmers.co.kr/learn/courses/30/lessons/12914?language=java#

// 핵심 : 동적프로그래밍(DP), 모듈러 산술(Modular Arithmetic)(나머지연산 성질)

class Solution {
    public long solution(int n) {
        long answer = 0;
        
        // d[i]는 i칸을 뛰는 방법의 수를 말합니다.
        // 1칸을 뛰는 방법의 수는 1가지뿐이며, 2칸을 뛰는 방법의 수는 2가지 이므로 d[1] = 1, d[2] = 2가 됩니다.
        // 배열 범위를 벗어나는 것을 방지하기위해 배열의 크기는 n+2로 합니다. (n은 1이상 이므로, n = 1 이어도 d[2]에 접근할 수 있습니다.)
        long[] d = new long[n+2];
        
        d[1] = 1;
        d[2] = 2;
        
        // i칸을 뛰는 방법의 수 = 1칸을 뛰고 나머지칸을 뛰는 방법의 수 + 2칸을 뛰고 나머지칸을 뛰는 방법의 수
        // d[i] = d[i-1] + d[i-2]
        // (A+B) % C = (A%C+B%C)%C 의 나머지연산 성질을 이용합니다.
        for(int i = 3 ; i <= n ; i++) {
            d[i] = (d[i-1]%1234567+d[i-2]%1234567)%1234567;
        }
        
        answer = d[n];
        
        return answer;
    }
}

/*
d[i]를 i칸 뛰는 방법의 수라고할때
d[1] = 1
d[2] = 2
d[3] = d[1](2칸 뛰고 (3-2)칸을 뛰는 방법의 수)+d[2](1칸 뛰고 (3-1)칸을 뛰는 방법의 수)
d[4] = d[2](2칸 뛰고 (4-2)칸을 뛰는 방법의 수)+d[3](1칸 뛰고 (4-1)칸을 뛰는 방법의 수)
...
d[n] = d[n-2]+d[n-1]
2칸 뛰고 (n-2)칸을 뛰는 방법의 수 + 1칸 뛰고 (n-1)칸을 뛰는 방법의 수


*/