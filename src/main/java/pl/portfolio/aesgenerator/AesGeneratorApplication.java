package pl.portfolio.aesgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.portfolio.aesgenerator.algorithm.AESAlgorithm;
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
		System.out.println("AES Generator - Cipher generator");
		System.out.println("Enter text to encrypting: ");
		var scanner = new Scanner(System.in);
		String textToEncrypt = scanner.nextLine();
		String stringToEncrypt =
				String.valueOf(
						aesService.encrypt(textToEncrypt, AESAlgorithm.SECRET_KEY, AESAlgorithm.encrypt(textToEncrypt))
				);
		System.out.println("Encrypting text: " + stringToEncrypt);
	}

}
