# Proyecto de Programación 3 - Parte A
## Evaluador de Expresiones Aritméticas

### Descripción del Proyecto

Este proyecto implementa un evaluador de expresiones aritméticas en Java que puede procesar expresiones matemáticas en notación infija (la notación común que usamos los humanos) y calcular su resultado.

**Características:**
- Evaluación de expresiones con los operadores: +, -, *, /
- Soporte para paréntesis
- Interfaz gráfica de usuario (GUI) intuitiva
- Manejo de precedencia de operadores
- Algoritmo de Shunting Yard para conversión infija a postfija

---

## Estructura del Proyecto

```
proyecto_programacion3/
├── src/
│   ├── Token.java              # Clase base para todos los tokens
│   ├── Operand.java            # Representa números
│   ├── Operator.java           # Clase base para operadores
│   ├── BinaryOperator.java     # Operadores binarios (+, -, *, /)
│   ├── AddOperator.java        # Operador suma (+)
│   ├── SubOperator.java        # Operador resta (-)
│   ├── MultOperator.java       # Operador multiplicación (*)
│   ├── DivOperator.java        # Operador división (/)
│   ├── NegOperator.java        # Operador negación unario (-)
│   ├── Parenthesis.java        # Representa paréntesis
│   ├── Stack.java              # Estructura de datos pila
│   ├── Expression.java         # Núcleo del evaluador
│   ├── View.java               # Interfaz gráfica
│   ├── Main.java               # Punto de entrada
│   └── TestExpression.java     # Pruebas unitarias
├── README.md                   # Este archivo
├── compile.sh                  # Script de compilación (Linux/Mac)
├── compile.bat                 # Script de compilación (Windows)
├── run.sh                      # Script de ejecución (Linux/Mac)
└── run.bat                     # Script de ejecución (Windows)
```

---

## Cómo Funciona el Evaluador

### 1. Tokenización
La expresión se divide en tokens individuales:
```
Entrada: "3 + 4 * 2"
Tokens: [Operand(3), AddOperator, Operand(4), MultOperator, Operand(2)]
```

### 2. Conversión a Notación Postfija (Algoritmo Shunting Yard)
```
Infija:   3 + 4 * 2
Postfija: 3 4 2 * +
```

### 3. Evaluación de la Expresión Postfija
Usando una pila:
```
1. Lee 3 → Apila 3                    Pila: [3]
2. Lee 4 → Apila 4                    Pila: [3, 4]
3. Lee 2 → Apila 2                    Pila: [3, 4, 2]
4. Lee * → Desapila 2 y 4, calcula 4*2=8, apila 8    Pila: [3, 8]
5. Lee + → Desapila 8 y 3, calcula 3+8=11, apila 11  Pila: [11]
6. Resultado: 11
```

---

## Instrucciones de Compilación y Ejecución

### Opción 1: Usando NetBeans (Recomendado)

1. Abre NetBeans 
2. File → New Project → Java Application
3. Nombre del proyecto: "ProyectoProgramacion3"
4. Copia todos los archivos .java de la carpeta `src/` al paquete por defecto
5. Click derecho en el proyecto → Run

### Opción 2: Desde la Línea de Comandos

#### En Windows:
```bash
# Compilar
compile.bat

# Ejecutar la interfaz gráfica
run.bat

# Ejecutar las pruebas
java -cp bin TestExpression
```

#### En Linux/Mac:
```bash
# Compilar
chmod +x compile.sh
./compile.sh

# Ejecutar la interfaz gráfica
chmod +x run.sh
./run.sh

# Ejecutar las pruebas
java -cp bin TestExpression
```

#### Manualmente:
```bash
# Compilar
javac -d bin src/*.java

# Ejecutar
java -cp bin Main

# Ejecutar pruebas
java -cp bin TestExpression
```

---

## Uso de la Aplicación

1. **Iniciar la aplicación**: Ejecuta `Main.java` o `View.java`

2. **Ingresar expresión**: Escribe una expresión en el campo de texto
   - Ejemplo: `3 + 4 * 2`
   - **IMPORTANTE**: Separa cada elemento con espacios

3. **Evaluar**: Click en "Evaluate" o presiona Enter

4. **Ver resultado**: Aparecerá un diálogo con el resultado

5. **Limpiar**: Click en "Clear" para limpiar el campo

6. **Salir**: Click en "Exit" para cerrar

### Ejemplos de Expresiones Válidas:
```
1 + 2
10 - 5
3 * 4
20 / 4
2 + 3 * 4
( 2 + 3 ) * 4
10 + 2 * ( 6 - 4 )
3.5 + 2.5
```

