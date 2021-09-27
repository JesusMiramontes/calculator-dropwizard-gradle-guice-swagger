/* (C) 2021 */
package com.miramontes.resources;

import com.codahale.metrics.annotation.Timed;
import com.miramontes.CalculatorApplication;
import com.miramontes.services.CalculatorService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Path("/")
@Singleton
@Produces(MediaType.TEXT_PLAIN)
public class CalculatorResource {

    private final Logger LOG = LoggerFactory.getLogger(CalculatorResource.class);

    @Inject private CalculatorService calculatorService;

    private final JedisPool jedisPool;

    @Inject
    public CalculatorResource(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @GET
    @Timed
    @Path("/add/{numbers:.*}")
    public Integer add(@PathParam("numbers") @DefaultValue("3/2/1") String numbers) {
        Jedis jedis = jedisPool.getResource();

        if (!jedis.exists("A" + numbers)) {
            jedis.set("A" + numbers, String.valueOf(calculatorService.add(parseNumbers(numbers))));
        }

        return Integer.parseInt(jedis.get("A" + numbers));
    }

    private List<Integer> parseNumbers(String numbers) {
        try {
            List<Integer> parsed =
                    Arrays.stream(numbers.split("/"))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());
            return parsed;
        } catch (Exception e) {
            throw new BadRequestException(e);
        }
    }

    @GET
    @Timed
    @Path("/subtract/{numbers:.*}")
    public Long subtract(@PathParam("numbers") @DefaultValue("8/2") String numbers) {
        Jedis jedis = jedisPool.getResource();

        if (!jedis.exists("S" + numbers)) {
            jedis.set(
                    "S" + numbers,
                    String.valueOf(calculatorService.subtract(parseNumbers(numbers))));
        }

        return Long.parseLong(jedis.get("S" + numbers));
    }

    @GET
    @Timed
    @Path("/multiply/{numbers:.*}")
    public Long multiply(@PathParam("numbers") @DefaultValue("3/2") String numbers) throws InterruptedException {
        Jedis jedis = jedisPool.getResource();

        if (!jedis.exists("M" + numbers)) {
            LOG.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^SLEEPING^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            Thread.sleep(5000);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 9999; i++) {
                stringBuilder.append("A");
                LOG.info(stringBuilder.toString());
            }
            jedis.set(
                    "M" + numbers,
                    String.valueOf(calculatorService.multiply(parseNumbers(numbers))));
        }

        return Long.parseLong(jedis.get("M" + numbers));
    }
}
