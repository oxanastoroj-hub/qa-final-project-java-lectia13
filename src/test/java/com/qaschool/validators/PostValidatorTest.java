package com.qaschool.validators;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PostValidatorTest {

    //Variabila validator
    private PostValidator validator;

    @BeforeClass
    public void setup() {
        // Inițializăm clasa pe care o testăm
        validator = new PostValidator();
    }

    // Data Provider
    @DataProvider(name = "postDataProvider")
    public Object[][] postDataProvider() {
        System.out.println("DataProvider: Se pregătesc datele de test...");

        // Generăm un text > 250 caractere
        String longText = "Un post foarte lung... (peste 250 caractere)" +
                "Un post foarte lung... (peste 250 caractere)" +
                "Un post foarte lung... (peste 250 caractere)" +
                "Un post foarte lung... (peste 250 caractere)" +
                "Un post foarte lung... (peste 250 caractere)" +
                "Un post foarte lung... (peste 250 caractere)" +
                "Un post foarte lung... (peste 250 caractere)" +
                "Un post foarte lung... (peste 250 caractere)" +
                "Un post foarte lung... (peste 250 caractere)";

        return new Object[][]{
                {"Acesta este un post valid", PostValidator.POST_VALID},
                {null, PostValidator.ERROR_EMPTY},
                {"", PostValidator.ERROR_EMPTY},
                {"Acest post vorbește despre politică.", PostValidator.ERROR_FORBIDDEN},
                {longText, PostValidator.ERROR_TOO_LONG}
        };
    }

    // Test parametrizat
    @Test(dataProvider = "postDataProvider", groups = {"test"} )
    public void testPostValidationScenarios(String postBody, String expectedStatus) {
        String actualStatus = validator.getPostStatus(postBody);
        Assert.assertEquals(actualStatus, expectedStatus);
    }
}