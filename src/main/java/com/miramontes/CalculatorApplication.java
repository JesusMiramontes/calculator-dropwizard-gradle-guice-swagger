/* (C) 2021 */
package com.miramontes;

import com.miramontes.config.CalculatorConfiguration;
import com.miramontes.modules.CalculatorModule;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class CalculatorApplication extends Application<CalculatorConfiguration> {
    @Override
    public void run(CalculatorConfiguration configuration, Environment environment)
            throws Exception {
        environment
                .jersey()
                .register(new OpenApiResource().openApiConfiguration(getOpenApiConfiguration()));
    }

    public static void main(String[] args) throws Exception {
        new CalculatorApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<CalculatorConfiguration> bootstrap) {
        bootstrap.addBundle(
                GuiceBundle.builder()
                        .enableAutoConfig(getClass().getPackage().getName())
                        .modules(new CalculatorModule())
                        .build());

        bootstrap.addBundle(new AssetsBundle("/app", "/swagger", "index.html", "static"));
    }

    private SwaggerConfiguration getOpenApiConfiguration() {
        final OpenAPI openAPI = new OpenAPI();
        final Info info =
                new Info()
                        .title("Simple calculator api")
                        .description("Using Dropwizard, gradle, google guice, swagger, open api");
        openAPI.info(info);
        final List<Server> servers = Stream.of(new Server().url("/")).collect(Collectors.toList());
        openAPI.servers(servers);

        return new SwaggerConfiguration()
                .openAPI(openAPI)
                .prettyPrint(true)
                .resourcePackages(Stream.of("com.miramontes").collect(Collectors.toSet()));
    }
}
