package idat.examen.proyecto.Examen.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI soporteApiConfig() { // 1. Agregados paréntesis ()
        return new OpenAPI()
                .info(new Info()
                        .title("Evaluación Parcial")
                        .description("Soporte Tecnico")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Grupo 6")
                                .email("iv73370044@idat.pe")
                                .url("http://eva.edu.pe/proyectos")
                        )
                        .license(new License()
                                .name("Proyectos IDAT")
                                .url("http://proyectos.pe")
                        )
                );
    }
}
