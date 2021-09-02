package com.miramontes.modules;

import com.miramontes.CalculatorHealthCheck;
import com.miramontes.resources.CalculatorResource;
import config.CalculatorConfiguration;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;

public class CalculatorModule extends DropwizardAwareModule<CalculatorConfiguration> {
    @Override
    protected void configure() {
        bind(CalculatorHealthCheck.class);
    }
}
