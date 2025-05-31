package rbgord.com.dieta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rbgord.com.dieta.model.Alimento;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {

}
