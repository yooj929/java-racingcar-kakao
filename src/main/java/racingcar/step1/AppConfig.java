package racingcar.step1;

import racingcar.step1.generator.RandomNumberGenerator;
import racingcar.step1.view.InputView;
import racingcar.step1.view.OutputView;

public interface AppConfig {

    public RandomNumberGenerator getRandomNumberGenerator();
    public InputView getInputView();
    public OutputView getOutputView();
}
