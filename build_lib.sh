#!/bin/sh

# mod4
javac -d out/lib/mod4 mod4/src/mod4/**/*.java
jar -cvf out/lib/mod4.jar -C out/lib/mod4 .

# mod3
javac -d out/lib/mod3 mod3/src/mod3/**/*.java
jar -cvf out/lib/mod3.jar -C out/lib/mod3 .

# mod2b
javac -cp out/lib/mod3.jar -d out/lib/mod2b mod2b/src/mod2b/**/*.java
jar -cvf out/lib/mod2b.jar -C out/lib/mod2b .

# mod2a
javac -cp out/lib/mod3.jar -d out/lib/mod2a mod2a/src/mod2a/**/*.java
jar -cvf out/lib/mod2a.jar -C out/lib/mod2a .

# mod1
javac -cp out/lib/mod2a.jar:out/lib/mod2b.jar:out/lib/mod3.jar:out/lib/mod4.jar -d out/lib/mod1 mod1/src/mod1/**/*.java
jar -cvf out/lib/mod1.jar -C out/lib/mod1 .

# run
java -cp "out/lib/*" mod1.EventCenter
