package stringadder;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAdder {
    public int add(String text) {
        int result;
        if (isNullOrBlank(text)) {
            return StringAdderConstant.IS_NULL_OR_BLANK;
        }
        List<Integer> numbers = getNumbers(split(text));
        isValid(numbers);
        result = sum(numbers);
        return result;
    }

    public boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }


    public String[] split(String text) {
        StringBuilder stringBuilder = new StringBuilder(",|;");
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            stringBuilder.append("|").append(customDelimiter);
            return m.group(2).split(stringBuilder.toString());
        }
        return text.split(stringBuilder.toString());
    }

    public List<Integer> getNumbers(String[] numbers) {
        List<Integer> result;
        try {
            result = Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        return result;
    }

    public void isValid(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 0)) {
            throw new RuntimeException("negative");
        }
    }

    public int sum(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
