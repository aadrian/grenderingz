package grenderingz

class MyEntityThree {
    String name
    String notes
    Date   publishDate

    static constraints = {
        name        nullable: false, blank: false, unique: true
        notes       nullable: true
        publishDate nullable: true
    }

    @Override
    String toString() {
        name
    }
}
