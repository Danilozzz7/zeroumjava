package model.repository;

public interface UsuarioRepository {
    List<com.zeroum.estagios.model.entity.Usuario> findAll();import com.zeroum.estagios.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {}
}
