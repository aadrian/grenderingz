package grenderingz

import grails.plugins.orm.auditable.Auditable

class MyEntityTwo implements Auditable {
    String        title
    String        notes
    MyEntityThree three

    Date dateCreated
    Date lastUpdated

    static constraints = {
        title nullable: false, blank: false, unique: true
        notes nullable: true
        three nullable: true

        dateCreated nullable: true
        lastUpdated nullable: true
    }

    static mapping = { autowire true}

    @Override
    String toString() { title }

    @Override Collection<String> getLogExcluded() { ['version', 'dateCreated', 'lastUpdated'] }  // audit plug-in new config
}
