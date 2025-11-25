@echo off
REM Script de ejecución para el Proyecto de Programación 3
REM Windows

echo =========================================
echo   Evaluador de Expresiones Aritméticas
echo =========================================
echo.

REM Verificar que exista el directorio bin
if not exist "bin" (
    echo Error: No se encontró el directorio bin
    echo Por favor ejecuta primero: compile.bat
    pause
    exit /b 1
)

REM Ejecutar la aplicación
java -cp bin Main
