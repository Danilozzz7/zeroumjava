package model.repository;
import model.entity.Candidatura;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface CandidaturaRepository extends JpaRepository<Candidatura, Integer> {}

