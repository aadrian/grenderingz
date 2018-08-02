package grenderingz

import grails.converters.JSON

class MyEntityOneController {
    static scaffold = MyEntityOne

    def indexj(){
        def result = [:]
        def c = MyEntityOne.createCriteria()
        def found = c.list(params)
        result.put("draw",1)
        result.put("count",found.size())
        result.put("data",found)
        render(result as JSON)
    }
}
