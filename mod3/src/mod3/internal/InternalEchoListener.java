package mod3.internal;

import mod3.exports.IEventListener;

/**
 * @author Emac
 * @since 2020-05-30
 */
public class InternalEchoListener implements IEventListener<String> {

    @Override
    public void onEvent(String event) {
        System.out.println("[internal echo] Event received: " + event);
    }
}
