package racingcar.step1.domain;

import java.util.Objects;

public class RacingCar implements Car {
    private static final int BOUND = 3;

    private final String name;

    private int distance;

    public RacingCar(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    public void move(int condition) {
        if (condition < 0 || condition > 9) {
            throw new IllegalArgumentException("move의 condition은 0 ~ 9 사이의 값이어야합니다.");
        }
        if (condition > BOUND) {
            distance++;
        }
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, "-".repeat(distance));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCar racingCar = (RacingCar) o;
        return distance == racingCar.distance && Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
