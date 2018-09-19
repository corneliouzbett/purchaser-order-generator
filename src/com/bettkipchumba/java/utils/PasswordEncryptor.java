
package com.bettkipchumba.java.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

/**
 *
 * @author bett kipchumba
 */
public class PasswordEncryptor {
/*    public static void main(String [] args){
        System.out.print(encryptPassword("admin"));
    }*/

    public static String encryptPassword(String passwordToBeEncrypted) {

        try {
            
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            
             byte[] hashedBytes = messageDigest.digest(passwordToBeEncrypted.getBytes());
            
            messageDigest.update(hashedBytes);
            
            StringBuilder stringBuilder = new StringBuilder();
            
            for(int i = 0;i<hashedBytes.length;i++){
                stringBuilder.append(Integer.toString((hashedBytes[i] & 0xff) + 0x100,32)).substring(1);
            }
            return stringBuilder.toString();
            
           
            
        } catch (NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(null,"Unable to encrypt password","Belisco Solutions Limited",JOptionPane.ERROR_MESSAGE);
            return "No Hashing";
        }
    }

}
