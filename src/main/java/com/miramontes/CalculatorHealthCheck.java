/* (C) 2021 */
package com.miramontes;

import javax.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vyarus.dropwizard.guice.module.installer.feature.health.NamedHealthCheck;

@Singleton
public class CalculatorHealthCheck extends NamedHealthCheck {

    private static final Logger LOG = LoggerFactory.getLogger(CalculatorHealthCheck.class);

    @Override
    protected Result check() throws Exception {
        LOG.info(
                "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!HealthCheck triggered!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return Result.healthy();
    }

    @Override
    public String getName() {
        return "calculator";
    }
}
