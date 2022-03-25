package pl.portfolio.aesgenerator;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.portfolio.aesgenerator.algorithm.AESAlgorithm;
import pl.portfolio.aesgenerator.model.AesRepository;
import pl.portfolio.aesgenerator.model.AesService;
import pl.portfolio.aesgenerator.ui.TextMain;

import java.util.Scanner;

@SpringBootApplication

public class AesGeneratorApplication {


     private static AesService aesService;

    public AesGeneratorApplication(AesService aesService) {
        AesGeneratorApplication.aesService= aesService;

    }

    public static void main(String[] args) {
		SpringApplication.run(AesGeneratorApplication.class, args);
        var scanner = new Scanner(System.in);
        System.out.println("Text to encrypting: ");
        String text = scanner.nextLine();
        String encryptedText = String.valueOf(aesService.encrypt(text, AESAlgorithm.SECRET_KEY,AESAlgorithm.encrypt(text)));
        System.out.println(encryptedText);
	}

}
