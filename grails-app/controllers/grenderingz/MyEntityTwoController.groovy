package grenderingz

import grails.converters.JSON
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MyEntityTwoController {

    static scaffold = MyEntityTwo

    MyEntityTwoService myEntityTwoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond myEntityTwoService.list(params), model:[myEntityTwoCount: myEntityTwoService.count()]
    }

    def indexj(){
        def result = [:]
        def c = MyEntityTwo.createCriteria()
        def found = myEntityTwoService.list(params)
        result.put("draw",1)
        result.put("count",found.size())
        result.put("data",found)

        JSON.use('deep')
        render(result as JSON)
    }

    def show(Long id) {
        respond myEntityTwoService.get(id)
    }

    def create() {
        respond new MyEntityTwo(params)
    }

    def save(MyEntityTwo myEntityTwo) {
        if (myEntityTwo == null) {
            notFound()
            return
        }

        try {
            myEntityTwoService.save(myEntityTwo)
        } catch (ValidationException e) {
            respond myEntityTwo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'myEntityTwo.label', default: 'MyEntityTwo'), myEntityTwo.id])
                redirect myEntityTwo
            }
            '*' { respond myEntityTwo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond myEntityTwoService.get(id)
    }

    def update(MyEntityTwo myEntityTwo) {
        if (myEntityTwo == null) {
            notFound()
            return
        }

        try {
            myEntityTwoService.save(myEntityTwo)
        } catch (ValidationException e) {
            respond myEntityTwo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'myEntityTwo.label', default: 'MyEntityTwo'), myEntityTwo.id])
                redirect myEntityTwo
            }
            '*'{ respond myEntityTwo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        myEntityTwoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'myEntityTwo.label', default: 'MyEntityTwo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'myEntityTwo.label', default: 'MyEntityTwo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
