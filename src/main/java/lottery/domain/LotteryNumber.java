package lottery.domain;

import static java.lang.String.valueOf;

import java.util.Objects;
import java.util.Set;

public class LotteryNumber {
    protected static final int MIN = 1;

    protected static final int MAX = 45;

    private static final String OUT_OF_RANGE_NUMBER_MSG = "로또 번호는 1~45 의 정수만 입력 될 수 있습니다.";

    private final int lotteryNumber;

    public LotteryNumber(int lotteryNumber) {
        if (outOfRange(lotteryNumber)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_MSG);
        }
        this.lotteryNumber = lotteryNumber;
    }

    public boolean containsNumber(Set<LotteryNumber> lotteryNumbers) {
        return lotteryNumbers.contains(this);
    }

    private boolean outOfRange(int lotteryNumber) {
        return lotteryNumber < MIN
                || lotteryNumber > MAX;
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
