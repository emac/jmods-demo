package mod1;

import mod2a.exports.EchoListener;
import mod3.exports.IEventListener;
import mod4.Events;

import java.util.ArrayList;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

/**
 * @author Emac
 * @since 2020-05-30
 */
public class EventCenter {

    public static void main(String[] args) throws ReflectiveOperationException {
        System.out.println("Demo: Direct Mode");
        var listeners = new ArrayList<IEventListener>();
        listeners.add(new EchoListener());
        // compile error: listeners.add(new ReflectEchoListener());
        listeners.add((IEventListener<String>) Class.forName("mod2a.opens.ReflectEchoListener").getDeclaredConstructor().newInstance());
        var event = Events.newEvent();
        listeners.forEach(l -> l.onEvent(event));
        System.out.println();

        System.out.println("Demo: SPI Mode");
        var listeners2 = ServiceLoader.load(IEventListener.class).stream().map(ServiceLoader.Provider::get).collect(Collectors.toList());
        // compile error: listeners.add(new InternalEchoListener());
        // compile error: listeners.add(new SpiEchoListener());
        var event2 = Events.newEvent();
        listeners2.forEach(l -> l.onEvent(event2));
    }
}
