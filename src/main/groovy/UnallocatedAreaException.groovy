import groovy.util.logging.Slf4j

/**
 * Created by naoyuki on 2013/12/15.
 */
class UnallocatedAreaException extends Exception {

    def UnallocatedAreaException() {
        super("Unallocated area.")
    }
}
