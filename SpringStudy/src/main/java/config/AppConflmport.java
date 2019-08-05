package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import spring.MemberDao;
import spring.MemberPrinter;

// AppConf2 설정 클래스도 함께 사용하기 떄문에 스프링 컨테이너를 생성할 때, AppConf2 설정 클래스를 지정할 필요가 없어진다.
// AppConfImport 클래스만 사용하면, AppCOnf2 클래스의 설정도 함께 사용해서 컨테이너를 초기화한다.
@Configuration
@Import(AppConf2.class)
public class AppConflmport {
    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }
}
