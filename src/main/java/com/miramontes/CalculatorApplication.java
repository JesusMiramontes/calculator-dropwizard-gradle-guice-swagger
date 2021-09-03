/* (C) 2021 */
package com.miramontes;

import com.miramontes.modules.CalculatorModule;
import config.CalculatorConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class CalculatorApplication extends Application<CalculatorConfiguration> {
    @Override
    public void run(CalculatorConfiguration configuration, Environment environment)
            throws Exception {}

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
    }
}
