package mod2b;

import mod3.exports.IEventListener;

/**
 * @author Emac
 * @since 2020-05-30
 */
public class SpiEchoListener implements IEventListener<String> {

    @Override
    public void onEvent(String event) {
        System.out.println("[spi echo] Event received: " + event);
    }
}
