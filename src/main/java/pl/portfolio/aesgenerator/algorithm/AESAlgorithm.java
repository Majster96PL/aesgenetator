package pl.portfolio.aesgenerator.algorithm;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AESAlgorithm {

    public static final String SECRET_KEY = "no_idea_for_a_key";
    private static final String SALT_KEY = "have_idea_for_a_key";
    private static final Logger log = LoggerFactory.getLogger(AESAlgorithm.class);
    private static final byte[] bytesIV = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static String encrypt(String stringToEncrypt){
        try{
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bytesIV);
            var secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            var keySpec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT_KEY.getBytes(), 65536, 256);
            var secretKey = secretKeyFactory.generateSecret(keySpec);
            var secretSpecKey = new SecretKeySpec(secretKey.getEncoded(), "AES");
            var cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretSpecKey, ivParameterSpec);
            return Base64.getEncoder()
                    .encodeToString(cipher.doFinal(stringToEncrypt.getBytes(StandardCharsets.UTF_8)));
        }catch (Exception e){
            log.error("Error during encrypting: " + e);
        }
        return null;
    }

    public static String decrypt(String stringToDecrypt){
        try{
            var ivParameterSpec = new IvParameterSpec(bytesIV);
            var secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            var keySpec = new PBEKeySpec(SECRET_KEY.toCharArray(),SALT_KEY.getBytes(), 65536, 256);
            var secretKey=secretKeyFactory.generateSecret(keySpec);
            var secretSpecKey = new SecretKeySpec(secretKey.getEncoded(), "AES");
            var cipher = Cipher.getInstance("AES/CBC/PKC5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretSpecKey, ivParameterSpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(stringToDecrypt)));
        }catch(Exception e){
            log.error("Error during decrypting: " + e);
        }
        return null;
    }
}
