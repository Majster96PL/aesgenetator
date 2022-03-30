package pl.portfolio.aesgenerator.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.portfolio.aesgenerator.algorithm.AESAlgorithm;

@Service
@AllArgsConstructor
public class AesService{

    private final AesRepository aesRepository;


    public Aes encrypt(String text, String key, String encodeText){
        String stringToEncrypt = AESAlgorithm.encrypt(encodeText);
        var aes = new Aes(text, key, stringToEncrypt );
        System.out.println("Encrypting text: " + stringToEncrypt);
        return aesRepository.save(aes);
    }

    public String decrypt(String decodeText){
        return AESAlgorithm.decrypt(decodeText);
    }
}
