package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.*;

@Configuration
public class AppCtx {
    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegSvc() {
        return new MemberRegisterService(memberDao()); // 회원가입 동작 Class에 MemberDao Class를 주입
    }

    @Bean
    public ChangePasswordService changePwdSvc() {
        ChangePasswordService pwdSvc = new ChangePasswordService();
        pwdSvc.setMemberDao(memberDao()); // setter 메서드를 통해 MemberDao Class를 주입
        return pwdSvc;
    }

    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

    @Bean
    public MemberListPrinter listPrinter() {
        return new MemberListPrinter(memberDao(), memberPrinter());
    }

    @Bean
    public MemberInfoPrinter infoPrinter() {
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        infoPrinter.setMemberDao(memberDao());
        infoPrinter.setPrinter(memberPrinter());
        return infoPrinter;
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
}
