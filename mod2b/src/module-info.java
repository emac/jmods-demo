/**
 * @author Emac
 * @since 2020-05-30
 */
module mod2b {
    requires transitive mod3;
    provides mod3.IEventListener
            with mod2b.SpiEchoListener;
}