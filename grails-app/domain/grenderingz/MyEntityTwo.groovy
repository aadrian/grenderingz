package grenderingz

class MyEntityTwo {
    String        title
    String        notes
    MyEntityThree three
    static constraints = {
        title nullable: false, blank: false, unique: true
        notes nullable: true
        three nullable: true
    }

    @Override
    String toString() {
        title
    }
}
