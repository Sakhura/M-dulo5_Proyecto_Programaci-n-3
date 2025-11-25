@echo off
REM Script de compilación para el Proyecto de Programación 3
REM Windows

echo =========================================
echo   Compilando Proyecto de Programación 3
echo =========================================

REM Crear directorio bin si no existe
if not exist "bin" (
    echo Creando directorio bin...
    mkdir bin
)

REM Compilar todos los archivos Java
echo Compilando archivos Java...
javac -d bin src\*.java

REM Verificar si la compilación fue exitosa
if %ERRORLEVEL% EQU 0 (
    echo.
    echo Compilación exitosa!
    echo.
    echo Para ejecutar la aplicación, usa:
    echo   run.bat
    echo.
    echo Para ejecutar las pruebas, usa:
    echo   java -cp bin TestExpression
) else (
    echo.
    echo Error en la compilación
    pause
    exit /b 1
)

pause
