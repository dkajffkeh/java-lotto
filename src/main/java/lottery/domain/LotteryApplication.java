package lottery.domain;

import static lottery.view.BlankPrintView.printBlank;
import static lottery.view.ResultView.printAutoGeneratedNumbers;

import lottery.view.PriceInputView;

public class LotteryApplication {

    public static void main(String[] args) {
        runLotteryApplication();
    }

    public static void runLotteryApplication() {
        ClientLotteryPurchasePrice clientLotteryPurchasePrice =
                PriceInputView.buyLotteries();

        Lotteries lotteries = new Lotteries(clientLotteryPurchasePrice.getLotteries());

        printAutoGeneratedNumbers(lotteries.immutableGetLotteries());

        printBlank();


    }
}
