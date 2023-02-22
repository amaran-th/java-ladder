package ladder.controller;

import ladder.domain.Names;
import ladder.domain.PlayerNames;
import ladder.domain.RandomStepGenerator;
import ladder.domain.Rows;
import ladder.util.Repeater;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private Names names;
    private Rows rows;

    public void run() {

        names = Repeater.repeatIfError(this::inputNames, ResultView::printErrorMessage);
        rows = Repeater.repeatIfError(this::inputLines, ResultView::printErrorMessage);
        rows.generateLegsOfLines(new RandomStepGenerator());
        ResultView.printResult(names.toDto(), rows.toDto());
    }

    private Names inputNames() {
        return new PlayerNames(InputView.inputPlayerNames());
    }

    private Rows inputLines() {
        int intervalCount = names.getCount() - 1;
        return new Rows(InputView.inputLadderHeight(), intervalCount);
    }
}
