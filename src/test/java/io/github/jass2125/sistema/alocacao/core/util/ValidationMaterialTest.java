/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.util;

import io.github.jass2125.sistema.alocacao.core.business.Material;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anderson Souza
 */
public class ValidationMaterialTest {
    private ValidationMaterial val;
    public ValidationMaterialTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        val = new ValidationMaterial();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validateDescription method, of class ValidationMaterial.
     */
    @Test
    public void testValidateDescription() {
        String description = "descrição do material";
        boolean result = val.validateDescription(description);
        assertTrue(result);
        
        description = "descrição do material, maior que 50 caracteres validos";
        result = val.validateDescription(description);
        assertFalse(result);
        
        description = "Descrição qualquer do material";
        result = val.validateDescription(description);
        assertTrue(result);
        
        description = "Testando expressão regular que valida strings maiores que cinquenta caracteres, vamos ver agora se ela vai funcionar";
        result = val.validateDescription(description);
        assertFalse(result);
        
        description = "";
        result = val.validateDescription(description);
        assertFalse(result);
    }

    /**
     * Test of validate method, of class ValidationMaterial.
     */
    //@Test
    public void testValidate() {
        System.out.println("validate");
        String description = "";
        ValidationMaterial instance = new ValidationMaterial();
        boolean expResult = false;
        //boolean result = instance.validate(description);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateMaterial method, of class ValidationMaterial.
     */
    //@Test
    public void testValidateMaterial() {
        System.out.println("validateMaterial");
        Material material = null;
        ValidationMaterial instance = new ValidationMaterial();
        instance.validateMaterial(material);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
