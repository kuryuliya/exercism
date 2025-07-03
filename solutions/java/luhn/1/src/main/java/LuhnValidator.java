class LuhnValidator {

    boolean isValid(String candidate) {
        if (candidate == null) return false;
        String digits = candidate.replace(" ", "");
        if (digits.length() <= 1) return false;
        int sum = 0;
        boolean doubleDigit = false;
        for (int i = digits.length() - 1; i >= 0; i--) {
            char c = digits.charAt(i);
            if (!Character.isDigit(c)) return false;
            int n = c - '0';
            if (doubleDigit) {
                n *= 2;
                if (n > 9) n -= 9;
            }
            sum += n;
            doubleDigit = !doubleDigit;
        }
        return sum % 10 == 0;
    }

}
