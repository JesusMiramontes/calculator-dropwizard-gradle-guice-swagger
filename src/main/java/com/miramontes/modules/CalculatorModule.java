/* (C) 2021 */
package com.miramontes.modules;

import com.google.inject.Provides;
import com.miramontes.CalculatorHealthCheck;
import com.miramontes.config.CalculatorConfiguration;
import com.miramontes.config.RedisConfiguration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;

public class CalculatorModule extends DropwizardAwareModule<CalculatorConfiguration> {
    @Override
    protected void configure() {
        bind(CalculatorHealthCheck.class);
    }

    @Provides
    public JedisPool provideJedisPool(CalculatorConfiguration applicationConfiguration) {
        RedisConfiguration redisConfig = applicationConfiguration.getRedis();
        return new JedisPool(
                new JedisPoolConfig(), redisConfig.getHostname(), redisConfig.getPort());
    }
}
