package racingcar.step1;

import racingcar.step1.domain.RacingCarGame;
import racingcar.step1.domain.RacingCarGameImpl;

public class RacingCarApp {

    private final AppConfig appConfig;

    public RacingCarApp(AppConfig appConfig){
        this.appConfig = appConfig;
    }

    public void run(){
        RacingCarGame racingCarGame = new RacingCarGameImpl(appConfig);
        racingCarGame.play();

    }
}
