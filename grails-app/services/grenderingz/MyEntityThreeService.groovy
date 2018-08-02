package grenderingz

import grails.gorm.services.Service

@Service(MyEntityThree)
interface MyEntityThreeService {

    MyEntityThree get(Serializable id)

    List<MyEntityThree> list(Map args)

    Long count()

    void delete(Serializable id)

    MyEntityThree save(MyEntityThree myEntityThree)

}