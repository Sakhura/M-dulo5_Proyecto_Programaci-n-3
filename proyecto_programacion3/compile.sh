#!/bin/bash

# Script de compilación para el Proyecto de Programación 3
# Linux/Mac

echo "========================================="
echo "  Compilando Proyecto de Programación 3"
echo "========================================="

# Crear directorio bin si no existe
if [ ! -d "bin" ]; then
    echo "Creando directorio bin..."
    mkdir bin
fi

# Compilar todos los archivos Java
echo "Compilando archivos Java..."
javac -d bin src/*.java

# Verificar si la compilación fue exitosa
if [ $? -eq 0 ]; then
    echo ""
    echo "✓ Compilación exitosa!"
    echo ""
    echo "Para ejecutar la aplicación, usa:"
    echo "  ./run.sh"
    echo ""
    echo "Para ejecutar las pruebas, usa:"
    echo "  java -cp bin TestExpression"
else
    echo ""
    echo "✗ Error en la compilación"
    exit 1
fi
