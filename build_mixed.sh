#!/bin/zsh

# mod4
javac -d out/mixed/mod4 mod4/src/**/*.java
jar -cvf out/mixed/mod4.jar -C out/mixed/mod4 .

# mod3
javac -d out/mixed/mod3 mod3/src/**/*.java
jar -cvf out/mixed/mod3.jar -C out/mixed/mod3 .

# mod2b
javac -p out/mixed/mod3.jar -d out/mixed/mod2b mod2b/src/**/*.java
jar -cvf out/mixed/mod2b.jar -C out/mixed/mod2b .

# mod2a
javac -p out/mixed/mod3.jar -d out/mixed/mod2a mod2a/src/**/*.java
jar -cvf out/mixed/mod2a.jar -C out/mixed/mod2a .

# mod1
javac -cp out/mixed/mod2a.jar:out/mixed/mod2b.jar:out/mixed/mod3.jar:out/mixed/mod4.jar -d out/mixed/mod1 mod1/src/mod1/**/*.java
jar -cvf out/mixed/mod1.jar -C out/mixed/mod1 .

# run
java -cp out/mixed/mod1.jar --upgrade-module-path out/mixed/mod2a.jar:out/mixed/mod2b.jar:out/mixed/mod3.jar:out/mixed/mod4.jar mod1.EventCenter
