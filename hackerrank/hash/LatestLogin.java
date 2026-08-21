package hash;

/*
 * [문제] 사용자별 최신 접속 기록
 *
 * 서버에 사용자 접속 기록이 주어진다.
 *
 * 각 기록은 다음 형식이다.
 * "사용자ID 접속시간 IP주소"
 *
 * 같은 사용자가 여러 번 접속할 수 있으며,
 * 각 사용자의 "가장 최근 접속 기록"만 남겨야 한다.
 *
 * 모든 사용자의 최신 접속 기록 중에서
 * 특정 IP 주소를 사용한 사용자의 수를 반환하라.
 *
 * 단, 접속시간은 정수이며 값이 클수록 최근 접속이다.
 *
 * [조건]
 * - 1 <= logs.length <= 100,000
 * - 사용자 ID는 중복될 수 있다.
 * - 같은 사용자가 같은 시간에 여러 번 접속하는 경우는 없다.
 *
 * [예시]
 *
 * logs = [
 *     "u01 10 192.168.0.1",
 *     "u02 20 192.168.0.2",
 *     "u01 30 192.168.0.3",
 *     "u03 15 192.168.0.1",
 *     "u02 40 192.168.0.1",
 *     "u03 25 192.168.0.2"
 * ]
 *
 * targetIp = "192.168.0.1"
 *
 * 각 사용자의 최신 접속 기록:
 *
 * u01 → 30 / 192.168.0.3
 * u02 → 40 / 192.168.0.1
 * u03 → 25 / 192.168.0.2
 *
 * 따라서 targetIp를 사용하는 사용자는 u02 한 명이다.
 *
 * 결과: 1
 *
 * [힌트]
 * 사용자 ID를 Key로 사용하면
 * 각 사용자의 최신 기록을 관리하기 쉽다.
 *
 * 예:
 * Map<String, ...>
 *
 * 시간 비교를 통해 기존 기록보다 최신인 경우에만
 * 값을 변경하면 된다.
 *
 * [목표]
 * 시간복잡도 O(N)으로 해결해보자.
 *
 * 핵심은 Map<String, ???>에서 ???에 뭘 넣을지 결정하는 거야.

 * 그리고 로그가 시간순으로 들어온다는 보장이 없다는 것을 꼭 생각하면서 풀어봐.
 * smain() 돌렸을 때 결과가 1이 나오게 만들면 돼.
*
 */

import java.util.HashMap;
import java.util.Map;

public class LatestLogin {

    public static int solution(String[] logs, String targetIp) {

        Map<String, Map<String, String>> resultList = new HashMap<>();

        for (String tmp : logs) {
            String[] infoList = tmp.split(" ");
            String userId = infoList[0];
            String time = infoList[1];
            String ip = infoList[2];

            resultList.putIfAbsent(userId,new HashMap<>());
            // 기준이 ip 가 되어야함.    ....
            resultList.getOrDefault()
            Map<String, String> tmpMap = new HashMap<>();

        }
        return 0;
    }

    public static void main(String[] args) {

        String[] logs = {
                "u01 10 192.168.0.1",
                "u02 20 192.168.0.2",
                "u01 30 192.168.0.3",
                "u03 15 192.168.0.1",
                "u02 40 192.168.0.1",
                "u03 25 192.168.0.2"
        };

        String targetIp = "192.168.0.1";

        int result = solution(logs, targetIp);

        System.out.println("결과: " + result);
    }
}