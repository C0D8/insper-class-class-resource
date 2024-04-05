package insper.classroom.aula;

// import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AulaResource implements AulaController {

    @Autowired
    private AulaService aulaService;

    // @GetMapping("/accounts/info")
    // public ResponseEntity<Map<String, String>> info() {
    //     return new ResponseEntity<Map<String, String>>(
    //             Map.ofEntries(
    //                     Map.entry("microservice.name", AccountApplication.class.getSimpleName()),
    //                     Map.entry("os.arch", System.getProperty("os.arch")),
    //                     Map.entry("os.name", System.getProperty("os.name")),
    //                     Map.entry("os.version", System.getProperty("os.version")),
    //                     Map.entry("file.separator", System.getProperty("file.separator")),
    //                     Map.entry("java.class.path", System.getProperty("java.class.path")),
    //                     Map.entry("java.home", System.getProperty("java.home")),
    //                     Map.entry("java.vendor", System.getProperty("java.vendor")),
    //                     Map.entry("java.vendor.url", System.getProperty("java.vendor.url")),
    //                     Map.entry("java.version", System.getProperty("java.version")),
    //                     Map.entry("line.separator", System.getProperty("line.separator")),
    //                     Map.entry("path.separator", System.getProperty("path.separator")),
    //                     Map.entry("user.dir", System.getProperty("user.dir")),
    //                     Map.entry("user.home", System.getProperty("user.home")),
    //                     Map.entry("user.name", System.getProperty("user.name")),
    //                     Map.entry("jar", new java.io.File(
    //                             AccountApplication.class.getProtectionDomain()
    //                                     .getCodeSource()
    //                                     .getLocation()
    //                                     .getPath()
    //                     ).toString())
    //             ), HttpStatus.OK
    //     );
    // }

    @Override
    public ResponseEntity<CreateAulaOut> create(CreateAulaIn in) {
        // parser
        Aula aula = AulaParser.to(in);
        // insert using service
        aula = aulaService.create(aula);
        // return
        return ResponseEntity.created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(aula.id())
                                .toUri())
                .body(AulaParser.to(aula));
    }

    @Override
    public ResponseEntity<Aula> get(String id) {
        Aula aula = aulaService.read(id);
        if (aula == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(aula);
    }


    // @Override
    // public ResponseEntity<AccountOut> update(String id, AccountIn in) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'update'");
    // }

    // @Override
    // public ResponseEntity<AccountOut> auth(AuthIn in) {
    //     Account account = aulaService.auth(in.email(), in.password());
    //     if (account == null) {
    //         return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    //     }
    //     return ResponseEntity.ok(AccountParser.to(account));
    // }

    // @Override
    // public ResponseEntity<AccountOut> read(String idUser, String roleUser) {
    //     final AccountOut account = AccountOut.builder()
    //         .id(idUser)
    //         .name(roleUser)
    //         .build();
    //     return ResponseEntity.ok(account);
    // }
    
}