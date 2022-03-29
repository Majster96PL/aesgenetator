package pl.portfolio.aesgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.portfolio.aesgenerator.algorithm.AESAlgorithm;
import pl.portfolio.aesgenerator.json.JSONDocument;
import pl.portfolio.aesgenerator.model.AesService;

import java.util.Scanner;

@SpringBootApplication
public class AesGeneratorApplication {

	private static AesService aesService;
	private static JSONDocument jsonDocument;

	public AesGeneratorApplication(AesService aesService) {
		AesGeneratorApplication.aesService = aesService;

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
		System.out.println();
		System.out.println("Decrypting text?");
		String answer = scanner.nextLine();
		if(answer.equals("Tak") | answer.equals("TAK")){
			String deccryptedString = AESAlgorithm.decrypt(stringToEncrypt);
			System.out.println(deccryptedString);
		}else{
			scanner.close();
		}
	}
}