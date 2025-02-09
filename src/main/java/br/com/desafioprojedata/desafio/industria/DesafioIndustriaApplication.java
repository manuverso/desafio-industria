package br.com.desafioprojedata.desafio.industria;

import br.com.desafioprojedata.desafio.industria.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DesafioIndustriaApplication implements CommandLineRunner {

	@Autowired
	private Principal principal;

	public static void main(String[] args) {
		SpringApplication.run(DesafioIndustriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		principal.rodarOperacoes();
	}
}
