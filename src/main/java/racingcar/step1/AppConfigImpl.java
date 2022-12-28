package racingcar.step1;

import racingcar.step1.generator.RandomNumberGenerator;
import racingcar.step1.generator.RandomNumberGeneratorImpl;
import racingcar.step1.view.InputView;
import racingcar.step1.view.OutputView;

public class AppConfigImpl implements AppConfig {
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorImpl();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    @Override
    public RandomNumberGenerator getRandomNumberGenerator() {
        return randomNumberGenerator;

    }

    @Override
    public InputView getInputView() {
        return inputView;
    }

    @Override
    public OutputView getOutputView() {
        return outputView;
    }
}
