package app.flux.api.errors

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.support.WebExchangeBindException
import org.springframework.web.server.ServerWebInputException

@ControllerAdvice
class ExceptionControllerAdvice {
    @ExceptionHandler(value = [WebExchangeBindException::class])
    fun handleWebExchangeBindException(
        exception: WebExchangeBindException,
    ): ResponseEntity<List<FieldError>> {
        // TODO: Create Error Class
        val errors = exception.bindingResult.fieldErrors
        log.info("[ExceptionControllerAdvice] WebExchangeBindException: exception=$exception")

        return ResponseEntity(errors, HttpStatus.UNPROCESSABLE_ENTITY)
    }

    @ExceptionHandler(value = [ServerWebInputException::class])
    fun handleServerWebInputException(exception: ServerWebInputException): ResponseEntity<Void> {
        log.info("[ExceptionControllerAdvice] ServerWebInputException: exception=$exception")

        return ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY)
    }

    @ExceptionHandler(value = [HttpMessageNotReadableException::class])
    fun handleHttpMessageNotReadableException(exception: HttpMessageNotReadableException): ResponseEntity<Void> {
        log.info("[ExceptionControllerAdvice] HttpMessageNotReadableException: exception=$exception")

        return ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY)
    }

    companion object {
        private val log = LoggerFactory.getLogger(ExceptionControllerAdvice::class.java)
    }
}
