package Tests;

import Validators.*;

public class Test {

    public static void runTests() {


        String[] validPersonnummer = {
                "201701102384", "141206-2380", "20080903-2386", "7101169295",
                "198107249289", "19021214-9819", "190910199827", "191006089807",
                "192109099180", "4607137454", "194510168885", "900118+9811",
                "189102279800", "189912299816"
        };

        String[] invalidPersonnummer = {
                "201701272394", "190302299813"
        };

        String[] validSamordningsnummer = {
                "190910799824"
        };

        String[] invalidSamordningsnummer = {
                "190910299824"
        };

        String[] validOrganisationsnummer = {
                "556614-3185", "16556601-6399", "262000-1111", "857202-7566"
        };

        String[] invalidOrganisationsnummer = {
                "551014-3185", "18556601-6399"
        };

        ValidityCheck personnummerValidator = new PersonnummerValidator();
        ValidityCheck samordningsnummerValidator = new SamordningsnummerValidator();
        ValidityCheck organisationsnummerValidator = new OrganisationsnummerValidator();

        System.out.println("Testing valid personnummer:");
        runTestCases(validPersonnummer, personnummerValidator, "personnummer");

        System.out.println("\nTest ogiltiga personnummer:");
        runTestCases(invalidPersonnummer, personnummerValidator, "personnummer");

        System.out.println("\nTest giltiga samordningsnummer:");
        runTestCases(validSamordningsnummer, samordningsnummerValidator, "samordningsnummer");

        System.out.println("\nTest ogiltiga samordningsnummer:");
        runTestCases(invalidSamordningsnummer, samordningsnummerValidator, "samordningsnummer");

        System.out.println("\nTest giltiga organisationsnummer:");
        runTestCases(validOrganisationsnummer, organisationsnummerValidator, "organisationsnummer");

        System.out.println("\nTesting ogiltiga organisationsnummer:");
        runTestCases(invalidOrganisationsnummer, organisationsnummerValidator, "organisationsnummer");
    }

    private static void runTestCases(String[] numbers, ValidityCheck validator, String type) {
        for (String number : numbers) {
            String result = validator.validate(number);
            System.out.println(number + ": " + result);
        }
    }
}
