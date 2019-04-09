package com.burgosh.poet.example

import spock.lang.Specification

class UsageTest extends Specification {

    def "Expect all demo is shown"() {
        expect:
        new Usage().strings()
    }

}
