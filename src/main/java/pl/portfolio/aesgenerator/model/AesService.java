package pl.portfolio.aesgenerator.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AesService {

    private final AesRepository aesRepository;


}
