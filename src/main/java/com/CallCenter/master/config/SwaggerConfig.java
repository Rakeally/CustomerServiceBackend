package com.CallCenter.master.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.http.ResponseEntity;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer{

    @Bean
    public Docket eDesignApi(SwaggerConfigProperties swaggerConfigProperties) {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo(swaggerConfigProperties))
        	      .securityContexts(Arrays.asList(securityContext()))
        	      .securitySchemes(Arrays.asList(apiKey()))
        	      .select()
        	      .apis(RequestHandlerSelectors.any())
        	      .paths(PathSelectors.any())
        	      .build()
                .enable(Boolean.parseBoolean(swaggerConfigProperties.getEnabled())).select()
                .apis(RequestHandlerSelectors.basePackage("com.CallCenter.master.Controllers"))
                .paths(PathSelectors.any()).build().pathMapping("/").directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class).useDefaultResponseMessages(Boolean.parseBoolean(swaggerConfigProperties.getUseDefaultResponseMessages()))
                .enableUrlTemplating(Boolean.parseBoolean(swaggerConfigProperties.getEnableUrlTemplating()));
    }
    
    @SuppressWarnings("deprecation")
	@Bean
    SecurityConfiguration security() {
        return new SecurityConfiguration(null, null, null, // realm Needed for authenticate button to work
                null, // appName Needed for authenticate button to work
                "Bearer token", // apiKeyValue
                ApiKeyVehicle.HEADER, "Authorization", // apiKeyName
                null);
    }

    @Bean
    UiConfiguration uiConfig(SwaggerConfigProperties swaggerConfigProperties) {
        return UiConfigurationBuilder.builder().deepLinking(Boolean.valueOf(swaggerConfigProperties.getDeepLinking())).displayOperationId(Boolean.valueOf(swaggerConfigProperties.getDisplayOperationId()))
                .defaultModelsExpandDepth(Integer.valueOf(swaggerConfigProperties.getDefaultModelsExpandDepth())).defaultModelExpandDepth(Integer.valueOf(swaggerConfigProperties.getDefaultModelExpandDepth()))
                .defaultModelRendering(ModelRendering.EXAMPLE).displayRequestDuration(Boolean.valueOf(swaggerConfigProperties.getDisplayRequestDuration())).docExpansion(DocExpansion.NONE)
                .filter(Boolean.valueOf(swaggerConfigProperties.getFilter())).maxDisplayedTags(Integer.valueOf(swaggerConfigProperties.getMaxDisplayedTags())).operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(Boolean.valueOf(swaggerConfigProperties.getShowExtensions())).tagsSorter(TagsSorter.ALPHA)
                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS).validatorUrl(null).build();
    }

    private ApiInfo apiInfo(SwaggerConfigProperties swaggerConfigProperties) {
        return new ApiInfoBuilder().title(swaggerConfigProperties.getTitle()).description(swaggerConfigProperties.getDescription())
                .version(swaggerConfigProperties.getApiVersion()).build();
    }

    @Bean
    public LinkDiscoverers discoverers() {
        List<LinkDiscoverer> plugins = new ArrayList<>();
        plugins.add(new CollectionJsonLinkDiscoverer());
        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));

    }
    
    private ApiKey apiKey() { 
        return new ApiKey("JWT", "Authorization", "header"); 
    }
    
    private SecurityContext securityContext() { 
        return SecurityContext.builder().securityReferences(defaultAuth()).build(); 
    } 

    private List<SecurityReference> defaultAuth() { 
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
        authorizationScopes[0] = authorizationScope; 
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); 
    }
    
    
}