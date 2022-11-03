package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class PlayerInputFilter {
    private static final int NUMBERS_COUNT_LIMIT = 3;
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;
    private static final String NO_NUMBER_EXCEPTION = "입력한 값이 숫자가 아닙니다.";
    private static final String NOT_THREE_DIGIT_EXCEPTION = "입력한 값은 세자리 숫자여야 합니다.";
    private static final String CONTAINS_ZERO_EXCEPTION = "입력 문자열에 0이 있으면 안됩니다.";
    private static final String CONTAINS_SAME_NUMBER_EXCEPTION = "입력 문자열에 같은 숫자가 존재하면 안됩니다.";
    private int[] numbers;

    public PlayerInputFilter(){
        numbers = new int[3];
    }

    public int[] insertNumber(){
        String input = getInput();
        checkException(input);
        return convertNumbersToArray(input);
    }

    String getInput(){
        return Console.readLine();
    }

    void checkException(String input){
        if(isNotNumber(input)) noNumberException();
        if(isNotThreeDigit(input)) notThreeDigitException();
        if(containsZero(input)) containsZeroException();
        if(containsSameNumber(input)) containsSameNumberException();
    }

    boolean isNotNumber(String input){
        return !Pattern.matches("^[1-9]*$", input);
    }

    void noNumberException(){
        throw new IllegalArgumentException(NO_NUMBER_EXCEPTION);
    }

    boolean isNotThreeDigit(String input){
        return NUMBERS_COUNT_LIMIT != input.length();
    }

    void notThreeDigitException(){
        throw new IllegalArgumentException(NOT_THREE_DIGIT_EXCEPTION);
    }

    boolean containsZero(String input){
        return input.contains("0");
    }

    void containsZeroException(){
        throw new IllegalArgumentException(CONTAINS_ZERO_EXCEPTION);
    }

    boolean containsSameNumber(String input){
        return input.charAt(FIRST) == input.charAt(SECOND)
                || input.charAt(SECOND) == input.charAt(THIRD)
                ||  input.charAt(THIRD) == input.charAt(FIRST);
    }

    void containsSameNumberException(){
        throw new IllegalArgumentException(CONTAINS_SAME_NUMBER_EXCEPTION);
    }

    int[] convertNumbersToArray(String input){
        for(int index = 0; index < input.length(); index++){
            numbers[index] = Character.getNumericValue(input.charAt(index));
        }
        return numbers;
    }
}
