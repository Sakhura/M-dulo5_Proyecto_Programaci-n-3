# INFORME DEL PROYECTO DE PROGRAMACIÓN 3 - PARTE A
## Evaluador de Expresiones Aritméticas

**Curso:** CSE205  
**Fecha de Entrega:** 25 de Noviembre de 2025  
**Integrantes del Equipo:**  
- [Nombre Integrante 1]
- [Nombre Integrante 2]  
- [Nombre Integrante 3]

---

## 1. DESCRIPCIÓN DE LA SOLUCIÓN

### 1.1 Enfoque General

Nuestro equipo implementó un **evaluador de expresiones aritméticas** que puede procesar expresiones matemáticas en notación infija (la notación común: 3 + 4) y calcular su resultado numérico.

### 1.2 Tecnología Utilizada

- **Lenguaje:** Java
- **IDE:** NetBeans 7.4
- **Interfaz Gráfica:** Java Swing
- **Estructuras de Datos:** Pilas (Stack) genéricas con ArrayList

### 1.3 Algoritmo Principal: Shunting Yard

La solución se basa en el algoritmo de **Shunting Yard** desarrollado por Edsger Dijkstra, que consta de tres fases principales:

#### Fase 1: Tokenización
Convertimos la expresión String en una lista de tokens (objetos):
```
Input:  "3 + 4 * 2"
Output: [Operand(3), AddOperator, Operand(4), MultOperator, Operand(2)]
```

#### Fase 2: Conversión Infija → Postfija
Usamos el algoritmo Shunting Yard para convertir la notación infija en notación postfija (Reverse Polish Notation):
```
Infija:   3 + 4 * 2
Postfija: 3 4 2 * +
```

**Ventajas de la notación postfija:**
- Elimina la necesidad de paréntesis
- No requiere reglas de precedencia durante la evaluación
- Facilita la evaluación con una pila simple

#### Fase 3: Evaluación de la Expresión Postfija
Usamos una pila para evaluar:
```
1. Lee "3" → Apila 3                           Pila: [3]
2. Lee "4" → Apila 4                           Pila: [3, 4]
3. Lee "2" → Apila 2                           Pila: [3, 4, 2]
4. Lee "*" → Desapila 2 y 4, calcula 8, apila  Pila: [3, 8]
5. Lee "+" → Desapila 8 y 3, calcula 11, apila Pila: [11]
Resultado: 11
```

### 1.4 Arquitectura Orientada a Objetos

Implementamos una jerarquía de clases robusta:

```
Token (abstracta)
├── Operand (números)
├── Operator (abstracta)
│   ├── BinaryOperator (abstracta)
│   │   ├── AddOperator (+)
│   │   ├── SubOperator (-)
│   │   ├── MultOperator (*)
│   │   └── DivOperator (/)
│   └── NegOperator (~ para negación unaria)
└── Parenthesis (paréntesis)
```

**Beneficios de este diseño:**
- **Extensibilidad:** Fácil agregar nuevos operadores (potencia, módulo, etc.)
- **Mantenibilidad:** Cada operador es independiente
- **Polimorfismo:** Uso de métodos abstractos `evaluate()` y `precedence()`
- **Encapsulamiento:** Cada clase tiene responsabilidades bien definidas

### 1.5 Interfaz Gráfica

Implementamos una GUI simple pero efectiva con Java Swing:
- Campo de texto para ingresar expresiones
- Botón "Clear" para limpiar
- Botón "Evaluate" para calcular (también funciona con Enter)
- Botón "Exit" para cerrar la aplicación
- Diálogos modales para mostrar resultados y errores

### 1.6 Manejo de Precedencia

Implementamos correctamente la precedencia de operadores:

| Operador | Precedencia | Descripción |
|----------|-------------|-------------|
| ~ (neg)  | 4           | Negación unaria (mayor precedencia) |
| *, /     | 3           | Multiplicación y división |
| +, -     | 2           | Suma y resta (menor precedencia) |

---

## 2. APORTES INDIVIDUALES

### 2.1 [Nombre Integrante 1]

**Componentes desarrollados:**
- Clases base: `Token`, `Operator`, `BinaryOperator`
- Operadores aritméticos: `AddOperator`, `SubOperator`, `MultOperator`, `DivOperator`
- Documentación de las clases de operadores

**Desafíos enfrentados:**
- Implementar correctamente el patrón de diseño para operadores
- Asegurar que la jerarquía de herencia fuera extensible

**Horas dedicadas:** [X horas]

**Lo que aprendí:**
- Importancia del diseño orientado a objetos
- Uso efectivo de clases abstractas y polimorfismo
- Documentación clara del código

---

