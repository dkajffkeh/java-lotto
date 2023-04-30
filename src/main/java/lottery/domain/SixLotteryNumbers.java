package lottery.domain;

import static java.lang.String.valueOf;
import static lottery.domain.constant.LotteryNumberRule.LOTTERY_NUMBERS_SIZE;

import java.util.HashSet;
import java.util.Set;
import lottery.domain.numbergenerator.RandomNumberGenerator;

public class SixLotteryNumbers {

    private static final String INVALID_NUMBERS_MSG = "로또 번호는 총 6개의 숫자로 구성되어야합니다.";

    private static final RandomNumberGenerator RANDOM_NUMBER_GENERATOR =
            new RandomNumberGenerator();

    private final Set<LotteryNumber> lotteryNumbers;

    public SixLotteryNumbers() {
        this(autoGeneratedSixNumbers());
    }

    public SixLotteryNumbers(Set<LotteryNumber> lotteryNumbers) {
        if(notHasSixNumbers(lotteryNumbers)) {
            throw new IllegalArgumentException(INVALID_NUMBERS_MSG);
        }
        this.lotteryNumbers = lotteryNumbers;
    }

    private static Set<LotteryNumber> autoGeneratedSixNumbers() {
        Set<LotteryNumber> lotteryNumbers = new HashSet<>();
        while (lotteryNumbers.size() != 6) {
            lotteryNumbers.add(new LotteryNumber(RANDOM_NUMBER_GENERATOR.generatedNumber()));
        }
        return lotteryNumbers;
    }

    private boolean notHasSixNumbers(Set<LotteryNumber> lotteryNumbers) {
        return lotteryNumbers.size() != LOTTERY_NUMBERS_SIZE.getRuleNumber();
    }

    public int size() {
        return lotteryNumbers.size();
    }

    @Override
    public String toString() {
        return valueOf(lotteryNumbers);
    }
}
