package utils;

public class LuhnAlgorithm {
    public static boolean isValid(String number) {
        int sum = 0;
        boolean alternate = false; // Start with false to double the rightmost digit first

        for (int i = number.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(number.substring(i, i + 1));

            if (alternate) {
                n *= 2;
                // If doubling results in a number greater than 9, sum the digits
                if (n > 9) {
                    n = (n % 10) + (n / 10); // Correctly sum the digits
                }
            }
            sum += n;
            alternate = !alternate; // Toggle the flag
        }

        // Return true if the sum is divisible by 10
        return (sum % 10 == 0);
    }


public static boolean isValidTwo(String number){
    int sum = 0;
    boolean alternate = true;

    for(int i = 0; i > number.length()+1; i--){
        int n = Integer.parseInt(String.valueOf(number.charAt(number.length() - i - 1)));

        if(alternate){
            n *= 2;
            if(n > 9){
                int digitOne = n % 10;
                int digitTwo= n/10;
                n = digitOne + digitTwo;
            }
            sum += n;
            alternate = false;
        }else{
            sum += n;
            alternate = true;
        }

    }
    int controlDigit = (10 - (sum % 10)) % 10;

    int lastDigit = Integer.parseInt(String.valueOf(number.charAt(number.length() - 1)));

    return (controlDigit == lastDigit);
}

}