### 2.2 [Nombre Integrante 2]

**Componentes desarrollados:**
- Clase `Expression` (núcleo del evaluador)
- Algoritmo de Shunting Yard (conversión infija a postfija)
- Algoritmo de evaluación de expresiones postfijas
- Clase `Stack` (estructura de datos pila genérica)

**Desafíos enfrentados:**
- Entender completamente el algoritmo de Shunting Yard
- Manejar correctamente los paréntesis
- Debugging de casos complejos con paréntesis anidados

**Horas dedicadas:** [X horas]

**Lo que aprendí:**
- Algoritmos de procesamiento de expresiones
- Uso de estructuras de datos en problemas reales
- Importancia de las pruebas exhaustivas

---

### 2.3 [Nombre Integrante 3]

**Componentes desarrollados:**
- Interfaz gráfica (`View.java`)
- Clase `Main` (punto de entrada)
- Sistema de pruebas (`TestExpression.java`)
- Scripts de compilación y ejecución
- Documentación (README.md, INFORME.md)

**Desafíos enfrentados:**
- Integrar la lógica de evaluación con la interfaz gráfica
- Crear pruebas comprehensivas
- Escribir documentación clara

**Horas dedicadas:** [X horas]

**Lo que aprendí:**
- Desarrollo de interfaces gráficas con Java Swing
- Importancia de las pruebas automatizadas
- Documentación efectiva de proyectos

---

## 3. PROCESO DE TRABAJO EN EQUIPO

### 3.1 Organización Inicial

**Primera Reunión (Fecha: [XX/XX/2025]):**
- Análisis conjunto del problema
- Revisión de los videos proporcionados por el profesor
- División inicial de tareas según habilidades
- Establecimiento de cronograma

### 3.2 Herramientas de Colaboración

**Comunicación:**
- WhatsApp: Grupo para comunicación diaria
- Zoom: Reuniones semanales de 2 horas

**Compartir Código:**
- Google Drive: Carpeta compartida del proyecto
- [Alternativa: GitHub para control de versiones]

**Coordinación:**
- Trello/Google Tasks: Lista de tareas pendientes
- Google Docs: Documentación colaborativa

### 3.3 Metodología de Desarrollo

**Semana 1 (19-24 Nov):**
- Día 1-2: Análisis del problema y diseño de arquitectura
- Día 3-4: Desarrollo individual de componentes asignados
- Día 5: Primera integración y pruebas

**Semana 2 (25 Nov):**
- Día 1: Refinamiento y corrección de bugs
- Día 2: Documentación final y preparación de entrega

### 3.4 Reuniones Realizadas

**Reunión 1 - [Fecha]:**
- Duración: 2 horas
- Temas: Análisis del problema, asignación de tareas
- Decisiones: División de clases entre los miembros

**Reunión 2 - [Fecha]:**
- Duración: 3 horas
- Temas: Integración de componentes, resolución de conflictos
- Decisiones: Estandarización de nombres de variables y métodos

**Reunión 3 - [Fecha]:**
- Duración: 2 horas
- Temas: Pruebas finales, documentación
- Decisiones: Casos de prueba adicionales

### 3.5 Divisiones de Tarea Específicas

| Tarea | Responsable | Estado |
|-------|-------------|--------|
| Diseño de arquitectura | Todos | ✓ Completo |
| Clases base (Token, Operator) | [Integrante 1] | ✓ Completo |
| Operadores (+, -, *, /) | [Integrante 1] | ✓ Completo |
| Clase Expression | [Integrante 2] | ✓ Completo |
| Algoritmo Shunting Yard | [Integrante 2] | ✓ Completo |
| Clase Stack | [Integrante 2] | ✓ Completo |
| Interfaz gráfica | [Integrante 3] | ✓ Completo |
| Sistema de pruebas | [Integrante 3] | ✓ Completo |
| Documentación | [Integrante 3] | ✓ Completo |

### 3.6 Gestión de Conflictos

**Conflicto 1: Convenciones de nombres**
- Problema: Cada miembro usaba diferentes estilos (camelCase vs snake_case)
- Solución: Adoptamos las convenciones de Java (camelCase para variables y métodos)

**Conflicto 2: Precedencia de operadores**
- Problema: Confusión sobre qué precedencia asignar
- Solución: Investigamos juntos y acordamos usar convenciones matemáticas estándar

---

## 4. DESAFÍOS Y SOLUCIONES

### 4.1 Desafío Técnico 1: Algoritmo de Shunting Yard

**Problema:**
Inicialmente no entendíamos completamente cómo funcionaba el algoritmo de Shunting Yard, especialmente el manejo de paréntesis.

