package study.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing
@SpringBootApplication
//스프링부트를 사용하지 않으면 곹옹 인터페이스를 만들어 주기 위해 해당 어노테이션을 설정해줘야한다.
//@EnableJpaRepositories(basePackages = "study.datajpa.repository")
public class DataJpaApplication {

    @Autowired
    DataSource datasource;

    public static void main(String[] args) {
        SpringApplication.run(DataJpaApplication.class, args);

    }

    @Bean
    public AuditorAware<String> auditorProvider() {
        // 일단 UUID를 랜덤으로 넣는다. 람다식. 인터페이스 내 메소드가 하나이면 람다로 표현 가능
        return () -> Optional.of(UUID.randomUUID().toString());

        // 기본 문법은
//		return new AuditorAware<String>() {
//			@Override
//			public Optional<String> getCurrentAuditor() {
//				return Optional.of(UUID.randomUUID().toString());
//			}
//		};

}

}
