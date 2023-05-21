@echo on
set JAVA_FILE=dhruvsheaven
set CLASSPATH=C:\Users\gadym\OneDrive\Desktop\MrStealYourJob\stealyojob\src\main\resources\projects\dhruvsheaven\dhruvsheaven.java
javac %JAVA_FILE%.java
if %errorlevel% equ 0 (
    echo compiled!!
    java -cp %CLASSPATH% %JAVA_FILE%
) else (
    echo no compile
cmd /k)