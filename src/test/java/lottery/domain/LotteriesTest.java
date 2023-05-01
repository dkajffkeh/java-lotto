package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Map;
import lottery.domain.constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LotteriesTest {

    private static final int FIVE_PLAYS = 5;

    private static final Lotteries FIVE_LOTTERIES = new Lotteries(FIVE_PLAYS);

    private static final LotteryDummyData LOTTERY_DUMMY_DATA = new LotteryDummyData();


    @ParameterizedTest(name = "로또 플레이 횟수 입력에 맞춰 로또를 생성한다.")
    @ValueSource(ints = {0, 2})
    void lotteryCreateByPlaysTest(int plays) {
        assertThat(new Lotteries(plays).size()).isEqualTo(plays);
    }

    @Test
    @DisplayName("1급 컬렉션에서 취급하는 불변값은 추가 삭제 수정을 할 수 없다.")
    void immutableListTest() {
        assertThatThrownBy(() -> FIVE_LOTTERIES.immutableGetLotteries()
                .add(new Lottery()))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("총 1등부터 4등까지 당첨이력이 있는 Map 객체를 반환한다.")
    void dividedLotteriesByRankTest() {
        Map<Rank, Integer> dividedLotteries = LOTTERY_DUMMY_DATA
                .lotteriesDummyObj()
                .getDividedLotteriesByRank(LOTTERY_DUMMY_DATA
                        .winningNumbersDummyObj()
                        .getNumbers());

        assertAll(
                () -> assertThat(dividedLotteries.get(Rank.FIRST)).isEqualTo(1),
                () -> assertThat(dividedLotteries.get(Rank.SECOND)).isEqualTo(1),
                () -> assertThat(dividedLotteries.get(Rank.THIRD)).isEqualTo(1),
                () -> assertThat(dividedLotteries.get(Rank.FOURTH)).isEqualTo(1)
        );
    }
}
