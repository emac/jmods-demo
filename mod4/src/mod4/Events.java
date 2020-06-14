package mod4;

import java.util.UUID;

/**
 * @author Emac
 * @since 2020-05-30
 */
public class Events {

    public static String newEvent() {
        return UUID.randomUUID().toString();
    }
}
