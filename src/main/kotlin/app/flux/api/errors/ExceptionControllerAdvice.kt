package app.flux.api.errors

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.support.WebExchangeBindException
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler
import org.springframework.web.server.ServerWebInputException

@ControllerAdvice
class ExceptionControllerAdvice {
  @ExceptionHandler(value = [WebExchangeBindException::class])
  fun handleWebExchangeBindException(exception: WebExchangeBindException): ResponseEntity<List<FieldError>> {
    // TODO: Create Error Class
    val errors = exception.bindingResult.fieldErrors

    return ResponseEntity(errors, HttpStatus.UNPROCESSABLE_ENTITY)
  }

  @ExceptionHandler(value = [ServerWebInputException::class])
  fun handleServerWebInputException(exception: ServerWebInputException): ResponseEntity<Void> {
    println(exception.javaClass)

    return ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY)
  }
}
