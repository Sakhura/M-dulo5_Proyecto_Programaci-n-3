# 🎯 RESUMEN EJECUTIVO - PROYECTO PROGRAMACIÓN 3
## Todo lo que necesitas saber EN 5 MINUTOS

---

## 📦 ¿QUÉ ES ESTE PROYECTO?

Un **evaluador de expresiones aritméticas** que:
- Recibe: `3 + 4 * 2`
- Calcula: `11`
- Muestra el resultado en una ventana gráfica

---

## ⚡ LO MÁS IMPORTANTE (Lee esto primero)

### ✅ LO QUE DEBES HACER:

1. **Descargar el proyecto completo** (archivo ZIP)
2. **Dividir el trabajo** entre los 3 integrantes
3. **Compilar y probar** que todo funcione
4. **Personalizar el informe** con los nombres y aportes
5. **Entregar antes del 25 de noviembre**

### ❌ LO QUE NO DEBES HACER:

- No cambies la arquitectura básica (ya está optimizada)
- No elimines los comentarios (son parte de la documentación)
- No dejes todo para el último día
- No trabajes solo - es un proyecto de EQUIPO

---

## 📂 CONTENIDO DEL PROYECTO

El archivo `proyecto_programacion3.zip` incluye:

### Código Fuente (carpeta `src/`)
```
✓ Token.java              - Clase base para tokens
✓ Operand.java            - Números
✓ Operator.java           - Base para operadores
✓ BinaryOperator.java     - Operadores binarios
✓ AddOperator.java        - Suma (+)
✓ SubOperator.java        - Resta (-)
✓ MultOperator.java       - Multiplicación (*)
✓ DivOperator.java        - División (/)
✓ NegOperator.java        - Negación (-)
✓ Parenthesis.java        - Paréntesis
✓ Stack.java              - Pila (estructura de datos)
✓ Expression.java         - Núcleo del evaluador
✓ View.java               - Interfaz gráfica
✓ Main.java               - Punto de entrada
✓ TestExpression.java     - Pruebas automatizadas
```

### Documentación
```
✓ README.md               - Guía completa del proyecto
✓ INFORME.md              - Informe para entregar
✓ GUIA_RAPIDA.md          - Inicio rápido
✓ EJEMPLOS.md             - Ejemplos de uso
✓ RESUMEN_EJECUTIVO.md    - Este archivo
```

### Scripts
```
✓ compile.sh / compile.bat  - Compilar (Linux/Mac y Windows)
✓ run.sh / run.bat          - Ejecutar (Linux/Mac y Windows)
```

---

## 🚀 CÓMO EMPEZAR (3 opciones)

### Opción A: NetBeans (RECOMENDADO)
```
1. Descomprimir proyecto_programacion3.zip
2. Abrir NetBeans
3. File → Open Project
4. Seleccionar la carpeta proyecto_programacion3
5. Presionar F6 para ejecutar
```

### Opción B: Línea de Comandos (Linux/Mac)
```bash
unzip proyecto_programacion3.zip
cd proyecto_programacion3
./compile.sh
./run.sh
```

### Opción C: Línea de Comandos (Windows)
```cmd
# Descomprimir proyecto_programacion3.zip
cd proyecto_programacion3
compile.bat
run.bat
```

---

## 🧪 VERIFICAR QUE FUNCIONA

### Prueba 1: Compilación
```bash
./compile.sh    # o compile.bat en Windows
```
**Debe decir:** "✓ Compilación exitosa!"

### Prueba 2: Ejecutar Pruebas
```bash
java -cp bin TestExpression
```
**Debe decir:** "12/12 pruebas pasadas"

### Prueba 3: Interfaz Gráfica
```bash
./run.sh    # o run.bat en Windows
```
**Debe aparecer:** Una ventana con un campo de texto

### Prueba 4: Evaluar Expresión
- Escribe: `3 + 4 * 2`
- Click en "Evaluate"
- **Debe dar:** 14.0

---


## ✅ CHECKLIST DE ENTREGA

Antes de entregar, verifica:

- [x] Compiló sin errores
- [x] Las 12 pruebas automáticas pasan
- [x] La interfaz gráfica funciona
- [x] Evaluamos manualmente 5+ expresiones
- [x] Informe 
- [x] Aportes individuales descritos
- [x] Proceso de trabajo en equipo documentado
- [x] README revisado
- [x] Todo empaquetado en ZIP

---

## 🎯 CALIFICACIÓN (105 puntos totales)

| Criterio | Puntos | Cómo Obtenerlos |
|----------|--------|-----------------|
| **Calidad de la solución** | 36 | Código funciona perfectamente |
| **Pruebas y verificación** | 30 | Todas las pruebas pasan |
| **Documentación** | 21 | Informe completo y claro |
| **Sintaxis y orden** | 9 | Código limpio y comentado |
| **Entrega en plazo** | 9 | Antes del 25 Nov 23:59 |

**Meta:** 105/105 

---



## 🆘 EN CASO DE EMERGENCIA

### El código no compila:
```bash
# Verifica que tienes Java instalado
java -version
javac -version

# Reinstala si es necesario
```

### Las pruebas fallan:
1. Revisa que no hayas modificado archivos críticos
2. Vuelve a descargar el ZIP original
3. Compara con el original

### La interfaz no aparece:
1. Verifica que estés ejecutando `View.java` o `Main.java`
2. Revisa que no haya errores en la consola
3. Prueba en otro computador

### No hay tiempo:
1. Prioriza: Código funcionando > Documentación > Extras
2. Usa el informe ya proporcionado (INFORME.md)
3. Asegura que compile y pase las pruebas

---

## 📞 CONTACTOS

## Desarrollado por:
* Andrés Perot a.perotquevedo@uandresbello.edu
* Rodrigo Yañez r.yaezsepulveda@uandresbello.edu
* Lorenzo Chacano l.chacanomuoz@uandresbello.edu
* Natalia San Miguel n.sanmiguelcornejo@uandresbello.edu
* Sabina Romero s.romerorodriguez1@uandresbello.cl
---

**Creado por:** Sabina Romero
**Fecha:** 25 de Noviembre de 2025  
**Versión:** 3.2 
**Proyecto:** CSE205 - Programación 3 Parte A
