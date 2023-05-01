package lottery.view;

import java.util.Scanner;
import lottery.domain.WeeklyWinningNumbers;

public class WinningNumberInputView {

    private static final String INPUT_MSG = "지난 주 당첨 번호를 입력해 주세요.";

    public static WeeklyWinningNumbers winningNumbers() {
        printSource(INPUT_MSG);
        return new WeeklyWinningNumbers(new Scanner(System.in).next());
    }

    private static void printSource(String source) {
        System.out.println(source);
    }
}
