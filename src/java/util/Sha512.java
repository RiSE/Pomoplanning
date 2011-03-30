/**
*@ autores : Saulo de tarso Oliveira da Silva
*  29/03/2011
*/

package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha512 {
    public static String crypto(String string) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
 
            md.update(string.getBytes());
            byte[] mb = md.digest();
            String out = "";
            for (int i = 0; i < mb.length; i++) {
                byte temp = mb[i];
                String s = Integer.toHexString(new Byte(temp));
                while (s.length() < 2) {
                    s = "0" + s;
                }
                s = s.substring(s.length() - 2);
                out += s;
            }
            return out;
 
        } catch (NoSuchAlgorithmException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return null;
    }
}