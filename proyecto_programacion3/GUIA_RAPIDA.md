# 🚀 GUÍA RÁPIDA DE INICIO
## Proyecto de Programación 3 - Parte A

#### 💻 Configuración del Entorno
- [ ] Instalar NetBeans 7.4 (o superior)
- [ ] Instalar Java JDK 8 o superior
- [ ] Verificar que javac y java funcionen en terminal

#### 📁 Organización del Proyecto
- [ ] Crear carpeta compartida (GitHub)
- [X] Descargar el código base proporcionado, se valida con Docente se debia crear todos los archivos
- [ ] Asignar responsabilidades a cada miembro

---

## 🎯 DIVISIÓN DE TAREAS SUGERIDA

### Sabina Romero: Clases Base y Operadores
**Archivos:**
- `Token.java`
- `Operator.java`
- `BinaryOperator.java`
- `AddOperator.java`
- `SubOperator.java`
- `MultOperator.java`
- `DivOperator.java`
- `NegOperator.java`

**Tareas:**
1. Implementar jerarquía de clases
2. Documentar cada clase con JavaDoc
3. Probar operadores individualmente

---
### Natalia San Miguel - Lorenzo Chacano  Lógica del Evaluador
**Archivos:**
- `Operand.java`
- `Parenthesis.java`
- `Stack.java`
- `Expression.java`

**Tareas:**
1. Implementar estructura de datos Stack
2. Implementar algoritmo de Shunting Yard
3. Implementar evaluación de expresiones postfijas
4. Probar con múltiples casos

### Rodrigo Yañez - Andrés Perot : Interfaz y Documentación
**Archivos:**
- `View.java`
- `Main.java`
- `TestExpression.java`
- `README.md`
- `INFORME.md`


**Tareas:**
1. Crear interfaz gráfica con Swing
2. Integrar con el evaluador
3. Crear sistema de pruebas
4. Documentar todo el proyecto

## 🔧 COMANDOS ÚTILES

### Compilar el Proyecto
```bash
# En NetBeans: F11 o Run → Build Project

# En terminal (Linux/Mac):
cd proyecto_programacion3
javac -d bin src/*.java

# En terminal (Windows):
cd proyecto_programacion3
javac -d bin src\*.java
```

### Ejecutar el Programa
```bash
# En NetBeans: F6 o Run → Run Project

# En terminal:
java -cp bin Main
```

### Ejecutar Pruebas
```bash
java -cp bin TestExpression
```

---

## 🐛 PROBLEMAS COMUNES Y SOLUCIONES

### Problema 1: "javac no reconocido"
**Solución:** 
- Instalar JDK
- Agregar Java al PATH del sistema
- Reiniciar terminal

### Problema 2: Errores de compilación
**Solución:**
- Verificar que todos los .java estén en la misma carpeta
- Revisar nombres de clases (deben coincidir con nombres de archivo)
- Verificar imports necesarios

### Problema 3: NullPointerException
**Solución:**
- Verificar inicialización de objetos
- Usar debugging de NetBeans (F7, F8)
- Agregar validaciones null

### Problema 4: Stack vacía
**Solución:**
- Verificar que la expresión esté bien formada
- Revisar espacios entre operadores
- Validar entrada del usuario

---

## 🎯 CRITERIOS DE CALIDAD

Antes de entregar, verificar:

### Funcionalidad (36 pts)
- [ ] El programa compila sin errores
- [ ] Evalúa correctamente expresiones simples
- [ ] Maneja precedencia de operadores
- [ ] Procesa paréntesis correctamente
- [ ] Interfaz funciona sin crashes

### Pruebas (30 pts)
- [ ] Todas las pruebas automatizadas pasan
- [ ] Probado manualmente con casos edge
- [ ] Resultados coinciden con calculadora

### Documentación (21 pts)
- [ ] JavaDoc en todas las clases y métodos
- [ ] README completo
- [ ] INFORME con aportes individuales
- [ ] Código comentado donde es complejo

### Código (9 pts)
- [ ] Sin warnings de compilación
- [ ] Nombres descriptivos
- [ ] Indentación consistente
- [ ] Convenciones de Java seguidas

### Entrega (9 pts)
- [ ] Antes del 25 Nov 23:59
- [ ] Todos los archivos incluidos
- [ ] Formato correcto (ZIP o según instrucciones)

---

## 💡 TIPS DEL PROFESOR (Sacados de la documentación y videos)

1. **Espacios son obligatorios:** La expresión debe tener espacios: `3 + 4` (no `3+4`)

2. **Precedencia matemática estándar:**
   - Multiplicación y división primero
   - Suma y resta después
   - Paréntesis modifican la precedencia

3. **Notación postfija elimina ambigüedad:**
   - `3 + 4 * 2` → `3 4 2 * +` → Resultado: 11
   - `(3 + 4) * 2` → `3 4 + 2 *` → Resultado: 14

4. **Usar pilas (Stack) es esencial:**
   - Para conversión infija → postfija
   - Para evaluación de postfija

---

## 🏆 META: EXCELENCIA

Para obtener la nota máxima (105/105):

1. **Código impecable:** Sin errores, warnings, bien documentado
2. **Pruebas exhaustivas:** Todos los casos funcionan
3. **Documentación completa:** Informe detallado con reflexión
4. **Trabajo en equipo evidente:** Aportes claros de cada miembro
5. **Entrega puntual:** Antes de la fecha límite

---
## 📞 CONTACTO Y SOPORTE

Para dudas sobre el proyecto consultar a :

* Andrés Perot a.perotquevedo@uandresbello.edu
* Rodrigo Yañez r.yaezsepulveda@uandresbello.edu
* Lorenzo Chacano l.chacanomuoz@uandresbello.edu
* Natalia San Miguel n.sanmiguelcornejo@uandresbello.edu
* Sabina Romero s.romerorodriguez1@uandresbello.cl
---

**Última actualización:** 25 de Noviembre de 2025
