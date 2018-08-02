package grenderingz

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class MyEntityTwoSpec extends Specification implements DomainUnitTest<MyEntityTwo> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
