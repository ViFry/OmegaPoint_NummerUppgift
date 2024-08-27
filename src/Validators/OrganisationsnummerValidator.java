package Validators;

import utils.LuhnAlgorithm;

public class OrganisationsnummerValidator extends BaseValidator {

    //Becuse an organization cannot have an date, so always return true.
    @Override
    protected boolean isValidDate(String datePart) {
        return true;
    }

    @Override
    public String validate(String number) {
        number = normalize(number);

        if(number.length() == 12 && (Integer.parseInt(number.substring(0,2)) != 16)){
            return "De två första siffrorna måste vara 16 om det är ett 12-siffrigt " + getTypeOfNumber();
        }

        if (!isValidLength(number)) {
            return "Ogiltig längd i " + getTypeOfNumber();
        }

        if (number.length() == 12) {
            number = number.substring(2);
        }

        if (!isValidMiddlePair(number)) {
            return "Ogiltigt " + getTypeOfNumber() + "." + " Mitten paret måste vara minst 20.";
        }

        if (!LuhnAlgorithm.isValid(number)) {
            return "Ogiltig kontrollsiffra i " + getTypeOfNumber();
        }

        return "Giltigt " + getTypeOfNumber();
    }

    private boolean isValidMiddlePair(String number) {
        int middlePair = Integer.parseInt(number.substring(2, 4));
        return middlePair >= 20;
    }

    @Override
    protected String getTypeOfNumber() {
        return "Organisationsnummer";
    }
}
