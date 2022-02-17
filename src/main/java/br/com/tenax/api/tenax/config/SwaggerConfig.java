package br.com.tenax.api.tenax.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("br.com.tenax.api.tenax.controller"))
            .paths( PathSelectors.any())
            .build()
            .useDefaultResponseMessages(true)
            .apiInfo(apiInfo());

            
    }


    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Tarefa Tenax")
                .description("Essa API foi desenvolvida para tarefa de processo seletivo da Tenax.\n"

                		+ "Desenvolvedor: Gilnei Lima dos Santos.\n\n"
                        + "Aconselhamos o seguinte passo a passo ao utilizar a API:\n"
                        + "Cadastrar um Servidor na seguinte ordem:\n"
                        + "1) Entre com Nome;\n"
                        + "2) Entre com Descricao do Servidor;\n")

                        .version("1.0.0")
                        .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0%22")
                .termsOfServiceUrl("/service.html")
                
                .build();
        return apiInfo;
    
    }
	
}
