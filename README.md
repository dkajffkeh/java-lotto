# 로또
## 로또 게임
* 어플리케이션 흐름
    1. 사용자가 로또 구입금액을 입력한다 (공백없이 숫자만 입력)
    2. 입력 금액을 숫자로 변환한다.
    3. 입력받은 금액으로 몇 장의 로또를 살 수 있는지 구한다.
    4. 4번에서 구한 로또 갯수만큼 로또 (자동) 번호를 생성한다.
    5. 지난 주 당첨번호를 사용자로부터 입력받는다 (쉼표를 구분자로 사용하여 숫자 입력)
    6. 당첨 통계를 구한다.
    7. 결과를 출력한다.

* 기능 구현
    1. 구입금액에 대한 문자열을 입력받는 기능 (inputView)
        * 예외처리_입력값이 null이면 예외 반환 (inputView)
        * 예외처리_입력값이 Empty이면 예외 반환 (inputView)
    2. 입력한 구입 금액을 숫자로 변환하는 기능 (StringConverter)
        * 예외처리_숫자가 아니면 예외 반환 (StringConverter)
        * 예외처리_1000 보다 작으면 예외 반환 (StringConverter)
        * 예외처리_음수면 예외 반환 (Money)
    3. 입력 금액으로 살 수 있는 로또 갯수 구하는 기능 (Money)
    4. 4번에서 구한 갯수만큼 로또 번호 생성하는 기능 (Lotto)
    5. 지난 주 로또 번호를 입력받는 기능 (inputView)
        * 예외처리_공백 또는 null을 입력받으면 예외 반환 (inputView)
        * 예외처리_숫자가 아닌 문자열이 포함되어 있다면 예외 반환 (StringConverter)
        * 예외처리_1이상 45이하의 숫자가 아닌 숫자가 포함되어 있다면 예외 반환 (Lotto)
        * 예외처리_반복되는 숫자가 있다면 예외 반환 (Lotto)
        * 예외처리_숫자의 갯수가 6개가 아니면 예외반환 (Lotto)
    6. 당첨 통계 구하는 기능 (Lotto)
        * 구매한 로또와 당첨 로또번호 비교하는 기능 (Lotto)
        * 구매한 전체 로또 갯수 중에 당첨로또와 3개 일치하는 로또 갯수 구하는 기능 (Lottos)
        * 구매한 전체 로또 갯수 중에 당첨로또와 4개 일치하는 로또 갯수 구하는 기능 (Lottos)
        * 구매한 전체 로또 갯수 중에 당첨로또와 5개 일치하는 로또 갯수 구하는 기능 (Lottos)
        * 구매한 전체 로또 갯수 중에 당첨로또와 6개 일치하는 로또 갯수 구하는 기능 (Lottos)
        * 수익률 구하는 기능 (Lottos)
    7. 결과를 출력하는 기능 (resultView 에서 구현)

## 문자열 덧셈 계산기
* 어플리케이션 흐름
    1. 사용자가 문자열을 입력한다.
    2. 입력값에 대한 Null&Empty 검증을 진행한다.
    3. 문자열을 구분자를 기준으로 분리한다.
    4. 문자열을 숫자로 변환한다.
    5. 숫자를 더한다.
    
* 기능 구현
    1. 입력받은 문자열을 출력하는 기능
    2. 입력값을 검증하는 기능
        * 예외처리_입력값이 null이면 0을 반환한다.
        * 예외처리_입력값이 Empty이면 0을 반환한다.
    3. 입력받은 문자열을 인자로 주면, 구분자로 구분된 문자열의 배열(또는 콜렉션)를 반환하는 기능
    4. 구분자로 구분된 문자열의 배열(또는 콜렉션)을 인자로 주면, 숫자로 반환하는 기능 
        * 기능_문자열 배열(또는콜렉션)을 숫자로 변환한다.
        * 예외처리_입력값이 숫자가 아니면 예외를 던진다.
        * 예외처리_입력값이 음수면 예외를 던진다.
    5. 숫자로 변환된 배열(또는 콜렉션)을 인자로 주면, 더하기 연산의 결과값을 반환하는 기능
        