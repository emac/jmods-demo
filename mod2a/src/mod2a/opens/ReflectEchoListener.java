package mod2a.opens;

import mod3.exports.IEventListener;

/**
 * @author Emac
 * @since 2020-05-30
 */
public class ReflectEchoListener implements IEventListener<String> {

    @Override
    public void onEvent(String event) {
        System.out.println("[reflect echo] Event received: " + event);
    }
}
