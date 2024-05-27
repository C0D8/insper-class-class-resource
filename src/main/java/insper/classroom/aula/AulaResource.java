package insper.classroom.aula;

// import org.hibernate.mapping.List;
import java.util.List;
import java.util.ArrayList;


// import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@Tag(name = "Aula Resource", description = "Aula Resource")
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
    @Operation(summary = "Create a new aula", description = "Create a new aula")
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
    @Operation(summary = "Get aula by id", description = "Get aula by id")
    public ResponseEntity<CreateAulaOut> get(String id) {

        System.out.println("Entrei no get");
        Aula aula = aulaService.read(id);
        if (aula == null) {
            return ResponseEntity.notFound().build();
        }


        System.out.println(aula.id());

        // devolver a aula 

        return ResponseEntity.ok(AulaParser.to(aula));
    }


    @Override
    @Operation(summary = "Get aula by departamento", description = "Get aula by departamento")
    public ResponseEntity<List<CreateAulaOut>> getByDepartamento(String id) {
       // lista de aulas por departamento
        List<Aula> aulas = aulaService.readByDepartamento(id);
        if (aulas == null) {
            return ResponseEntity.notFound().build();
        }

        List<CreateAulaOut> aulasOut = new ArrayList<>(); // Initialize aulasOut as an empty list

        for (Aula aula : aulas) {
            //append aula apos parsear 
            aulasOut.add(AulaParser.to(aula));
        }
        return ResponseEntity.ok(aulasOut);
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