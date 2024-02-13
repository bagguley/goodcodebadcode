package bagguley.goodcodebadcode.exceptions.messages;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GoodMessage {
    final static Logger logger = Logger.getGlobal();

    static final List<String> errors = List.of(
            "Username is null",
            "Could not contact server",
            "Division by zero"
    );

    public static void main(final String[] args) {
        try {
            doSomething();
        } catch (final MyException exception) {
            logger.log(Level.SEVERE, "Processing failed", exception);
            handleErrors(exception.getErrors());
        }
    }

    static void handleErrors(final List<String> errors) {
        // Handle errors
    }

    static void doSomething() {
        throw new MyException("Error processing data", errors);
    }

    static class MyException extends RuntimeException {
        private final List<String> errors;

        MyException(final String message, final List<String> errors) {
            super(message);
            this.errors = List.copyOf(errors);
        }

        List<String> getErrors() {
            return errors;
        }
    }
}
