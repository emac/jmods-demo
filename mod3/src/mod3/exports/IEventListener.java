package mod3.exports;

/**
 * @author Emac
 * @since 2020-05-30
 */
public interface IEventListener<T> {

    void onEvent(T event);
}
