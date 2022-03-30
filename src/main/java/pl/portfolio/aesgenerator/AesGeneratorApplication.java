package pl.portfolio.aesgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.portfolio.aesgenerator.model.AesService;
import pl.portfolio.aesgenerator.ui.TextGUI;


@SpringBootApplication
public class AesGeneratorApplication {

	private static AesService aesService;

	public AesGeneratorApplication(AesService aesService) {
		AesGeneratorApplication.aesService = aesService;

	}

	public static void main(String[] args) {
		SpringApplication.run(AesGeneratorApplication.class, args);
		new TextGUI(aesService);
	}
}