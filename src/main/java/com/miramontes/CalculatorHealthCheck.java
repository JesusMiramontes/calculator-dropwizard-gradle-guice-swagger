package com.miramontes;

import com.codahale.metrics.health.HealthCheck;
import com.miramontes.services.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vyarus.dropwizard.guice.module.installer.feature.health.NamedHealthCheck;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CalculatorHealthCheck extends NamedHealthCheck {

    private static final Logger LOG = LoggerFactory.getLogger(CalculatorHealthCheck.class);

    @Override
    protected Result check() throws Exception {
        LOG.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!HealthCheck triggered!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return Result.healthy();
    }

    @Override
    public String getName() {
        return "calculator";
    }
}
