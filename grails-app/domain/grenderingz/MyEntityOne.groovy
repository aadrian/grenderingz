package grenderingz

class MyEntityOne {
    String      name
    Integer     age
    Boolean     active
    MyEntityTwo two

    static constraints = {
        name    nullable: false, blank: false, unique: true
        age     nullable: true
        active  nullable: true
        two     nullable: true
    }

    @Override
    String toString() {
        name
    }
}
