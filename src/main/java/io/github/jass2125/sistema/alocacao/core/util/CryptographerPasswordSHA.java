/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Anderson Souza
 * @since 01:35:45, 13-Feb-2016 
 * Package io.github.jass2125.sistema.alocacao.core.commands
 * Project Name Sistema-Alocacao
 * Encoding UTF-8
 * File Name CryptographyPasswordSHA.java
 */
public class CryptographerPasswordSHA implements CryptographyPasswordStrategy {

    public CryptographerPasswordSHA() {
    }

    @Override
    public String cryptographerSHA(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte passwordCryptgrapher[] = md.digest(password.getBytes("UTF-8"));
        
        StringBuilder builder = new StringBuilder();
        for (byte it : passwordCryptgrapher) {
            builder.append(String.format(String.format("%02X", 0xFF & it)));
        }
        return builder.toString();
    }
    
    

    
    
    
    
    
}
