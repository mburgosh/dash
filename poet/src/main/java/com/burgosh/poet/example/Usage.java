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

        log.info(
                "Is it? {}, {}, {}, {}",
                Poet.is("").blank(),
                Poet.is(" ").blank(),
                Poet.is("test").notBlank(),
                Poet.is(" test ").notBlank(),
                Poet.is(Dash.list.of("Some", "strings")).notEmpty(),
                Poet.is(Dash.list.of()).empty()
        );

        log.info(
                Poet.replace("Monday")
                    .with("Friday")
                    .in("Gotta get down on Monday!")
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
