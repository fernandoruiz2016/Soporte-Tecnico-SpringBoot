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
    public OpenAPI soporteApiConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("Evaluación Parcial")
                        .description("Soporte Tecnico")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Grupo 6")
                                .email("iv73370044@idat.pe")
                                .url("https://github.com/fernandoruiz2016/Soporte-Tecnico-SpringBoot")
                        )
                        .license(new License()
                                .name("Proyectos IDAT")
                                .url("https://github.com/fernandoruiz2016/Soporte-Tecnico-SpringBoot")
                        )
                );
    }
}
