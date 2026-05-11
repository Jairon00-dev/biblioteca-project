package biblioteca.backend.repository;

import biblioteca.backend.domain.model.Multa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultaRepository extends JpaRepository<Multa, Long> {
}