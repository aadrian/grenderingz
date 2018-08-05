package grenderingz

import grails.plugins.orm.auditable.Auditable

class MyEntityThree implements Auditable {
    String name
    String notes
    Date   publishDate

    Date dateCreated
    Date lastUpdated

    static constraints = {
        name        nullable: false, blank: false, unique: true
        notes       nullable: true
        publishDate nullable: true

        dateCreated nullable: true
        lastUpdated nullable: true
    }

    static mapping = { autowire true}

    @Override
    String toString() { name }

    @Override Collection<String> getLogExcluded() { ['version', 'dateCreated', 'lastUpdated'] }  // audit plug-in new config
}
