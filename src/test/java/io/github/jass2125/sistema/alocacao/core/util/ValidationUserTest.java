/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.util;

import io.github.jass2125.sistema.alocacao.core.exceptions.FieldEmptyException;
import io.github.jass2125.sistema.alocacao.core.exceptions.RegexException;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Anderson Souza
 */
public class ValidationUserTest {

    private ValidationUser val;

    @Before
    public void setUp() {
        val = new ValidationUser();
    }

    /**
     * Test of validatorUsername method, of class ValidationUser.
     */
    @Test(expected = RegexException.class)
    public void testValidatorUsername() throws RegexException, FieldEmptyException {
        //%-$_#@ . pode
        String username = "jass2125#";
        val.validatorUsername(username);

        username = "@diogo";
        val.validatorUsername(username);

        username = "dio%go";
        val.validatorUsername(username);

        username = "jor$ge";
        val.validatorUsername(username);

        username = "-amancio";
        val.validatorUsername(username);

        username = "jair_anderson";
        val.validatorUsername(username);

    }

    @Test(expected = FieldEmptyException.class)
    public void testValidatorEmpty() throws RegexException, FieldEmptyException {
        String username = "";
        val.validatorUsername(username);

    }

//    @Test
//    public void testValidandoUsername() throws RegexException, FieldEmptyException {
//            String username = "jair.anderson";
//            val.validatorUsername(username);
//
//            username = "jairanderson.";
//            val.validatorUsername(username);
//
//    }
    /**
     * Test of validatorPassword method, of class ValidationUser.
     */
//    @Test
//    public void testValidatorPassword() throws Exception {
//        System.out.println("validatorPassword");
//        String password = "";
//        ValidationUser instance = new ValidationUser();
//        instance.validatorPassword(password);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of validatorEmail method, of class ValidationUser.
     */
//    @Test
//    public void testValidatorEmail() throws Exception {
//        System.out.println("validatorEmail");
//        String email = "";
//        ValidationUser instance = new ValidationUser();
//        instance.validatorEmail(email);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of validatorRegistry method, of class ValidationUser.
     */
//    @Test
//    public void testValidatorRegistry() throws Exception {
//        System.out.println("validatorRegistry");
//        String registry = "";
//        ValidationUser instance = new ValidationUser();
//        instance.validatorRegistry(registry);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of validatorDataUser method, of class ValidationUser.
     */
//    @Test
//    public void testValidatorDataUser() throws Exception {
//        System.out.println("validatorDataUser");
//        User user = null;
//        ValidationUser instance = new ValidationUser();
//        instance.validatorDataUser(user);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
