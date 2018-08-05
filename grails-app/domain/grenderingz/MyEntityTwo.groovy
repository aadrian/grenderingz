package grenderingz

class MyEntityTwo {
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

    @Override
    String toString() {
        title
    }
}