### Reglas Importantes:
- Siempre **separa con espacios** cada número, operador y paréntesis
- Correcto: `3 + 4 * 2`
- Incorrecto: `3+4*2`

---

## Precedencia de Operadores

| Operador | Precedencia | Asociatividad |
|----------|-------------|---------------|
| ~(neg)   | 4 (mayor)   | Derecha       |
| *, /     | 3           | Izquierda     |
| +, -     | 2 (menor)   | Izquierda     |

---

## Ejecución de Pruebas

El archivo `TestExpression.java` contiene 12 pruebas automatizadas:

```bash
java -cp bin TestExpression
```

**Pruebas incluidas:**
1. Suma simple: `3 + 5 = 8`
2. Resta simple: `10 - 3 = 7`
3. Multiplicación: `4 * 6 = 24`
4. División: `20 / 4 = 5`
5. Precedencia: `2 + 3 * 4 = 14`
6. Precedencia con división: `20 / 4 + 3 = 8`
7. Paréntesis: `( 2 + 3 ) * 4 = 20`
8. Expresión compleja: `10 + 2 * ( 6 - 4 ) = 14`
9. Múltiples operaciones: `100 / 10 + 50 - 20 * 2 = 20`
10. Paréntesis anidados: `( ( 5 + 3 ) * 2 ) / 4 = 4`
11. Decimales: `3.5 + 2.5 = 6`
12. Ejemplo básico: `1 + 2 = 3`

---

## Arquitectura del Código

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

**Token**: Clase base abstracta para todos los elementos de una expresión

**Operand**: Representa un número (operando)

**Operator**: Clase base para operadores, define precedencia y evaluación

**BinaryOperator**: Operadores que requieren dos operandos

**Stack**: Implementación genérica de una pila (LIFO)

**Expression**: Núcleo del evaluador, implementa los algoritmos de conversión y evaluación

**View**: Interfaz gráfica de usuario usando Swing

---

## Algoritmo de Shunting Yard (Infija a Postfija)

```
Para cada token en la expresión infija:
    Si es un número:
        → Agregar a la salida
    
    Si es un operador:
        → Mientras haya operadores en la pila con mayor o igual precedencia:
            - Desapilar y agregar a la salida
        → Apilar el operador actual
    
    Si es paréntesis izquierdo '(':
        → Apilar
    
    Si es paréntesis derecho ')':
        → Desapilar hasta encontrar '('
        → Descartar ambos paréntesis

Al final:
    → Desapilar todos los operadores restantes a la salida
```

---

## Criterios de Evaluación (105 puntos)

- **Calidad de la solución** (36 pts): Funcionalidad completa y sin errores
- **Pruebas y verificación** (30 pts): Salida correcta con archivos de prueba
- **Documentación** (21 pts): Código bien comentado y explicado
- **Sintaxis y orden** (9 pts): Código limpio y estructurado
- **Entrega en plazo** (9 pts): Entrega antes del 25 de noviembre, 23:59

---

## Contribuciones del Equipo

### [Nombre del integrante 1]:
- [Descripción de su aporte]

### [Nombre del integrante 2]:
- [Descripción de su aporte]

### [Nombre del integrante 3]:
- [Descripción de su aporte]

---

## Proceso de Trabajo en Equipo

### Herramientas utilizadas:
- [WhatsApp/Discord/etc.] para comunicación
- [GitHub/Google Drive/etc.] para compartir código
- [Zoom/Teams/etc.] para reuniones

### Metodología:
1. Primera reunión: Análisis del problema y división de tareas
2. Desarrollo individual de componentes asignados
3. Reuniones de integración y pruebas
4. Revisión conjunta de documentación

---

## Problemas Encontrados y Soluciones

### Problema 1:
**Descripción**: [Describir problema]
**Solución**: [Cómo se resolvió]

### Problema 2:
**Descripción**: [Describir problema]
**Solución**: [Cómo se resolvió]

---

## Referencias

- Algoritmo Shunting Yard: https://en.wikipedia.org/wiki/Shunting-yard_algorithm
- Java Swing Tutorial: https://docs.oracle.com/javase/tutorial/uiswing/
- Estructuras de Datos en Java

---

## Licencia

Este proyecto es parte del curso CSE205 - UNAB

## Desarrollado por:
 * Andrés Perot a.perotquevedo@uandresbello.edu
 * Rodrigo Yañez r.yaezsepulveda@uandresbello.edu
 * Lorenzo Chacano l.chacanomuoz@uandresbello.edu
 * Natalia San Miguel n.sanmiguelcornejo@uandresbello.edu
 * Sabina Romero s.romerorodriguez1@uandresbello.cl

## Fecha: Noviembre 2025

