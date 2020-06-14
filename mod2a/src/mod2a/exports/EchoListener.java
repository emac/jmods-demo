package mod2a.exports;

import mod3.IEventListener;

/**
 * @author Emac
 * @since 2020-05-30
 */
public class EchoListener implements IEventListener<String> {

    @Override
    public void onEvent(String event) {
        System.out.println("[echo] Event received: " + event);
    }
}
