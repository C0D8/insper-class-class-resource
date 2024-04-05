package insper.classroom.aula;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends CrudRepository<AulaModel, String>{

    // public Optional<AulaModel> findByEmailAndHash(String email, String hash);
    

}
