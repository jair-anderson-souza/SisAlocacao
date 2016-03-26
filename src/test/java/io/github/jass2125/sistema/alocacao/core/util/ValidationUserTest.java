/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.util;

import io.github.jass2125.sistema.alocacao.core.exceptions.FieldEmptyException;
import io.github.jass2125.sistema.alocacao.core.exceptions.RegexException;
import static org.junit.Assert.fail;
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
     * @throws RegexException
     * @throws FieldEmptyException
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

    @Test
    public void testValidandoUsername() throws RegexException, FieldEmptyException {
        String username = "jair.anderson";
        val.validatorUsername(username);

        username = "jairanderson.";
        val.validatorUsername(username);

        username = "2125";
        val.validatorUsername(username);

        username = ".jair";
        val.validatorUsername(username);

    }

    /**
     * Test of validatorPassword method, of class ValidationUser.
     *
     * 
     * @throws RegexException
     */
    @Test(expected = RegexException.class)
    public void testValidatorPassword() throws RegexException  {
        String password = "dfter5fsd7575";
        val.validatorPassword(password);

        password = "DHfter5fsd7575";
        val.validatorPassword(password);

        password = "#fter5fsd7575";
        val.validatorPassword(password);

        password = "fter5fsd7575";
        val.validatorPassword(password);

    }
    
    public void testPassword() throws RegexException{
//        String password = "D$fsdf5sd6f5s67";
//        val.validatorPassword(password);
//        
//        password = "$76576sdhfsdj";
//        val.validatorPassword(password);
//        
//        password = "fsdf5sd6f5s67D#";
//        val.validatorPassword(password);
//        
//        password = "#346785djfkhgE";
//        val.validatorPassword(password);
//        
//        password = "Dt5dd&";
//        val.validatorPassword(password);
        
        fail("Completar Teste");
        
    }
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
     * @throws io.github.jass2125.sistema.alocacao.core.exceptions.RegexException
     */
    @Test
    public void testValidatorRegistry() throws RegexException {
        String registry = "111111";
        val.validatorRegistry(registry);
    }
    
    @Test(expected = RegexException.class)
    public void testValidatorRegistryException() throws RegexException {
        String registry = "111111";
        val.validatorRegistry(registry);
        
        registry = "aaa333";
        val.validatorRegistry(registry);
        
        registry = "a33333";
        val.validatorRegistry(registry);
        
        registry = "a33333";
        val.validatorRegistry(registry);
        
        registry = "33333a";
        val.validatorRegistry(registry);
        
        
    }
    
    
}
