package pl.portfolio.aesgenerator.algorithm;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class AESKey {

    public static void setKey(final String aesKey){
        try{
            byte[] key = aesKey.getBytes(StandardCharsets.UTF_8);
            var messageDigest = MessageDigest.getInstance("SHA-1");
            key = messageDigest.digest(key);
            key = Arrays.copyOf(key, 16);
            var keySpec = new SecretKeySpec(key, "AES");
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }
}
