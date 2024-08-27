package Validators;

import utils.LuhnAlgorithm;
import utils.DateValidator;

public abstract class BaseValidator implements ValidityCheck {

    @Override
    public String validate(String number) {
        number = normalize(number);

        if (!isValidLength(number)) {
            return "Ogiltigt längd i " + getTypeOfNumber();
        }

        if (number.length() == 12) {
            number = number.substring(2);
        }

        if (!isValidDate(number.substring(0, 6))) {
            return "Ogiltig datum i " + getTypeOfNumber();
        }

        if (!LuhnAlgorithm.isValid(number)) {
            return "Ogiltigt kontrollsiffra i " + getTypeOfNumber();
        }
        return "Giltigt " + getTypeOfNumber();
    }

    protected String normalize(String number) {
        return number.replaceAll("[+-]", "");
    }

    protected boolean isValidLength(String number) {
        return number.length() == 10 || number.length() == 12;
    }


    protected boolean isValidDate(String datePart) {
        return DateValidator.isValidDate(datePart);
    }

    protected String getTypeOfNumber(){
        return "unknown";
    }
}
