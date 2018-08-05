package grenderingz

import grails.plugins.orm.auditable.Auditable

class MyEntityOne implements Auditable {
    String      name
    Integer     age
    Boolean     active
    MyEntityTwo two


    Date dateCreated
    Date lastUpdated

    static constraints = {
        name    nullable: false, blank: false, unique: true
        age     nullable: true
        active  nullable: true
        two     nullable: true

        dateCreated nullable: true
        lastUpdated nullable: true
    }

    static mapping = { autowire true}

    @Override
    String toString() { name }

    @Override Collection<String> getLogExcluded() { ['version', 'dateCreated', 'lastUpdated'] }  // audit plug-in new config
}
