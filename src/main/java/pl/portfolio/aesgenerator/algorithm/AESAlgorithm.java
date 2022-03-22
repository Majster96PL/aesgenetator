package pl.portfolio.aesgenerator.algorithm;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AESAlgorithm {

    private static SecretKeySpec keySpec;

    public static String encrypt(final String stringToEnrypt, final String secretKey){
        try{
            AESKey.setKey(secretKey);
            var cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            return Base64.getEncoder()
                    .encodeToString(cipher.doFinal(stringToEnrypt.getBytes(StandardCharsets.UTF_8)));
        }catch (Exception e){
            System.out.println("Erorr during encrypting: " + e);
        }
        return null;
    }

    public static String decrypt(final String stringToDecrypt, final String secret){
        try{
            AESKey.setKey(secret);
            var cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            return new String(cipher.doFinal(Base64.getDecoder()
                    .decode(stringToDecrypt)));
        }catch(Exception e){
            System.out.println("Error during decrypting: " + e);
        }
        return null;
    }
}
