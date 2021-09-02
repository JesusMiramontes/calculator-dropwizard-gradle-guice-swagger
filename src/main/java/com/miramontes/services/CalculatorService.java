package com.miramontes.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CalculatorService {

    public static Integer add(List<Integer> numbers){
        return
                numbers.stream()
                        .filter(Objects::nonNull)
                        .collect(
                                Collectors.summingInt(Integer::intValue)
                        );
    }

    public static Long subtract(List<Integer> numbers) {
        List<Integer> filtered =
                numbers
                        .stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList());
        if(filtered.isEmpty()){return 0l;}
        Integer start = filtered.remove(0);
        return filtered.stream().mapToLong(Integer::longValue).reduce(start, (a, b) -> a - b);
    }

    public static Long multiply(List<Integer> numbers) {
        List<Integer> filtered = numbers.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        if (filtered.isEmpty()) {
            return 0l;
        }
        return filtered.stream()
                .mapToLong(Integer::longValue)
                .reduce(1, (a, b) -> a * b);
    }

}
