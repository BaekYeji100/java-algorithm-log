package hash;

import java.util.HashMap;
import java.util.Map;
/*
 * [문제] API 로그 분석
 *
 * 서버에서 발생한 API 요청 로그가 주어진다.
 *
 * 각 로그는 다음 형식이다.
 * "사용자ID API경로 요청시간"
 *
 * logs와 정수 k가 주어졌을 때,
 * 각 API를 k번 이상 호출한 사용자 수가 가장 많은 API를 반환하라.
 *
 * 단, 사용자 수가 동일한 API가 여러 개라면
 * API 경로를 사전순으로 가장 앞선 것을 반환한다.
 *
 * [제한사항]
 * - 1 <= logs.length <= 100,000
 * - 1 <= k <= 100,000
 * - 로그의 시간은 정렬되어 있지 않을 수 있다.
 *
 * [예시]
 * logs = [
 *     "u01 /api/login 10",
 *     "u02 /api/login 12",
 *     "u01 /api/order 15",
 *     "u03 /api/login 18",
 *     "u01 /api/order 20",
 *     "u02 /api/order 21",
 *     "u03 /api/order 22"
 * ]
 *
 * k = 2
 *
 * 결과: "/api/login"
 *
 * [풀이]
 * API별 사용자별 호출 횟수를 Map으로 관리한다.
 *
 * API
 *  └── 사용자
 *       └── 호출 횟수
 *
 * 이후 각 API에 대해 k번 이상 호출한 사용자의 수를 계산하고,
 * 가장 많은 사용자를 가진 API를 선택한다.
 * 사용자 수가 같다면 사전순으로 앞선 API를 선택한다.
 *
 * 시간복잡도: O(N)
 * 공간복잡도: O(N)
 */
public class ApiLogAnalyzer {
    public static void main(String[] args) {

        String[] logs = {
                "u01 /api/login 10",
                "u02 /api/login 12",
                "u01 /api/order 15",
                "u03 /api/login 18",
                "u01 /api/order 20",
                "u02 /api/order 21",
                "u03 /api/order 22"
        };

        int k = 2;

        String result = solution(logs, k);

        System.out.println("결과: " + result);
    }
    public static String solution(String[] logs, int k) {
        // API 별 사용자별 호출 횟수
        Map<String, Map<String, Integer>> resultTmp = new HashMap<>();

        for (String tmp : logs) {
            String[] tempList = tmp.split(" ");
            String user = tempList[0];
            String api = tempList[1];

            resultTmp.putIfAbsent(api, new HashMap<>());

            Map<String, Integer> userCount = resultTmp.get(api);
            userCount.put(
                    user,
                    userCount.getOrDefault(user, 0) + 1
            );
        }

        // K 번 이상 호출한 사용자 수가 가장 많은 API 찾기
        String answer = "";
        int maxCount = 0;

        for (String api : resultTmp.keySet()) {
            int count = 0;
            Map<String, Integer> userCount = resultTmp.get(api);
            for (int value : userCount.values()) {
                if (value >= k) {
                    count++;
                }
            }
            if (count > maxCount ||
                    (count == maxCount && (answer.isEmpty() || api.compareTo(answer) < 0))) {
                maxCount = count;
                answer = api;
            }
        }
        return answer;
    }
}
