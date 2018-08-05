package grenderingz

class MyEntityOne {
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

    @Override
    String toString() {
        name
    }
}