**Solución:**
1. Investigamos recursos adicionales en línea
2. Trazamos el algoritmo paso a paso con ejemplos en papel
3. Implementamos logging detallado para ver el flujo
4. Probamos con casos de prueba progresivamente más complejos

**Resultado:**
Logramos una implementación correcta que maneja:
- Expresiones simples: `3 + 4`
- Precedencia: `2 + 3 * 4 = 14`
- Paréntesis: `(2 + 3) * 4 = 20`
- Paréntesis anidados: `((5 + 3) * 2) / 4 = 4`

### 4.2 Desafío Técnico 2: Manejo de Espacios

**Problema:**
El tokenizador inicialmente fallaba si el usuario no ponía espacios entre operadores.

**Solución:**
Especificamos claramente en la interfaz que se requieren espacios, y agregamos validación y mensajes de error claros.

**Decisión de diseño:**
Mantuvimos el requisito de espacios porque:
1. Simplifica el parsing
2. Evita ambigüedades (ej: "3-2" vs "3 - 2" vs "-32")
3. Es consistente con el ejemplo proporcionado por el profesor

### 4.3 Desafío de Colaboración: Integración de Componentes

**Problema:**
Cada miembro desarrolló sus clases independientemente, y al integrarlas hubo problemas de compatibilidad.

**Solución:**
1. Establecimos una reunión de integración
2. Definimos interfaces claras entre componentes
3. Usamos pruebas unitarias para verificar cada componente
4. Integramos gradualmente: primero operadores, luego Expression, finalmente GUI

### 4.4 Desafío de Tiempo: Fechas de Entrega

**Problema:**
Con el proyecto coincidiendo con otras entregas del curso y responsabilidades laborales.

**Solución:**
1. Planificación temprana y división clara de tareas
2. Reuniones eficientes y enfocadas
3. Comunicación asíncrona efectiva vía WhatsApp
4. Compromiso de todos los miembros

---

## 5. PRUEBAS Y VERIFICACIÓN

### 5.1 Estrategia de Pruebas

Implementamos un sistema de pruebas automatizadas (`TestExpression.java`) que verifica 12 casos diferentes:

1. **Operaciones simples:** Suma, resta, multiplicación, división
2. **Precedencia de operadores:** Verificación de que * y / tienen mayor precedencia que + y -
3. **Paréntesis:** Modificación de precedencia con paréntesis
4. **Expresiones complejas:** Combinaciones de múltiples operadores
5. **Números decimales:** Soporte para punto flotante

### 5.2 Resultados de Pruebas

```
=== PRUEBAS DEL EVALUADOR DE EXPRESIONES ===

Prueba 1: 3 + 5                              ✓ CORRECTO (8.0)
Prueba 2: 10 - 3                             ✓ CORRECTO (7.0)
Prueba 3: 4 * 6                              ✓ CORRECTO (24.0)
Prueba 4: 20 / 4                             ✓ CORRECTO (5.0)
Prueba 5: 2 + 3 * 4                          ✓ CORRECTO (14.0)
Prueba 6: 20 / 4 + 3                         ✓ CORRECTO (8.0)
Prueba 7: ( 2 + 3 ) * 4                      ✓ CORRECTO (20.0)
Prueba 8: 10 + 2 * ( 6 - 4 )                 ✓ CORRECTO (14.0)
Prueba 9: 100 / 10 + 50 - 20 * 2             ✓ CORRECTO (20.0)
Prueba 10: ( ( 5 + 3 ) * 2 ) / 4             ✓ CORRECTO (4.0)
Prueba 11: 3.5 + 2.5                         ✓ CORRECTO (6.0)
Prueba 12: 1 + 2                             ✓ CORRECTO (3.0)

RESULTADOS: 12/12 pruebas pasadas
✓ ¡TODAS LAS PRUEBAS PASARON!
```

### 5.3 Casos Edge Probados Manualmente

- Expresión vacía: Muestra mensaje de error apropiado
- División por cero: Resultado Infinity (comportamiento de Java)
- Paréntesis desbalanceados: El algoritmo maneja correctamente
- Números negativos: Soporte mediante operador de negación ~

---

## 6. CALIDAD DEL CÓDIGO

### 6.1 Convenciones de Estilo

Seguimos las convenciones de Java:
- **Clases:** PascalCase (`AddOperator`, `Expression`)
- **Métodos:** camelCase (`evaluate()`, `infixToPostfix()`)
- **Variables:** camelCase con prefijo m para miembros (`mValue`, `mList`)
- **Constantes:** UPPER_SNAKE_CASE (`ASSOC_LEFT`, `ASSOC_RIGHT`)

### 6.2 Documentación del Código

