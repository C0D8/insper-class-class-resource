package insper.classroom.account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AulaRepository extends CrudRepository<AulaModel, String>{

    // public Optional<AulaModel> findByEmailAndHash(String email, String hash);
    

}
