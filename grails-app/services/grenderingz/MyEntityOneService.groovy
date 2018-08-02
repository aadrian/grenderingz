package grenderingz

import grails.gorm.services.Service

@Service(MyEntityOne)
interface MyEntityOneService {

    MyEntityOne get(Serializable id)

    List<MyEntityOne> list(Map args)

    Long count()

    void delete(Serializable id)

    MyEntityOne save(MyEntityOne myEntityOne)

}