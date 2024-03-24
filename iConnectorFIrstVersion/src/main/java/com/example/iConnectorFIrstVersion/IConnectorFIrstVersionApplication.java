package com.example.iConnectorFIrstVersion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class IConnectorFIrstVersionApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {

		SpringApplication.run(IConnectorFIrstVersionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fetchData();
	}
	public void fetchData()
	{
		List<Map<String, Object>> yearCounts = jdbcTemplate.queryForList("SELECT YEAR(STSDATE) as year, COUNT(*) AS county FROM ORDSTS GROUP BY YEAR(STSDATE)");
		for (Map<String, Object> row : yearCounts) {
			System.out.println("Year: " + row.get("year") + ", Count: " + row.get("county"));
		}

	}
}
