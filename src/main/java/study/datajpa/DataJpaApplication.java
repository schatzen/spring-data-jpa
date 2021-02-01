package study.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
//스프링부트를 사용하지 않으면 곹옹 인터페이스를 만들어 주기 위해 해당 어노테이션을 설정해줘야한다.
//@EnableJpaRepositories(basePackages = "study.datajpa.repository")
public class DataJpaApplication {


	@Autowired
	DataSource datasource;


	public static void main(String[] args) {
		SpringApplication.run(DataJpaApplication.class, args);
	}

}