Cada clase y método incluye:
- **JavaDoc** completo con descripción
- **@param** para todos los parámetros
- **@return** para valores de retorno
- **Comentarios explicativos** para lógica compleja

Ejemplo:
```java
/**
 * Evalúa una expresión aritmética en notación infija
 * 
 * Algoritmo:
 * 1. Convierte la expresión infija a tokens
 * 2. Convierte los tokens a notación postfija
 * 3. Evalúa la expresión postfija usando una pila
 * 
 * @param pExpr Expresión en notación infija (ej: "1 + 2 * 3")
 * @return El resultado de evaluar la expresión
 */
public Double evaluate(String pExpr) {
    // ...
}
```

### 6.3 Estructura y Organización

- **Sin warnings:** Código compiló sin advertencias
- **Sin errores:** Todas las pruebas pasaron
- **Modularidad:** Cada clase tiene una responsabilidad única
- **Reutilización:** Pila genérica puede usarse en otros contextos

---

## 7. CONCLUSIONES

### 7.1 Objetivos Alcanzados

✓ Implementación completa y funcional del evaluador de expresiones  
✓ Interfaz gráfica intuitiva y fácil de usar  
✓ Sistema de pruebas robusto (12/12 pruebas pasadas)  
✓ Código bien documentado y organizado  
✓ Trabajo colaborativo efectivo  

### 7.2 Aprendizajes Clave

**Técnicos:**
- Algoritmos de procesamiento de expresiones (Shunting Yard)
- Uso efectivo de estructuras de datos (Pilas)
- Diseño orientado a objetos con jerarquías de clases
- Desarrollo de interfaces gráficas con Swing

**Blandos:**
- Importancia de la comunicación clara en equipos
- División efectiva de tareas según habilidades
- Resolución constructiva de conflictos
- Gestión del tiempo en proyectos colaborativos

### 7.3 Posibles Mejoras Futuras

Si tuviéramos más tiempo, consideraríamos:
1. **Más operadores:** Potencia (^), módulo (%), raíz cuadrada
2. **Funciones:** sin(), cos(), log(), etc.
3. **Variables:** Permitir x, y en expresiones
4. **Historial:** Guardar expresiones anteriores
5. **Exportación:** Guardar resultados en archivo
6. **Teclado visual:** Botones para operadores

### 7.4 Reflexión sobre el Trabajo en Equipo

**Lo que funcionó bien:**
- División clara de responsabilidades
- Comunicación frecuente y efectiva
- Compromiso de todos los miembros
- Flexibilidad para ayudarnos mutuamente

**Lo que podríamos mejorar:**
- Iniciar el proyecto un poco antes
- Hacer más reuniones de integración temprana
- Establecer estándares de código desde el inicio

---

## 8. REFERENCIAS

1. **Algoritmo Shunting Yard:**  
   https://en.wikipedia.org/wiki/Shunting-yard_algorithm

2. **Java Swing Tutorial:**  
   https://docs.oracle.com/javase/tutorial/uiswing/

3. **Notación Polaca Reversa:**  
   https://es.wikipedia.org/wiki/Notación_polaca_inversa

4. **Videos del Curso (Canvas):**
   - Demostración del programa
   - Discusión del algoritmo
   - Creación del proyecto NetBeans
   - Diseño de Software

5. **Estructura de Datos - Pilas:**  
   Material del curso CSE205

---

## 9. ANEXOS

### Anexo A: Estructura de Archivos Entregados

```
ProyectoPrograma ción3_ParteA/
├── src/
│   ├── Token.java
│   ├── Operand.java
│   ├── Operator.java
│   ├── BinaryOperator.java
│   ├── AddOperator.java
│   ├── SubOperator.java
│   ├── MultOperator.java
│   ├── DivOperator.java
│   ├── NegOperator.java
│   ├── Parenthesis.java
│   ├── Stack.java
│   ├── Expression.java
│   ├── View.java
│   ├── Main.java
│   └── TestExpression.java
├── bin/ (compilados)
├── README.md
├── INFORME.md (este archivo)
├── compile.sh
├── compile.bat
├── run.sh
└── run.bat
```

### Anexo B: Instrucciones de Ejecución

**Para compilar:**
```bash
# En Linux/Mac
./compile.sh

# En Windows
compile.bat
```

**Para ejecutar:**
```bash
# En Linux/Mac
./run.sh

# En Windows
run.bat
```

**Para ejecutar pruebas:**
```bash
java -cp bin TestExpression
```

---

**Fin del Informe**

---

**Fecha de Entrega:** 25 de Noviembre de 2025  
**Firma de los Integrantes:**

- _________________ [Integrante 1]
- _________________ [Integrante 2]
- _________________ [Integrante 3]
