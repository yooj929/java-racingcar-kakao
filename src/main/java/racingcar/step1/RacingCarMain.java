package racingcar.step1;

public class RacingCarMain {
    public static void main(String[] args) {
        RacingCarApp racingCarApp = new RacingCarApp(new AppConfigImpl());
        racingCarApp.run();
    }
}
