# Dash

[![Build Status](https://travis-ci.org/mburgosh/dash.svg?branch=master)](https://travis-ci.org/mburgosh/dash)

Inspired by Lodash (https://lodash.com/), but the capital version.

*API router*: Dash's API simply route you to the underlying utility libraries, or help you create simple collections. It is not meant to replace these libraries, it just gives easy access to common operations.

Relying on tried and proved libraries:
* Guava (https://github.com/google/guava)
* StreamEx (https://github.com/amaembo/streamex)
* Apache Commons Lang 3.0 (https://commons.apache.org/proper/commons-lang/index.html)

## Dash usage

```Java
import com.burgosh.dash.Dash;

class UsageDash {
    List<String> hiThere = Dash.list.of("hi", "there");
    
    Map<String, Sting> airportLocations = Dash.map.of(
        "OSL", "Oslo, Norway",
        "LPB", "La Paz, Bolivia",
        "AMS", "Amsterdam, Netherlands",
        "CDG", "Paris, France"
    );
}
```

## Poet usage

```Java
import com.burgosh.dash.Dash;
import com.burgosh.poet.Poet;

import java.util.List;
import java.util.Set;

class UsagePoet {
    List<String> hello = Poet.in("Now in Oslo!")
                             .replace("Oslo")
                             .with("New York");
    
    Set<String>          desired  = Dash.set.of("one", "two", "three", "four");
    Set<String>          current  = Dash.set.of("four", "five");
    ImmutableSet<String> toAdd    = Poet.giveAllIn(desired).notIn(current);
    ImmutableSet<String> toKeep   = Poet.giveAllIn(desired).alsoIn(current);
    ImmutableSet<String> toRemove = Poet.giveAllNotIn(desired).butIn(current);
}
```

## License
[MIT](https://choosealicense.com/licenses/mit/)
