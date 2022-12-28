package stringadder;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAdder {
    public static final String  PRIMITIVE_DELIMITER= ",|;";

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
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            StringBuilder stringBuilder = new StringBuilder(PRIMITIVE_DELIMITER);
            String customDelimiter = m.group(1);
            stringBuilder.append("|").append(customDelimiter);
            return split(m.group(2), stringBuilder.toString());
        }
        return split(text, PRIMITIVE_DELIMITER);
    }

    private String[] split(String text, String delimiter) {
        return text.split(delimiter);
    }

    public List<Integer> getNumbers(String[] numbers) {
        List<Integer> result;
        try {
            result = Arrays.stream(numbers).map(this::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        return result;
    }
    public Integer parseInt(String number){
        if(isNullOrBlank(number))
            return 0;
        return Integer.parseInt(number);
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
