package mod3;

/**
 * @author Emac
 * @since 2020-05-30
 */
public interface IEventListener<T> {

    void onEvent(T event);
}
