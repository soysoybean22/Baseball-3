public class Game {

    public String question;

    public GuessResult guess(String guessNumber) {
        assertIllegalArgument(guessNumber);
        if (guessNumber.equals(question)) {
            return new GuessResult(true, 3, 0);
        } else {
            int strikeCount = 0;
            int ballCount = 0;

            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    if (guessNumber.charAt(i) == question.charAt(j)) {
                        if (i == j) {
                            ++strikeCount;
                        } else {
                            ++ballCount;
                        }
                    }
                }
            }

            if (strikeCount != 0 || ballCount != 0) {
                return new GuessResult(false, strikeCount, ballCount);
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
