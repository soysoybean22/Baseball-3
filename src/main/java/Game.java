public class Game {

    public String question;

    public GuessResult guess(String guessNumber) {
        assertIllegalArgument(guessNumber);
        if (guessNumber.equals(question)) {
            return new GuessResult(true, 3, 0);
        } else {
            int count = 0;

            if(guessNumber.charAt(0) == question.charAt(0)) {
                ++count;
            }

            if(guessNumber.charAt(1) == question.charAt(1)) {
                ++count;
            }

            if(guessNumber.charAt(2) == question.charAt(2)) {
                ++count;
            }

            if(count != 0) {
                return new GuessResult(false, count, 0);
            }

            return new GuessResult(false, 0, 0);
        }
    }

    private static void assertIllegalArgument(String guessNumber) {
        if (guessNumber == null) {
            throw new IllegalArgumentException();
        }

        if (guessNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (char number : guessNumber.toCharArray()) {
            if (number < '0' || number > '9') {
                throw new IllegalArgumentException();
            }
        }

        if (isDuplicatedNumber(guessNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDuplicatedNumber(String guessNumber) {
        return guessNumber.charAt(0) == guessNumber.charAt(1)
                || guessNumber.charAt(0) == guessNumber.charAt(2)
                || guessNumber.charAt(1) == guessNumber.charAt(2);
    }
}
