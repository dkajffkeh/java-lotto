package lottery.domain;

import static lottery.domain.Lotteries.lotteriesByPlaysAndManual;
import static lottery.domain.constant.Rank.sortRanksByCountOfMatch;
import static lottery.view.BlankPrintView.printBlank;
import static lottery.view.ManualInputView.manualInput;
import static lottery.view.QuantityView.printQuantity;
import static lottery.view.ResultView.printLotteries;
import static lottery.view.ResultView.printReturnRate;
import static lottery.view.ResultView.printStatisticsResult;
import static lottery.view.ResultView.printStatisticsResultBanner;
import static lottery.view.WinningNumberInputView.winningNumbers;

import lottery.domain.constant.Rank;
import lottery.view.PriceInputView;

public class LotteryApplication {

    public static void main(String[] args) {
        runLotteryApplication();
    }

    public static void runLotteryApplication() {

        PurchasedLottery purchasedLottery =
                PriceInputView.buyLotteries();

        Lotteries lotteries = lotteriesByPlaysAndManual(purchasedLottery.autoPlays(),
                manualInput(purchasedLottery.manualPlays()));

        printQuantity(purchasedLottery.manualPlays(),purchasedLottery.autoPlays());

        printLotteries(lotteries.immutableGetLotteries());

        printBlank();

        WinningStatistics winningStatistics =
                new WinningStatistics(lotteries.statisticsByRank(winningNumbers()));

        printStatisticsResultBanner();

        for (Rank rank : sortRanksByCountOfMatch()) {
            printStatisticsResult(rank, winningStatistics.getWinningNumbers(rank));
        }

        printReturnRate(winningStatistics
                .returnOnInvestment(purchasedLottery.totalPlays()));

    }
}
