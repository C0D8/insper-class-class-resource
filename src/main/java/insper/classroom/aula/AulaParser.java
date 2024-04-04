package insper.classroom.aula;

import main.java.insper.classroom.aula.CreateAulaIn;

public class AulaParser {

    public static Aula to(CreateAulaIn in) {
        return Aula.builder()
                .email(in.email())
                .name(in.name())
                .password(in.password())
                .build();
    }

    public static CreateAulaOut to(Aula account) {
        return CreateAulaOut.builder()
                .id(account.id())
                .email(account.email())
                .name(account.name())
                .build();
    }

}