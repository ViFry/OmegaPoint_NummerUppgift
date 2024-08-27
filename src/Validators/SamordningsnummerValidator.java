package Validators;

import utils.DateValidator;

public class SamordningsnummerValidator extends PersonnummerValidator {

    @Override
    protected boolean isValidDate(String datePart) {
        try {
            int day = Integer.parseInt(datePart.substring(4, 6)) - 60;
            return DateValidator.isValidDate(datePart.substring(0, 4) + String.format("%02d", day));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    protected String getTypeOfNumber() {
        return "Sammordningsnummer";
    }
}
