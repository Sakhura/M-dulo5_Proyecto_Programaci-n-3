# EJEMPLOS DE EXPRESIONES PARA PROBAR

## ✅ EXPRESIONES VÁLIDAS (Funcionan correctamente)

### Operaciones Básicas
```
3 + 5                 → Resultado: 8.0
10 - 3                → Resultado: 7.0
4 * 6                 → Resultado: 24.0
20 / 4                → Resultado: 5.0
```

### Precedencia de Operadores
```
2 + 3 * 4             → Resultado: 14.0 (primero 3*4=12, luego 2+12=14)
20 / 4 + 3            → Resultado: 8.0 (primero 20/4=5, luego 5+3=8)
10 - 2 * 3            → Resultado: 4.0 (primero 2*3=6, luego 10-6=4)
100 / 10 + 50 - 20 * 2  → Resultado: 20.0
```

### Con Paréntesis
```
( 2 + 3 ) * 4         → Resultado: 20.0 (primero 2+3=5, luego 5*4=20)
( 10 - 6 ) / 2        → Resultado: 2.0
10 + 2 * ( 6 - 4 )    → Resultado: 14.0
( 5 + 5 ) / ( 2 + 3 ) → Resultado: 2.0
```

### Paréntesis Anidados
```
( ( 5 + 3 ) * 2 ) / 4            → Resultado: 4.0
( 10 + ( 2 * 5 ) ) - 5           → Resultado: 15.0
( ( 10 - 2 ) * ( 3 + 2 ) ) / 4   → Resultado: 10.0
```

### Números Decimales
```
3.5 + 2.5             → Resultado: 6.0
10.5 / 2.5            → Resultado: 4.2
3.14 * 2              → Resultado: 6.28
```

### Expresiones Complejas
```
100 / 10 + 50 - 20 * 2           → Resultado: 20.0
2 * 3 + 4 * 5 - 6                → Resultado: 20.0
( 100 - 50 ) / ( 10 - 5 )        → Resultado: 10.0
10 * ( 2 + 3 ) - 5 * ( 4 - 2 )   → Resultado: 40.0
```

---

## ❌ EXPRESIONES INVÁLIDAS (Causan error)

### Sin espacios (INCORRECTO)
```
3+5                   ✗ Error: Tokens mal formados
10-3                  ✗ Error: Tokens mal formados
4*6                   ✗ Error: Tokens mal formados
```

**CORRECTO:** Siempre usar espacios
```
3 + 5                 ✓ Funciona
10 - 3                ✓ Funciona
4 * 6                 ✓ Funciona
```

### Paréntesis desbalanceados
```
( 3 + 5               ✗ Error: Falta paréntesis de cierre
3 + 5 )               ✗ Error: Falta paréntesis de apertura
( ( 3 + 5 )           ✗ Error: Paréntesis desbalanceados
```

### Operadores consecutivos
```
3 + + 5               ✗ Error: Operadores consecutivos
10 * / 2              ✗ Error: Operadores consecutivos
```

### Expresión vacía
```
                      ✗ Error: Expresión vacía
```

---

## 🧪 CASOS DE PRUEBA PARA VERIFICACIÓN

### Suite de Pruebas Básicas (Debe dar 12/12)
```
1.  3 + 5                      = 8.0
2.  10 - 3                     = 7.0
3.  4 * 6                      = 24.0
4.  20 / 4                     = 5.0
5.  2 + 3 * 4                  = 14.0
6.  20 / 4 + 3                 = 8.0
7.  ( 2 + 3 ) * 4              = 20.0
8.  10 + 2 * ( 6 - 4 )         = 14.0
9.  100 / 10 + 50 - 20 * 2     = 20.0
10. ( ( 5 + 3 ) * 2 ) / 4      = 4.0
11. 3.5 + 2.5                  = 6.0
12. 1 + 2                      = 3.0
```

---

## 📊 CASOS EDGE (Límites)

### Números grandes
```
1000000 + 2000000           → Resultado: 3000000.0
999999 * 2                  → Resultado: 1999998.0
```

### Números pequeños
```
0 + 0                       → Resultado: 0.0
0 * 100                     → Resultado: 0.0
0 / 10                      → Resultado: 0.0
```

