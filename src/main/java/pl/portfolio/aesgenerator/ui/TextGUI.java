package pl.portfolio.aesgenerator.ui;

import pl.portfolio.aesgenerator.algorithm.AESAlgorithm;
import pl.portfolio.aesgenerator.model.AesService;

import java.util.Scanner;


public class TextGUI {
    
    public TextGUI(AesService aesService) {
        System.out.println("AES Generator - Cipher generator");
        System.out.println("Enter text to encrypting: ");
        var scanner = new Scanner(System.in);
        String textToEncrypt = scanner.nextLine();
        String stringToEncrypt =
                String.valueOf(
                        aesService.encrypt(textToEncrypt, AESAlgorithm.SECRET_KEY, AESAlgorithm.encrypt(textToEncrypt))
                );
        System.out.println();
        System.out.println("Decrypting text?");
        String answer = scanner.nextLine();
        if(answer.equals("Tak") | answer.equals("TAK")){
            String deccryptedString = AESAlgorithm.decrypt(stringToEncrypt);
            System.out.println(deccryptedString);
            //JSONDocument.getJSON();
        }else{
            scanner.close();
        }
    }
}
