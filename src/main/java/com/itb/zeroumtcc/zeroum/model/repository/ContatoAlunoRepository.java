package model.repository;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface ContatoAlunoRepository {
    boolean existsById(Integer id);

    List<com.zeroum.estagios.model.entity.ContatoAluno> findAll();

    Optional<com.zeroum.estagios.model.entity.ContatoAluno> findById(Integer id);

    com.zeroum.estagios.model.entity.ContatoAluno save(com.zeroum.estagios.model.entity.@Valid ContatoAluno contato);

    void deleteById(Integer id);import com.zeroum.estagios.model.entity.ContatoAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface ContatoAlunoRepository extends JpaRepository<ContatoAluno, Integer> {
        com.zeroum.estagios.model.entity.ContatoAluno save(com.zeroum.estagios.model.entity.@Valid ContatoAluno contato);

        boolean existsById(Integer id);

        void deleteById(Integer id);

        Optional<com.zeroum.estagios.model.entity.ContatoAluno> findById(Integer id);

        List<com.zeroum.estagios.model.entity.ContatoAluno> findAll();
    }
}
