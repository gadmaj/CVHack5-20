@echo on
set JAVA_FILE=funtimes
set CLASSPATH=C:\Users\gadym\OneDrive\Desktop\MrStealYourJob\stealyojob\src\main\resources\projects\funtimes\
javac %JAVA_FILE%.java
if %errorlevel% equ 0 (
    echo compiled!!
    java -cp %CLASSPATH% %JAVA_FILE%
) else (
    echo no compile
)cmd /k