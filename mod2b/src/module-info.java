import mod3.exports.IEventListener;

/**
 * @author Emac
 * @since 2020-05-30
 */
module mod2b {
    requires transitive mod3;
    provides IEventListener
            with mod2b.SpiEchoListener;
}