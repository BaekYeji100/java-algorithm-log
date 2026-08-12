package hash;

import java.util.*;

class Programmers_lv2_clothes {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // [테스트 케이스 1]
        String[][] clothes1 = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        int result1 = sol.solution(clothes1);
        System.out.println("예제 1 결과: " + result1 + " (기대값: 5) -> " + (result1 == 5 ? "성공" : "실패"));

        // [테스트 케이스 2]
        String[][] clothes2 = {
                {"smoky_makeup", "face"},
                {"john_ny", "face"},
                {"pt_sunglasses", "face"}
        };
        int result2 = sol.solution(clothes2);
        System.out.println("예제 2 결과: " + result2 + " (기대값: 3) -> " + (result2 == 3 ? "성공" : "실패"));
    }
}
class Solution {
    public int solution(String[][] clothes) {
        // 1. 의상 종류별 개수 저장 (Map)
        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            String category = cloth[1]; // [0]은 의상 이름, [1]은 의상 종류
            map.put(category, map.getOrDefault(category, 0) + 1);
        }

        // 2. 조합 수 계산
        int answer = 1;
        for (int count : map.values()) {
            answer *= (count + 1); // 안 입는 선택지 (+1)
        }

        // 3. 모두 안 입은 경우 (-1)
        return answer - 1;
    }
}
