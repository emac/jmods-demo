
![](https://raw.githubusercontent.com/emac/jmods-demo/master/project-structure.png)

- mod1 模块: 主模块，展示了使用服务实现类的两种方式。
- mod2a 模块: 分别导出和开放了一个包，并声明了两个服务实现类。
- mod2b 模块: 声明了一个未公开的服务实现类。
- mod3 模块: 定义 SPI 服务（`IEventListener`），并声明了一个未公开的服务实现类。
- mod4 模块: 导出公共模型类。

先来看一下主函数，方式 1 展示了直接使用 mod2 导出和开放的两个 `IEventListener` 实现类，方式 2 展示了通过 Java SPI 机制使用所有的 `IEventListener` 实现类，无视其导出/开放与否。方式 2 相比 方式 1，多了两行输出，分别来自于 mod2b 和 mod3 通过 `provides` 关键词提供的服务实现类。

```java
public class EventCenter {

    public static void main(String[] args) throws ReflectiveOperationException {
        // 方式1：通过exports和opens
        System.out.println("Demo: Direct Mode");
        var listeners = new ArrayList<IEventListener>();
        // 使用导出类
        listeners.add(new EchoListener());
        // 使用开放类
        // compile error: listeners.add(new ReflectEchoListener());
        listeners.add((IEventListener<String>) Class.forName("mod2a.opens.ReflectEchoListener").getDeclaredConstructor().newInstance());
        var event = Events.newEvent();
        listeners.forEach(l -> l.onEvent(event));
        System.out.println();

        // 方式2：通过SPI
        System.out.println("Demo: SPI Mode");
        // 加载所有的IEventListener实现类，无视其导出/开放与否
        var listeners2 = ServiceLoader.load(IEventListener.class).stream().map(ServiceLoader.Provider::get).collect(Collectors.toList());
        // compile error: listeners.add(new InternalEchoListener());
        // compile error: listeners.add(new SpiEchoListener());
        var event2 = Events.newEvent();
        listeners2.forEach(l -> l.onEvent(event2));
    }
}
```

*代码-1: mod1.EventCenter.java*

命令行下执行`./build_mods.sh`，得到输出如下，结果和预期一致。

```java
Demo: Direct Mode
[echo] Event received: 68eb4671-c057-4bc2-9653-c31f5e3f72d2
[reflect echo] Event received: 68eb4671-c057-4bc2-9653-c31f5e3f72d2

Demo: SPI Mode
[spi echo] Event received: 678d239a-77ef-4b7f-b7aa-e76041fcdf47
[echo] Event received: 678d239a-77ef-4b7f-b7aa-e76041fcdf47
[reflect echo] Event received: 678d239a-77ef-4b7f-b7aa-e76041fcdf47
[internal echo] Event received: 678d239a-77ef-4b7f-b7aa-e76041fcdf47
```

*代码-2: EventCenter 结果输出*
