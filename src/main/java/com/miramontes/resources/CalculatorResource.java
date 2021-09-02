package com.miramontes.resources;

import com.codahale.metrics.annotation.Timed;
import com.miramontes.services.CalculatorService;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Path("/")
@Singleton
@Produces(MediaType.TEXT_PLAIN)
public class CalculatorResource {

    @GET
    @Timed
    @Path("/add/{numbers:.*}")
    public Integer add(@PathParam("numbers") @DefaultValue("0") String numbers){
        return CalculatorService.add(parseNumbers(numbers));
    }

    private List<Integer> parseNumbers(String numbers) {
        try {
            List<Integer> parsed =
                    Arrays.stream(numbers.split("/"))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());
            return  parsed;
        }catch (Exception e){
            throw new BadRequestException(e);
        }
    }

    @GET
    @Timed
    @Path("/subtract/{numbers:.*}")
    public Long subtract(@PathParam("numbers") @DefaultValue("0") String numbers){
        return CalculatorService.subtract(parseNumbers(numbers));
    }

    @GET
    @Timed
    @Path("/multiply/{numbers:.*}")
    public Long multiply(@PathParam("numbers") @DefaultValue("0") String numbers){
        return CalculatorService.multiply(parseNumbers(numbers));
    }

}
