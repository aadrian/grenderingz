package grenderingz

import grails.converters.JSON
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MyEntityOneController {
    static scaffold = MyEntityOne

    MyEntityOneService myEntityOneService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond myEntityOneService.list(params), model:[myEntityOneCount: myEntityOneService.count()]
    }

    def indexj(){
        def result = [:]
        def c = MyEntityOne.createCriteria()
        def found = myEntityOneService.list(params)
        result.put("draw",1)
        result.put("count",found.size())
        result.put("data",found)

        JSON.use('deep')
        render(result as JSON)
    }

    def show(Long id) {
        respond myEntityOneService.get(id)
    }

    def create() {
        respond new MyEntityOne(params)
    }

    def save(MyEntityOne myEntityOne) {
        if (myEntityOne == null) {
            notFound()
            return
        }

        try {
            myEntityOneService.save(myEntityOne)
        } catch (ValidationException e) {
            respond myEntityOne.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'myEntityOne.label', default: 'MyEntityOne'), myEntityOne.id])
                redirect myEntityOne
            }
            '*' { respond myEntityOne, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond myEntityOneService.get(id)
    }

    def update(MyEntityOne myEntityOne) {
        if (myEntityOne == null) {
            notFound()
            return
        }

        try {
            myEntityOneService.save(myEntityOne)
        } catch (ValidationException e) {
            respond myEntityOne.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'myEntityOne.label', default: 'MyEntityOne'), myEntityOne.id])
                redirect myEntityOne
            }
            '*'{ respond myEntityOne, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        myEntityOneService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'myEntityOne.label', default: 'MyEntityOne'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'myEntityOne.label', default: 'MyEntityOne'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
