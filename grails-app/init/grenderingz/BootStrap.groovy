package grenderingz

import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
        MyEntityThree met1 = new MyEntityThree(name: "met name 1", publishDate: new Date()).save(failOnError: true)
        MyEntityThree met2 = new MyEntityThree(name: "met name 2", publishDate: new Date()).save(failOnError: true)
        MyEntityThree met3 = new MyEntityThree(name: "met name 3", publishDate: new Date()).save(failOnError: true)

        MyEntityTwo  meto1 = new MyEntityTwo(title: "meto title 1", three: met1).save(failOnError:true)
        MyEntityTwo  meto2 = new MyEntityTwo(title: "meto title 2", three: met2).save(failOnError:true)
        MyEntityTwo  meto3 = new MyEntityTwo(title: "meto title 3", three: met3).save(failOnError:true)
        MyEntityTwo  meto4 = new MyEntityTwo(title: "meto title 4"              ).save(failOnError:true)


        MyEntityOne meo1 = new MyEntityOne(name: "meo name 1", age: 42, two: meto1).save(failOnError:true)
        MyEntityOne meo2 = new MyEntityOne(name: "meo name 2", age: 52, two: meto2).save(failOnError:true)
        MyEntityOne meo3 = new MyEntityOne(name: "meo name 3", age: 62, two: meto3).save(failOnError:true)
        MyEntityOne meo4 = new MyEntityOne(name: "meo name 4", age: 72, two: meto4).save(failOnError:true)
        MyEntityOne meo5 = new MyEntityOne(name: "meo name 5", age: 82, active:true).save(failOnError:true)


/*
        JSON.registerObjectMarshaller(MyEntityOne) { MyEntityOne one ->
            [
                    id:      one.id,
                    version: one.version,
                    name:    one.name,
                    active:  one.active,
                    two: [
                            id:     one.two?.id,
                            title:  one.two?.title,
                            notes:  one.two?.title,
                            three:  [
                                    id:          one.two?.three?.id,
                                    name:        one.two?.three?.name,
                                    notes:       one.two?.three?.notes,
                                    publishDate: one.two?.three?.publishDate
                            ]
                    ]
            ]
        }
*/
/*
        JSON.createNamedConfig( 'myDesiredApi' ) {
            it.registerObjectMarshaller(MyEntityThree) { MyEntityThree three ->
                [
                        id     : three.id,
                        name   : three.name,
                        notes  : three.notes,
                        publish: three.publishDate
                ]
            }

        }
*/
    }
    def destroy = {
    }
}
