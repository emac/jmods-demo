/**
 * @author Emac
 * @since 2020-05-30
 */
module mod2a {
    requires transitive mod3;
    exports mod2a.exports;
    opens mod2a.opens;
    provides mod3.IEventListener
            with mod2a.exports.EchoListener, mod2a.opens.ReflectEchoListener;
}