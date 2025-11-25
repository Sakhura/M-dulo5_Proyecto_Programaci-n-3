#!/bin/bash

# Script de ejecución para el Proyecto de Programación 3
# Linux/Mac

echo "========================================="
echo "  Evaluador de Expresiones Aritméticas"
echo "========================================="
echo ""

# Verificar que exista el directorio bin
if [ ! -d "bin" ]; then
    echo "Error: No se encontró el directorio bin"
    echo "Por favor ejecuta primero: ./compile.sh"
    exit 1
fi

# Ejecutar la aplicación
java -cp bin Main
