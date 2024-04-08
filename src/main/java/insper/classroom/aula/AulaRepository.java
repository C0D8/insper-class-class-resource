package insper.classroom.aula;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AulaRepository extends CrudRepository<AulaModel, String>{

    // public Optional<AulaModel> findByEmailAndHash(String email, String hash);

    //devolver lista de aulas por departamento
    public List<AulaModel> findByDepartamento(String id_departamento);
    

}
