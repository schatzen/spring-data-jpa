package study.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class DataJpaApplication {


	@Autowired
	DataSource datasource;


	public static void main(String[] args) {
		SpringApplication.run(DataJpaApplication.class, args);
	}

}
