

@echo on
set JAVA_FILE=thinking
set CLASSPATH=C:\Users\gadym\OneDrive\Desktop\MrStealYourJob\stealyojob\src\main\resources\projects\thinking\
javac %JAVA_FILE%.java
if %errorlevel% equ 0 (
    echo compiled!!
    java -cp %CLASSPATH% %JAVA_FILE%
) else (
    echo compilation failed
)
cmd /k