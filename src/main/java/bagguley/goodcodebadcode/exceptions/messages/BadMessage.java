package bagguley.goodcodebadcode.exceptions.messages;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BadMessage {
    final static Logger logger = Logger.getGlobal();

    final static List<String> errors = List.of(
            "Username is null",
            "Could not contact server",
            "Division by zero"
    );

    public static void main(final String[] args) {
        try {
            doSomething();
        } catch (final MyException exception) {
            logger.log(Level.SEVERE, "Processing failed", exception);
            handleErrors(exception.getMessage());
        }
    }

    static void handleErrors(final String errorJson) {
        // Handle errors
    }

    static void doSomething() {
        final ObjectMapper objectMapper = new ObjectMapper();

        final String message;
        try {
            message = objectMapper.writeValueAsString(errors);
        } catch (final JsonProcessingException exception) {
            throw new MyException("Unable to convert errors to JSON", exception);
        }

        throw new MyException(message);
    }

    static class MyException extends RuntimeException {
        MyException(final String message) {
            super(message);
        }

        MyException(final String message, final Exception exception) {
            super(message, exception);
        }
    }
}
