# [프로그래머스 Lv.2] 의상 (해시)

## 📌 문제 설명
코니는 매일 다른 옷을 조합하여 입어 자신을 가꾸고 싶어 합니다.

예를 들어 코니가 오늘 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면, 내일은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용해야 합니다.

코니가 가진 의상들이 담긴 2차원 배열 `clothes`가 주어질 때, 서로 다른 옷의 조합의 수를 return 하도록 `solution` 함수를 작성해주세요.

---

## 🔒 제한 사항
- `clothes`의 각 행은 `[의상의 이름, 의상의 종류]`로 이루어져 있습니다.
- 코니가 가진 의상의 수는 1개 이상 30개 이하입니다.
- 같은 이름을 가진 의상은 존재하지 않습니다.
- `clothes`의 모든 원소는 문자열로 이루어져 있습니다.
- 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 `_` 로만 이루어져 있습니다.
- 코니는 하루에 최소 한 개의 의상은 입습니다.

---

## 📥 입출력 예

| clothes | return |
| :--- | :--- |
| `[["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]` | `5` |
| `[["smoky_makeup", "face"], ["john_ny", "face"], ["pt_sunglasses", "face"]]` | `3` |

### 입출력 예 설명

**예제 #1**
- `headgear`에 해당하는 의상: `yellow_hat`, `green_turban` (2개)
- `eyewear`에 해당하는 의상: `blue_sunglasses` (1개)
- 조합 계산: `(2 + 1) * (1 + 1) - 1 = 5`

**예제 #2**
- `face`에 해당하는 의상: `smoky_makeup`, `john_ny`, `pt_sunglasses` (3개)
- 조합 계산: `(3 + 1) - 1 = 3`

---

## 💡 핵심 접근 아이디어

1. **의상 종류별 그룹핑 (Map / HashMap)**
    - 의상 종류(Category)를 Key, 해당 종류 의상 개수를 Value로 하는 Map을 생성합니다.
2. **경우의 수 공식**
    - 각 종류별로 **"안 입는 경우"**를 1가지씩 추가합니다. (`개수 + 1`)
    - 모든 종류의 경우의 수를 곱합니다.
    - 마지막으로 **"아무것도 안 입은 상태"** 1가지를 차감합니다.

$$\text{Total} = \prod_{i=1}^{k} (\text{count}_i + 1) - 1$$

---

## 💻 풀이 스켈레톤 코드 (Java)

```java
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // TODO: 의상 종류별 개수 카운팅 및 경우의 수 계산
        int answer = 1;
        
        return answer;
    }
}