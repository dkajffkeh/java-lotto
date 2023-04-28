package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MinusTwoNumbersTest {

    @ParameterizedTest(name = "두 수를 나눈값을 정수형으로 반환한다 {0} - {1} = {2} ")
    @CsvSource(value = {"5:2:3", "12:4:8"}, delimiter = ':')
    void addNumbersTest(int num1, int num2, int expected) {
        assertThat(new MinusTwoNumbers().calculateTwoNumbers(num1,num2)).isEqualTo(expected);
    }

}