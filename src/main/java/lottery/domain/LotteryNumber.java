package lottery.domain;

import static java.lang.String.valueOf;
import static lottery.domain.constant.LotteryNumberRule.MAX_LOTTERY_NUMBER;
import static lottery.domain.constant.LotteryNumberRule.MIN_LOTTERY_NUMBER;

import java.util.Objects;

public class LotteryNumber {

    private static final String OUT_OF_RANGE_NUMBER_MSG = "로또 번호는 1~45 의 정수만 입력 될 수 있습니다.";

    private final int lotteryNumber;

    public LotteryNumber(int lotteryNumber) {
        if (outOfRange(lotteryNumber)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_MSG);
        }
        this.lotteryNumber = lotteryNumber;
    }

    private boolean outOfRange(int lotteryNumber) {
        return lotteryNumber < MIN_LOTTERY_NUMBER.getRuleNumber()
                || lotteryNumber > MAX_LOTTERY_NUMBER.getRuleNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LotteryNumber that = (LotteryNumber) o;
        return lotteryNumber == that.lotteryNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryNumber);
    }

    @Override
    public String toString() {
        return valueOf(this.lotteryNumber);
    }
}
