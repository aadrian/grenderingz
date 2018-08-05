package grenderingz

class MyEntityThree {
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

    @Override
    String toString() {
        name
    }
}
