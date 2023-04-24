package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DivideTwoNumbersTest {

    @ParameterizedTest(name = "두 수의 나눗셈을 정수로 반환한다 {0} / {1} = {2} ")
    @CsvSource(value = {"5:2:2", "6:2:3"}, delimiter = ':')
    void addNumbersTest(int num1, int num2, int expected) {
        assertThat(new DivideTwoNumbers().calculateTwoNumbers(num1,num2)).isEqualTo(expected);
    }

}