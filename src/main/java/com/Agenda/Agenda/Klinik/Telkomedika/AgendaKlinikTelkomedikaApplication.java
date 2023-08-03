package com.Agenda.Agenda.Klinik.Telkomedika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AgendaKlinikTelkomedikaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaKlinikTelkomedikaApplication.class, args);
	}

}
