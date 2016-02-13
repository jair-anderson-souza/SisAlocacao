/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com> <jair_anderson_bs@hotmail.com>
 * @since 01:34:42, 13-Feb-2016 
 * Package io.github.jass2125.sistema.alocacao.core.commands
 * Project Name Sistema-Alocacao
 * Encoding UTF-8
 * File Name CryptographyPassword.java
 */
public interface CryptographyPasswordStrategy {
    
    public String cryptographerSHA(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException ;
    
        
}
