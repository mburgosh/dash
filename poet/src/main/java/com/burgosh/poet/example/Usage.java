package com.burgosh.poet.example;

import com.burgosh.dash.Dash;
import com.burgosh.poet.Poet;
import com.google.common.collect.ImmutableSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class Usage {
    private static final Logger log = LoggerFactory.getLogger(Usage.class);

    public boolean strings() {
        boolean doesIt;
        boolean isIt;

        doesIt = Poet.does("Some string").startWith("Some");
        log.info("Does it? {}", doesIt);

        doesIt = Poet.does("Some string").endWith("string");
        log.info("Does it? {}", doesIt);

        doesIt = Poet.does("Some string").contain("e s");
        log.info("Does it? {}", doesIt);

        isIt = Poet.is("Some string").blank();
        log.info("Is it? {}", isIt);
        isIt = Poet.is(Dash.list.of("Some", "strings")).empty();
        log.info("Is it? {}", isIt);

        log.info(
                Poet.in("Now in Oslo!")
                    .replace("Oslo")
                    .with("New York")
        );

        Set<String> desired = Dash.set.of("one", "two", "three", "four");
        Set<String> current = Dash.set.of("four", "five");
        ImmutableSet<String> toAdd = Poet.giveAllIn(desired).notIn(current);
        ImmutableSet<String> toKeep = Poet.giveAllIn(desired).alsoIn(current);
        ImmutableSet<String> toRemove = Poet.giveAllNotIn(desired).butIn(current);

        log.info("current: {}", current);
        log.info("desired: {}", desired);
        log.info("to add: {}", toAdd);
        log.info("to remove: {}", toRemove);
        log.info("to keep: {}", toKeep);

        return true;
    }
}
