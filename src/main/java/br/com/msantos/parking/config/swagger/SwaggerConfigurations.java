package br.com.msantos.parking.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.msantos.parking.models.Colaborador;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {

	@Bean
	public Docket parkingApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.msantos.parking"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.ignoredParameterTypes(Colaborador.class);
//				.globalOperationParameters(Arrays.asList(
//						new ParameterBuilder()
//						.name("Autorization")
//						.description("Header para token JWT")
//						.modelRef(new ModelRef("string"))
//						.parameterType("header")
//						.required(false)
//						.build()));
	}
}
