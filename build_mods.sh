#!/bin/zsh

# mod4
javac -d out/mods/mod4 mod4/src/**/*.java
jar -cvf out/mods/mod4.jar -C out/mods/mod4 .

# mod3
javac -d out/mods/mod3 mod3/src/**/*.java
jar -cvf out/mods/mod3.jar -C out/mods/mod3 .

# mod2b
javac -p out/mods/mod3.jar -d out/mods/mod2b mod2b/src/**/*.java
jar -cvf out/mods/mod2b.jar -C out/mods/mod2b .

# mod2a
javac -p out/mods/mod3.jar -d out/mods/mod2a mod2a/src/**/*.java
jar -cvf out/mods/mod2a.jar -C out/mods/mod2a .

# mod1
javac -p out/mods/mod2a.jar:out/mods/mod2b.jar:out/mods/mod3.jar:out/mods/mod4.jar -d out/mods/mod1 mod1/src/**/*.java
jar -cvf out/mods/mod1.jar -C out/mods/mod1 .

# run
java -p out/mods/mod1.jar:out/mods/mod2a.jar:out/mods/mod2b.jar:out/mods/mod3.jar:out/mods/mod4.jar -m mod1/mod1.EventCenter
