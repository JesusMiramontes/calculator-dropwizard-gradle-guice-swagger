/* (C) 2021 */
package com.miramontes.modules;

import com.miramontes.CalculatorHealthCheck;
import config.CalculatorConfiguration;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;

public class CalculatorModule extends DropwizardAwareModule<CalculatorConfiguration> {
    @Override
    protected void configure() {
        bind(CalculatorHealthCheck.class);
    }
}
