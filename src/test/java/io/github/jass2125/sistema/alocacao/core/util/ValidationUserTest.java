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
    String username;
    String password;
    String registry;
    String email;

    @Before
    public void setUp() {
        val = new ValidationUser();
    }

    /**
     * Test of validatorUsername method, of class ValidationUser.
     *
     * @throws RegexException
     * @throws FieldEmptyException
     */
    @Test(expected = RegexException.class)
    public void testValidatorUsername() throws RegexException, FieldEmptyException {
        //%-$_#@ . pode
        username = "jass2125#";
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

    @Test
    public void testValidandoUsername() {
        try {
            username = "jair.anderson";
            val.validatorUsername(username);

            username = "jairanderson.";
            val.validatorUsername(username);

            username = "2125";
            val.validatorUsername(username);

            username = ".jair";
            val.validatorUsername(username);
        } catch (FieldEmptyException | RegexException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test of validatorPassword method, of class ValidationUser.
     *
     *
     */
    @Test(expected = RegexException.class)
    public void testValidatorPassword() throws RegexException {
//        try {
            password = "dfter5fsd7575";
            val.validatorPassword(password);

            password = "DHfter5fsd7575";
            val.validatorPassword(password);

            password = "#fter5fsd7575";
            val.validatorPassword(password);

            password = "fter5fsd7575";
            val.validatorPassword(password);
//        } catch (RegexException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void testPassword() {
        try {
            password = "D$fsdf5sd6f5s67";
            val.validatorPassword(password);

            password = "$76576sdhfsdjF";
            val.validatorPassword(password);
//        
            password = "fsdf5sd6f5s67D#";
            val.validatorPassword(password);

            password = "#346785djfkhgE";
            val.validatorPassword(password);
        } catch (RegexException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test of validatorRegistry method, of class ValidationUser.
     *
     */
    @Test
    public void testValidatorRegistry() {
        try {
            registry = "111111";
            val.validatorRegistry(registry);

            registry = "000000";
            val.validatorRegistry(registry);

            registry = "345987";
            val.validatorRegistry(registry);
        } catch (RegexException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = RegexException.class)
    public void testValidatorRegistryException() throws RegexException {
//        try {
            registry = "11111";
            val.validatorRegistry(registry);

            registry = "aaa333";
            val.validatorRegistry(registry);

            registry = "a33333";
            val.validatorRegistry(registry);

            registry = "a33333";
            val.validatorRegistry(registry);

            registry = "33333a";
            val.validatorRegistry(registry);

            registry = "33333";
            val.validatorRegistry(registry);
//        } catch (RegexException e) {
//            e.printStackTrace();
//        }
    }

    public void testValidatorEmail() throws RegexException {
        try {
            
            email = "jair_anderson_bs@hotmail.com";
            val.validatorEmail(email);
            
            email = "jair_anderson_bs@hotmail@hotmail.com";
            val.validatorEmail(email);
            
            email = "jair_anderson_bs@.com";
            val.validatorEmail(email);
            
            email = "jair_anderson_bs@com";
            val.validatorEmail(email);
        } catch (RegexException e) {
            e.printStackTrace();
        }
    }

}
