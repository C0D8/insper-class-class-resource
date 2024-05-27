package insper.classroom.aula;

// import java.nio.charset.StandardCharsets;
// import java.security.MessageDigest;
// import java.security.NoSuchAlgorithmException;
// import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import lombok.NonNull;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    @CircuitBreaker(name = "aulaService", fallbackMethod = "fallbackAulaCreate")
    public Aula create(Aula in) {
        // in.hash(calculateHash(in.password()));
        // in.password(null);
        return aulaRepository.save(new AulaModel(in)).to();
    }

    public Aula fallbackAulaCreate(Aula in, Throwable t) {
        throw new RuntimeException("Failed to create aula", t);
    }

    @CircuitBreaker(name = "aulaService", fallbackMethod = "fallbackAulaRead")
    public Aula read(@NonNull String id) {
        return aulaRepository.findById(id).map(AulaModel::to).orElse(null);
    }

    public Aula fallbackAulaRead(String id, Throwable t) {
        throw new RuntimeException("Failed to read aula", t);
    }

    @CircuitBreaker(name = "aulaService", fallbackMethod = "fallbackAulaReadByDepartamento")
    public List<Aula> readByDepartamento(@NonNull String id_departamento) {
        return aulaRepository.findByDepartamento(id_departamento).stream().map(AulaModel::to).collect(Collectors.toList());
    }

    public List<Aula> fallbackAulaReadByDepartamento(String id_departamento, Throwable t) {
        throw new RuntimeException("Failed to read aula by departamento", t);
    }

    // public Account read(@NonNull String id) {
    //     return accountRepository.findById(id).map(AccountModel::to).orElse(null);
    // }

    // public Account auth(String email, String password) {
    //     String hash = calculateHash(password);
    //     return accountRepository.findByEmailAndHash(email, hash).map(AccountModel::to).orElse(null);
    // }

    // private String calculateHash(String text) {
    //     try {
    //         MessageDigest digest = MessageDigest.getInstance("SHA-256");
    //         byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
    //         byte[] encoded = Base64.getEncoder().encode(hash);
    //         return new String(encoded);
    //     } catch (NoSuchAlgorithmException e) {
    //         throw new RuntimeException(e);
    //     }
    // }

}