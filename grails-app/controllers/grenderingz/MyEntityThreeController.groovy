package grenderingz

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MyEntityThreeController {

    static scaffold = MyEntityThree

    MyEntityThreeService myEntityThreeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond myEntityThreeService.list(params), model:[myEntityThreeCount: myEntityThreeService.count()]
    }

    def show(Long id) {
        respond myEntityThreeService.get(id)
    }

    def create() {
        respond new MyEntityThree(params)
    }

    def save(MyEntityThree myEntityThree) {
        if (myEntityThree == null) {
            notFound()
            return
        }

        try {
            myEntityThreeService.save(myEntityThree)
        } catch (ValidationException e) {
            respond myEntityThree.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'myEntityThree.label', default: 'MyEntityThree'), myEntityThree.id])
                redirect myEntityThree
            }
            '*' { respond myEntityThree, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond myEntityThreeService.get(id)
    }

    def update(MyEntityThree myEntityThree) {
        if (myEntityThree == null) {
            notFound()
            return
        }

        try {
            myEntityThreeService.save(myEntityThree)
        } catch (ValidationException e) {
            respond myEntityThree.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'myEntityThree.label', default: 'MyEntityThree'), myEntityThree.id])
                redirect myEntityThree
            }
            '*'{ respond myEntityThree, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        myEntityThreeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'myEntityThree.label', default: 'MyEntityThree'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'myEntityThree.label', default: 'MyEntityThree'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
