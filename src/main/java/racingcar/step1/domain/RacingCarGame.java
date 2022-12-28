package racingcar.step1.domain;

import java.util.List;

public interface RacingCarGame {

    void run(int times);

    void add(String carName);

    void add(Car... cars);

    List<Car> getWinner();

    List<String> getWinnerNames();

    List<String> getCarResults();

    void play();
}
