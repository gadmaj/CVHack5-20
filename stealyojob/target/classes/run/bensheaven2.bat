@echo on
set JAVA_FILE=bensheaven2
set CLASSPATH=C:\Users\gadym\OneDrive\Desktop\MrStealYourJob\stealyojob\src\main\resources\projects\bensheaven2\bensheaven2.java
javac %JAVA_FILE%.java
if %errorlevel% equ 0 (
    echo compiled!!
    java -cp %CLASSPATH% %JAVA_FILE%
) else (
    echo no compile
)