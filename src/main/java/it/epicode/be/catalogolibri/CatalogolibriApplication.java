package it.epicode.be.catalogolibri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Catalogo Libri API", version = "v1", description = "Gestione Catalogo Libri con autorizzazione"))
public class CatalogolibriApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogolibriApplication.class, args);
	}

}
