package com.example.c0773839_w2020_mad3125_fp.Util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

/**
 * This class is to encrypt and validate the password
 */
public class PasswordUtil {
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;

    /**
     * Generate Salt value
     * @param length
     * @return
     */
    public static String getSalt(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }

    /**
     * Use password-based encryption to encrypt user password
     * @param password
     * @param salt
     * @return
     */
    public static byte[] getHash(char[] password, byte[] salt)
    {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try
        {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException e)
        {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        }
        finally
        {
            spec.clearPassword();
        }
    }

    /**
     * Generate the secured Password
     * @param password
     * @param salt
     * @return
     */
    public static String generateSecurePassword(String password, String salt)
    {
        String returnValue = null;
        byte[] securePassword = getHash(password.toCharArray(), salt.getBytes());

        //Encode secure user password into Base64
        returnValue = Base64.getEncoder().encodeToString(securePassword);

        return returnValue;
    }

    /**
     * Verify user Provided password
     * @param userPassword
     * @param securedPassword
     * @param salt
     * @return
     */
    public static boolean validatePassword(String userPassword,
                                           String securedPassword, String salt)
    {
        boolean returnValue = false;

        // Generate New secure password with the same salt
        String newSecurePassword = generateSecurePassword(userPassword, salt);

        // Check if two passwords are equal
        returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);

        return returnValue;
    }

}
