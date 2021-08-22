package com.sac.foodorder.exception.handler;

import com.sac.foodorder.exception.DataNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Sachith Harshamal
 */
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
//
//    /**
//     * Handles DataNullException. Thrown when item data not available
//     *
//     * @param ex the DataNullException
//     * @return a {@code ResponseEntity} instance
//     */
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)   // 500
//    @ExceptionHandler(DataNullException.class)
//    public ResponseEntity<Object> handleDataNullException(DataNullException ex) {
//        String debugMessage = "Data not available";
//        return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), debugMessage);
//    }
//
//    /**
//     * common method to build the final response entity
//     *
//     * @param apiError api error object
//     * @return a {@code ResponseEntity} instance
//     */
//    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
//        return new ResponseEntity<>(apiError, apiError.getStatus());
//    }
//
//    /**
//     * common method to build the final response entity
//     *
//     * @param status  the selected response status
//     * @param message the selected response message
//     * @return a {@code ResponseEntity} instance
//     */
//    private ResponseEntity<Object> buildResponseEntity(HttpStatus status, String message, String debugMessage) {
//        ApiError apiError = new ApiError(status);
//        apiError.setMessage(message);
//        apiError.setDebugMessage(debugMessage);
//        return buildResponseEntity(apiError);
//    }
}
