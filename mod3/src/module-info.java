import mod3.exports.IEventListener;

/**
 * @author Emac
 * @since 2020-05-30
 */
module mod3 {
    exports mod3.exports;
    provides IEventListener
            with mod3.internal.InternalEchoListener;
}