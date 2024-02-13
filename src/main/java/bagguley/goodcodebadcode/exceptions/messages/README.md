# Complex Exception Messages

Avoid complex exception messages. Store any extra information in properties when needed.
Never serialise information into the exception message, always use POJO properties, even if upstream
code deals with a serialised format.

* Performance
  * Serialising and de-serialising objects is costly
* Coupling
  * Serialising into a format because a caller uses it introduces tight coupling where there should be none
* Contract
  * The contract of the Throwable interface defines the message parameter as a "detail message" not data
* Extensibility
  * Adding properties to the serialised data could break clients, making it hard to extend the exception properties 
* Obscurity
  * It's not clear what is contained in the serialised data
* Separation of concerns
  * The code throwing the exception should not be concerned with what upstream serialisation may or may not be used