### División por cero
```
10 / 0                      → Resultado: Infinity (comportamiento de Java)
```

### Muchos paréntesis
```
( ( ( ( 5 + 5 ) ) ) )       → Resultado: 10.0
```

---

## 🎓 EJEMPLOS DIDÁCTICOS (Para entender el algoritmo)

### Ejemplo 1: Conversión Infija → Postfija
```
Infija:   3 + 4 * 2
Postfija: 3 4 2 * +

Evaluación:
  Paso 1: Lee 3 → Pila: [3]
  Paso 2: Lee 4 → Pila: [3, 4]
  Paso 3: Lee 2 → Pila: [3, 4, 2]
  Paso 4: Lee * → Desapila 2 y 4, calcula 8 → Pila: [3, 8]
  Paso 5: Lee + → Desapila 8 y 3, calcula 11 → Pila: [11]
  Resultado: 11
```

### Ejemplo 2: Efecto de Paréntesis
```
Sin paréntesis:   3 + 4 * 2 = 14  (primero multiplicación)
Con paréntesis:  ( 3 + 4 ) * 2 = 14  (primero suma dentro del paréntesis)

Postfija sin paréntesis:  3 4 2 * +
Postfija con paréntesis:  3 4 + 2 *
```

### Ejemplo 3: Múltiples Operadores
```
Infija:   10 + 2 * 5 - 3
Postfija: 10 2 5 * + 3 -

Paso a paso:
  10 + (2 * 5) - 3
  10 + 10 - 3
  20 - 3
  17
```

---

## 🔍 DEBUGGING: Expresiones Problemáticas

Si encuentras errores, prueba estas expresiones de diagnóstico:

### Verificar operadores individuales
```
1 + 1      → Debe dar 2.0
2 - 1      → Debe dar 1.0
2 * 2      → Debe dar 4.0
4 / 2      → Debe dar 2.0
```

### Verificar precedencia
```
1 + 2 * 3  → Debe dar 7.0 (no 9.0)
```

### Verificar paréntesis
```
( 1 + 2 ) * 3  → Debe dar 9.0 (no 7.0)
```

### Verificar asociatividad izquierda
```
10 - 3 - 2  → Debe dar 5.0 (es (10-3)-2, no 10-(3-2))
```

---

## 💾 CÓMO USAR ESTOS EJEMPLOS

### En la Interfaz Gráfica:
1. Ejecuta el programa (Main.java o View.java)
2. Copia una expresión de este archivo
3. Pégala en el campo de texto
4. Haz clic en "Evaluate"
5. Verifica que el resultado coincida

### En las Pruebas Automatizadas:
- El archivo TestExpression.java ya incluye los 12 casos principales
- Para agregar más pruebas, edita TestExpression.java

### Prueba Manual Sistemática:
```
1. Prueba operaciones básicas (4 pruebas)
2. Prueba precedencia (4 pruebas)
3. Prueba paréntesis (4 pruebas)
4. Prueba casos complejos (4 pruebas)
Total: 16 pruebas mínimas
```

---

## 📝 PLANTILLA PARA REPORTAR BUGS

Si encuentras un bug, repórtalo así:

```
🐛 BUG REPORT

Expresión: [la expresión que probaste]
Resultado obtenido: [lo que dio el programa]
Resultado esperado: [lo que debería dar]
Mensaje de error: [si hubo error]

Pasos para reproducir:
1. [Paso 1]
2. [Paso 2]
3. [Paso 3]
```

---

## ✅ CHECKLIST DE VERIFICACIÓN

Antes de entregar, verifica que TODAS estas expresiones funcionen:

- [ ] 3 + 5 = 8.0
- [ ] 10 - 3 = 7.0
- [ ] 4 * 6 = 24.0
- [ ] 20 / 4 = 5.0
- [ ] 2 + 3 * 4 = 14.0
- [ ] ( 2 + 3 ) * 4 = 20.0
- [ ] ( ( 5 + 3 ) * 2 ) / 4 = 4.0
- [ ] 3.5 + 2.5 = 6.0
- [ ] 1 + 2 = 3.0

---

**Última actualización:** 25 de Noviembre de 2025  
**Archivo:** EJEMPLOS.md
