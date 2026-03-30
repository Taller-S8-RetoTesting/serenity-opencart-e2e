# README - Automatización E2E con Serenity BDD

## Objetivo

Este proyecto automatiza el flujo de compra como invitado sobre OpenCart en `http://opencart.abstracta.us/`, usando Serenity BDD, Cucumber y el patrón Screenplay.

El escenario implementado valida:

- Agregar `MacBook` al carrito
- Agregar `iPhone` al carrito
- Visualizar el carrito de compras
- Iniciar checkout como invitado
- Completar datos de facturación
- Seleccionar método de envío
- Seleccionar método de pago
- Confirmar la orden
- Verificar el mensaje final `Your order has been placed!`

## Tecnologías utilizadas

- Java 17
- Gradle Wrapper
- Serenity BDD 5.3.3
- Cucumber 7.34.2
- JUnit Platform
- Screenplay Pattern

## Prerrequisitos

1. Tener Java 17 instalado y disponible en `PATH`.
2. Tener Google Chrome instalado.
3. Tener acceso a internet, ya que la suite consume un sitio público.
4. Ejecutar los comandos desde la raíz del proyecto.

## Estructura relevante

- `src/test/resources/features/guest_checkout.feature` — feature del flujo E2E completo
- `src/test/java/org/alexrieger/runners/OpenCartE2ERunner.java` — runner JUnit Platform con integración Serenity + Cucumber
- `src/test/java/org/alexrieger/stepdefinitions/GuestCheckoutStepDefinition.java` — orquestación de pasos Gherkin
- `src/test/java/org/alexrieger/tasks/` — tareas Screenplay del flujo de compra
- `src/test/java/org/alexrieger/questions/OrderSuccessMessage.java` — validación del mensaje final
- `src/test/java/org/alexrieger/ui/` — locators y targets de la UI
- `src/test/java/org/alexrieger/util/TestData.java` — datos de prueba centralizados
- `src/test/resources/serenity.conf` — configuración del navegador y evidencias

## Pasos de ejecución

### Windows

1. Abrir una terminal en la raíz del proyecto.
2. Ejecutar:

```powershell
.\gradlew.bat clean test aggregate
```

### Git Bash, Linux o macOS

1. Abrir una terminal en la raíz del proyecto.
2. Ejecutar:

```bash
./gradlew clean test aggregate
```

## Resultado esperado

La ejecución debe finalizar sin errores y generar los reportes en las carpetas `target/` y `build/`.

Ubicaciones útiles:

- `target/site/serenity/index.html`
- `target/site/serenity/serenity-summary.html`
- `build/reports/tests/test/index.html`

## Consideraciones del ejercicio

- La automatización cubre el happy path del guest checkout solicitado en el taller.
- El correo del invitado se genera dinámicamente para evitar colisiones por reutilización de datos.
- El sitio bajo prueba es público y compartido; por eso pueden aparecer intermitencias por latencia, cambios menores del DOM o estado cambiante del ambiente.
- Durante la implementación fue necesario ajustar sincronización y selectores para estabilizar interacciones transitorias del checkout y de los mensajes de confirmación.
