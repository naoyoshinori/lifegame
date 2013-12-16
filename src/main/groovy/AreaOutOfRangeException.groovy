import groovy.util.logging.Slf4j

/**
 * Created by naoyuki on 2013/12/15.
 */
class AreaOutOfRangeException extends Exception {

    def AreaOutOfRangeException() {
        super("Area out of range.")
    }
}
