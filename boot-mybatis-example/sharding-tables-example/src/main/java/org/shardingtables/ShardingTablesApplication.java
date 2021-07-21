package org.shardingtables;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;

@SpringBootApplication(exclude = {JtaAutoConfiguration.class})
public class ShardingTablesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingTablesApplication.class, args);
	}

}
