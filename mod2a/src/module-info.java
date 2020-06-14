import mod3.exports.IEventListener;

/**
 * @author Emac
 * @since 2020-05-30
 */
module mod2a {
    requires transitive mod3;
    exports mod2a.exports;
    opens mod2a.opens;
    provides IEventListener
            with mod2a.exports.EchoListener, mod2a.opens.ReflectEchoListener;
}