# Serenity OpenCart E2E — Guest Checkout Automation

Automatización E2E del flujo de compra como invitado en [OpenCart](http://opencart.abstracta.us/) usando **Serenity BDD**, **Cucumber** y el patrón **Screenplay**.

## Requisitos previos

| Herramienta | Versión mínima |
|---|---|
| Java (JDK) | 17 |
| Gradle | 9.0 (incluido via wrapper) |
| Google Chrome | última estable |

## Flujo automatizado

El escenario E2E cubre:

1. Navegar a la tienda OpenCart
2. Agregar **MacBook** al carrito
3. Agregar **iPhone** al carrito
4. Visualizar el carrito de compras
5. Iniciar checkout como **Guest (invitado)**
6. Completar datos de facturación
7. Seleccionar método de envío
8. Seleccionar método de pago (aceptando términos)
9. Confirmar la orden
10. Validar el mensaje final: **"Your order has been placed!"**

## Ejecución

### Ejecutar todas las pruebas y generar reporte

```bash
./gradlew clean test aggregate
```

En Windows:

```bash
gradlew.bat clean test aggregate
```

### Ejecutar solo el runner específico

```bash
./gradlew test --tests "org.alexrieger.runners.OpenCartE2ERunner"
```

## Reportes

Después de la ejecución, el reporte de Serenity se genera en:

```
target/site/serenity/index.html
```

Abrir este archivo en un navegador para ver el reporte detallado con capturas de pantalla.

## Estructura del proyecto

```
src/test/
├── java/org/alexrieger/
│   ├── hooks/
│   │   └── OpenBrowser.java              # Task para abrir el navegador
│   ├── questions/
│   │   └── OrderSuccessMessage.java      # Pregunta: texto de confirmación
│   ├── runners/
│   │   └── OpenCartE2ERunner.java        # Runner JUnit 5 + Cucumber
│   ├── stepdefinitions/
│   │   ├── GuestCheckoutStepDefinition.java  # Step definitions del flujo
│   │   └── hooks/
│   │       └── Hook.java                 # Hook @Before: inicializa OnStage
│   ├── tasks/
│   │   ├── AddFeaturedProductToCart.java  # Agregar producto al carrito
│   │   ├── ViewShoppingCart.java         # Ver carrito desde header
│   │   ├── BeginGuestCheckout.java       # Iniciar checkout como invitado
│   │   ├── CompleteGuestBillingDetails.java # Llenar formulario de facturación
│   │   ├── SelectDeliveryMethod.java     # Seleccionar método de envío
│   │   ├── SelectPaymentMethod.java      # Aceptar términos y pagar
│   │   └── ConfirmOrder.java            # Confirmar orden final
│   ├── ui/
│   │   ├── HomePageUI.java              # Targets: productos, carrito
│   │   ├── ShoppingCartPageUI.java      # Targets: página del carrito
│   │   ├── CheckoutPageUI.java          # Targets: formulario checkout
│   │   └── OrderSuccessPageUI.java      # Targets: página de éxito
│   └── util/
│       └── TestData.java                # Constantes y datos de prueba
└── resources/
    ├── features/
    │   └── guest_checkout.feature       # Escenario Gherkin del flujo E2E
    ├── logback-test.xml
    └── serenity.conf
```

## Patrón Screenplay

La solución sigue estrictamente el patrón **Screenplay**:

| Capa | Responsabilidad |
|---|---|
| **Features** | Escenarios en Gherkin (lenguaje de negocio) |
| **Step Definitions** | Orquestación delgada: conectan Gherkin con Tasks/Questions |
| **Tasks** | Lógica de negocio: interacciones con la aplicación |
| **Questions** | Verificaciones: consultan el estado de la aplicación |
| **UI (Targets)** | Localizadores de elementos: separados de la lógica |
| **Util** | Datos centralizados: constantes y helpers |

## Dependencias principales

| Dependencia | Versión |
|---|---|
| Serenity BDD | 5.3.3 |
| Cucumber | 7.34.2 |
| JUnit Platform | 1.11.4 |
| Java | 17 |
| Gradle | 9.0 |

## Notas

- El navegador Chrome se ejecuta en modo **incognito** (configurado en `serenity.conf`).
- Las capturas de pantalla se toman en **cada acción** (`FOR_EACH_ACTION`).
- El email del invitado se genera dinámicamente con timestamp para evitar duplicados.
- Los datos de prueba están centralizados en `TestData.java`.
