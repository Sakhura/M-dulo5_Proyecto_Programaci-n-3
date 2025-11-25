# 🧮 Evaluador de Expresiones Aritméticas
### Proyecto de Programación 3 - Parte A | CSE205

[![Java](https://img.shields.io/badge/Java-8+-orange.svg)](https://www.oracle.com/java/)
[![Estado](https://img.shields.io/badge/Estado-Completo-success.svg)]()
[![Pruebas](https://img.shields.io/badge/Pruebas-12%2F12-brightgreen.svg)]()

---

## 📋 Descripción

Evaluador de expresiones aritméticas desarrollado en Java que implementa el **algoritmo de Shunting Yard** para convertir expresiones en notación infija a notación postfija y evaluarlas correctamente respetando la precedencia de operadores.

### ✨ Características Principales

- ✅ Evaluación de expresiones con operadores: `+`, `-`, `*`, `/`
- ✅ Soporte completo para paréntesis (incluyendo anidados)
- ✅ Respeto de precedencia de operadores matemáticos
- ✅ Interfaz gráfica intuitiva con Java Swing
- ✅ Sistema de pruebas automatizado (12 casos de prueba)
- ✅ Manejo de números decimales
- ✅ Arquitectura orientada a objetos extensible

---

## 🎯 Ejemplo de Uso

```java
Entrada:  "( 2 + 3 ) * 4"
Salida:   20.0

Entrada:  "10 + 2 * ( 6 - 4 )"
Salida:   14.0

Entrada:  "100 / 10 + 50 - 20 * 2"
Salida:   20.0
```

**⚠️ Importante:** Los elementos deben estar separados por espacios: `3 + 4` ✓ | `3+4` ✗

---

## 📁 Estructura del Proyecto

```
proyecto_programacion3/
│
├── 📄 README.md                    ← Este archivo
├── 📄 INFORME.md                   ← Informe del proyecto
├── 📄 GUIA_RAPIDA.md              ← Guía de inicio rápido
├── 📄 EJEMPLOS.md                 ← Casos de prueba
├── 📄 RESUMEN_EJECUTIVO.md        ← Resumen del proyecto
│
├── 📂 src/                         ← Código fuente
│   ├── Token.java                 ← Clase base para tokens
│   ├── Operand.java               ← Representa números
│   ├── Operator.java              ← Clase base de operadores
│   ├── BinaryOperator.java        ← Operadores binarios
│   ├── AddOperator.java           ← Operador suma (+)
│   ├── SubOperator.java           ← Operador resta (-)
│   ├── MultOperator.java          ← Operador multiplicación (*)
│   ├── DivOperator.java           ← Operador división (/)
│   ├── NegOperator.java           ← Operador negación unario
│   ├── Parenthesis.java           ← Paréntesis
│   ├── Stack.java                 ← Estructura de datos pila
│   ├── Expression.java            ← Motor del evaluador
│   ├── View.java                  ← Interfaz gráfica
│   ├── Main.java                  ← Punto de entrada
│   └── TestExpression.java        ← Pruebas unitarias
│
└── 🔧 Scripts
    ├── compile.sh                 ← Compilación (Linux/Mac)
    ├── compile.bat                ← Compilación (Windows)
    ├── run.sh                     ← Ejecución (Linux/Mac)
    └── run.bat                    ← Ejecución (Windows)
```

---

## 🚀 Inicio Rápido

### Prerrequisitos

- Java JDK 8 o superior
- NetBeans 7.4+ (recomendado) o cualquier IDE Java
- Terminal/Consola (para compilación manual)

### Opción 1: Usando NetBeans (Recomendado)

1. Abre NetBeans
2. `File → Open Project`
3. Selecciona la carpeta `proyecto_programacion3`
4. Presiona `F6` para ejecutar

### Opción 2: Línea de Comandos

#### Linux/Mac
```bash
# Dar permisos de ejecución
chmod +x compile.sh run.sh

# Compilar
./compile.sh

# Ejecutar interfaz gráfica
./run.sh

# Ejecutar pruebas
java -cp bin TestExpression
```

#### Windows
```cmd
# Compilar
compile.bat

# Ejecutar interfaz gráfica
run.bat

# Ejecutar pruebas
java -cp bin TestExpression
```

#### Compilación Manual
```bash
# Compilar
javac -d bin src/*.java

# Ejecutar
java -cp bin Main

# Pruebas
java -cp bin TestExpression
```

---

## 🎮 Cómo Usar la Aplicación

1. **Iniciar:** Ejecuta `Main.java` o `View.java`
2. **Ingresar expresión:** Escribe en el campo de texto (ej: `3 + 4 * 2`)
3. **Evaluar:** Click en "Evaluate" o presiona `Enter`
4. **Ver resultado:** Aparece un diálogo con el resultado
5. **Limpiar:** Click en "Clear" para nueva expresión
6. **Salir:** Click en "Exit"

### Ejemplos Válidos

```
Operaciones básicas:
3 + 5           → 8.0
10 - 3          → 7.0
4 * 6           → 24.0
20 / 4          → 5.0

Con precedencia:
2 + 3 * 4       → 14.0
20 / 4 + 3      → 8.0

Con paréntesis:
( 2 + 3 ) * 4   → 20.0
( ( 5 + 3 ) * 2 ) / 4  → 4.0

Decimales:
3.5 + 2.5       → 6.0
10.5 / 2.5      → 4.2
```

---

## 🏗️ Arquitectura del Software

### Jerarquía de Clases

```
Token (abstracta)
├── Operand (números)
├── Operator (abstracta)
│   ├── BinaryOperator (abstracta)
│   │   ├── AddOperator (+)
│   │   ├── SubOperator (-)
│   │   ├── MultOperator (*)
│   │   └── DivOperator (/)
│   └── NegOperator (~)
└── Parenthesis (paréntesis)
```

### Componentes Principales

| Componente | Descripción |
|------------|-------------|
| **Token** | Clase base abstracta para todos los elementos |
| **Operand** | Representa números (operandos) |
| **Operator** | Base para operadores, define precedencia |
| **BinaryOperator** | Operadores binarios (+, -, *, /) |
| **Stack** | Pila genérica (LIFO) |
| **Expression** | Motor del evaluador (Shunting Yard) |
| **View** | Interfaz gráfica con Swing |

---

## 🧮 Algoritmo: Shunting Yard

### Precedencia de Operadores

| Operador | Precedencia | Asociatividad |
|----------|-------------|---------------|
| `~` (neg) | 4 (mayor) | Derecha |
| `*`, `/` | 3 | Izquierda |
| `+`, `-` | 2 (menor) | Izquierda |

### Proceso de Evaluación

#### 1️⃣ Tokenización
```
Input:  "3 + 4 * 2"
Output: [Operand(3), AddOperator, Operand(4), MultOperator, Operand(2)]
```

#### 2️⃣ Conversión Infija → Postfija
```
Infija:   3 + 4 * 2
Postfija: 3 4 2 * +
```

**Algoritmo:**
```
Para cada token:
    Si es número → agregar a salida
    Si es operador → 
        mientras (precedencia_pila >= precedencia_actual):
            desapilar a salida
        apilar operador
    Si es '(' → apilar
    Si es ')' → desapilar hasta encontrar '('
```

#### 3️⃣ Evaluación Postfija
```
Pila: []
Lee 3 → Apila: [3]
Lee 4 → Apila: [3, 4]
Lee 2 → Apila: [3, 4, 2]
Lee * → 4*2=8, Apila: [3, 8]
Lee + → 3+8=11, Apila: [11]
Resultado: 11
```

---

## 🧪 Sistema de Pruebas

### Ejecutar Pruebas

```bash
java -cp bin TestExpression
```

### Casos de Prueba (12 totales)

| # | Expresión | Resultado Esperado | Estado |
|---|-----------|-------------------|--------|
| 1 | `3 + 5` | 8.0 | ✅ |
| 2 | `10 - 3` | 7.0 | ✅ |
| 3 | `4 * 6` | 24.0 | ✅ |
| 4 | `20 / 4` | 5.0 | ✅ |
| 5 | `2 + 3 * 4` | 14.0 | ✅ |
| 6 | `20 / 4 + 3` | 8.0 | ✅ |
| 7 | `( 2 + 3 ) * 4` | 20.0 | ✅ |
| 8 | `10 + 2 * ( 6 - 4 )` | 14.0 | ✅ |
| 9 | `100 / 10 + 50 - 20 * 2` | 20.0 | ✅ |
| 10 | `( ( 5 + 3 ) * 2 ) / 4` | 4.0 | ✅ |
| 11 | `3.5 + 2.5` | 6.0 | ✅ |
| 12 | `1 + 2` | 3.0 | ✅ |

**Resultado: 12/12 (100%) ✅**

---

## ⚠️ Casos de Error Comunes

### Sin espacios
```
❌ Incorrecto: 3+5
✅ Correcto:   3 + 5
```

### Paréntesis desbalanceados
```
❌ ( 3 + 5
❌ 3 + 5 )
✅ ( 3 + 5 )
```

### Operadores consecutivos
```
❌ 3 + + 5
❌ 10 * / 2
✅ 3 + 5
```

---

## 🛠️ Solución de Problemas

### El código no compila

**Problema:** `javac no reconocido`

**Solución:**
```bash
# Verificar instalación de Java
java -version
javac -version

# Si no están instalados, descargar JDK
# https://www.oracle.com/java/technologies/downloads/
```

### Las pruebas fallan

**Problema:** Algunas pruebas no pasan

**Soluciones:**
1. Verifica que no hayas modificado archivos críticos
2. Recompila todo el proyecto
3. Revisa que haya espacios en las expresiones

### La interfaz no aparece

**Problema:** Ventana no se muestra

**Soluciones:**
1. Verifica que estés ejecutando `Main.java` o `View.java`
2. Revisa errores en la consola
3. Prueba ejecutar desde NetBeans

---

## 📊 Criterios de Evaluación

| Criterio | Puntos | Descripción |
|----------|--------|-------------|
| **Funcionalidad** | 36 | Programa compila y funciona correctamente |
| **Pruebas** | 30 | Todas las pruebas automatizadas pasan |
| **Documentación** | 21 | JavaDoc completo + informe detallado |
| **Código** | 9 | Limpio, ordenado, sin warnings |
| **Entrega** | 9 | Antes del 25 Nov 2025, 23:59 |
| **TOTAL** | **105** | |

---

## 👥 Equipo de Desarrollo

Este proyecto fue desarrollado por:

- **Andrés Perot** - a.perotquevedo@uandresbello.edu
- **Rodrigo Yáñez** - r.yaezsepulveda@uandresbello.edu
- **Lorenzo Chacano** - l.chacanomuoz@uandresbello.edu
- **Natalia San Miguel** - n.sanmiguelcornejo@uandresbello.edu
- **Sabina Romero** - s.romerorodriguez1@uandresbello.cl

---

## 📚 Referencias

- [Algoritmo Shunting Yard - Wikipedia](https://en.wikipedia.org/wiki/Shunting-yard_algorithm)
- [Notación Polaca Inversa](https://es.wikipedia.org/wiki/Notación_polaca_inversa)
- [Java Swing Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/)
- Material del curso CSE205 - UNAB

---

## 📝 Documentación Adicional

Para más información, consulta:

- 📄 `INFORME.md` - Informe completo del proyecto
- 📄 `GUIA_RAPIDA.md` - Guía de inicio rápido
- 📄 `EJEMPLOS.md` - 50+ casos de prueba
- 📄 `RESUMEN_EJECUTIVO.md` - Resumen ejecutivo

---

## 📅 Información del Proyecto

- **Curso:** CSE205 - Programación 3
- **Institución:** Universidad Andrés Bello (UNAB)
- **Fecha:** Noviembre 2025
- **Versión:** 3.2
- **Licencia:** Académico - UNAB

---

## ✅ Checklist de Verificación

Antes de entregar, verifica:

- [x] El proyecto compila sin errores
- [x] Las 12 pruebas automatizadas pasan
- [x] La interfaz gráfica funciona correctamente
- [x] Todos los archivos están incluidos
- [x] JavaDoc completo en todas las clases
- [x] INFORME.md está completo
- [x] README.md está actualizado
- [x] Código sin warnings
- [x] Expresiones de ejemplo funcionan

---

## 🎓 Notas Finales

Este proyecto implementa de manera exitosa un evaluador de expresiones aritméticas utilizando conceptos fundamentales de:

- ✅ Estructuras de datos (Pilas)
- ✅ Algoritmos de procesamiento de expresiones
- ✅ Programación orientada a objetos
- ✅ Interfaces gráficas en Java
- ✅ Diseño de software modular y extensible

---

**Última actualización:** 25 de Noviembre de 2025

**Estado del proyecto:** ✅ COMPLETO Y LISTO PARA ENTREGA

---

<div align="center">

**¡Gracias por revisar nuestro proyecto!** 🎉

</div>
