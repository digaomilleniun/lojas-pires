/**
 * 
 */
package br.com.rpires.lojaspirespedidos.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Rodrigo Pires
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        StringBuilder titulo = new StringBuilder();
        titulo.append("PROJETO PROVA FÁCIL");
        StringBuilder versionSB = new StringBuilder();
        
        try {
            titulo.append("(");
            titulo.append(StringUtils.upperCase(""));
            titulo.append(")");
            versionSB.append("V-").append(1);
            
        } catch (Exception e) {
        }
        
        return new ApiInfoBuilder().title(titulo.toString()).description("Mapeamento dos Endpoints do projeto")
                .version(versionSB.toString()).termsOfServiceUrl("http://terms-of-services.url").license("LICENSE")
                .licenseUrl("http://url-to-license.com").build();
    }

}
