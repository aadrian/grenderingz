package grenderingz

import grails.gorm.services.Service

@Service(MyEntityTwo)
interface MyEntityTwoService {

    MyEntityTwo get(Serializable id)

    List<MyEntityTwo> list(Map args)

    Long count()

    void delete(Serializable id)

    MyEntityTwo save(MyEntityTwo myEntityTwo)

}