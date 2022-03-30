package pl.portfolio.aesgenerator.model;

import org.junit.jupiter.api.Test;
import pl.portfolio.aesgenerator.algorithm.AESAlgorithm;


class AesServiceTest {

    private static String encryptedText;

    @Test
    void encrypt() {
        String text = "test";
        encryptedText = AESAlgorithm.encrypt(text);
        System.out.println(encryptedText);
    }

    @Test
    void decrypt() {
        String decryptedText = AESAlgorithm.decrypt(encryptedText);
        System.out.println(decryptedText);
    }
}