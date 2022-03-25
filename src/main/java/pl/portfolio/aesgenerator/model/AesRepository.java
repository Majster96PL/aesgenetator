package pl.portfolio.aesgenerator.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AesRepository extends JpaRepository<Aes, Long> {

    Optional<Aes> findById(Long Id);
}
