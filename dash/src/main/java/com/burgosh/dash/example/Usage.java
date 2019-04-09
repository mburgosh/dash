package com.burgosh.dash.example;

import com.burgosh.dash.Dash;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Usage {
    private static final Logger log = LoggerFactory.getLogger(Usage.class);

    Map<String, String> simple() {
        List<String> list = Dash.list.of("hi", "there");
        log.info("List: {}", list);

        Set<String> set = Dash.set.of("Just", "this", "this", "three");
        log.info("Set: {}", set);

        Map<String, String> map = Dash.map.of("key1", "value1", "ke2", "value2");
        log.info("Map: {}", map);

        ImmutableMap<String, Integer> immutableMap = Dash.map.ofFinal(
                "This", 1,
                "will", 2,
                "not", 3,
                "change!", 4
        );
        log.info("Immutable map: {}", immutableMap);

        String contents = Dash.io.resourceContents("example.json");
        log.info("Resource contents: {}", contents);

        List<Integer> wordLengths = Dash.stream(Dash.list.of("This", "is", "so", "easy"))
                                        .map(String::length)
                                        .toList();
        log.info("Word lengths: {}", wordLengths);

        log.info(
                "String blank tests: {}, {}, {}, {}, {}",
                Dash.string.isNotBlank(null),
                Dash.string.isNotBlank(""),
                Dash.string.isNotBlank(" "),
                Dash.string.isNotBlank("test"),
                Dash.string.isNotBlank(" test ")
        );

        LocalDateTime nowInOslo = LocalDateTime.now(ZoneId.of("Europe/Oslo"));
        LocalDateTime nowInNewYork = LocalDateTime.now(ZoneId.of("America/New_York"));
        Map<String, Long> hoursToMidnight = Dash.stream(
                Dash.map.ofEntries(
                        Dash.map.entry("Now in Oslo", nowInOslo),
                        Dash.map.entry("Now in New York", nowInNewYork)
                )
        ).mapValues(localNow -> {
            LocalDateTime localMidnight = LocalDateTime.of(localNow.toLocalDate().plusDays(1), LocalTime.MIDNIGHT);

            return localNow.until(localMidnight, ChronoUnit.HOURS);
        }).mapKeys(cityLabel -> Dash.string.replace("Now in")
                                           .with("Hours to midnight in")
                                           .in(cityLabel)
        ).toMap();
        log.info("Hours to midnight: {}", hoursToMidnight);

        return Dash.map.of("key1", "value1");
    }
}
