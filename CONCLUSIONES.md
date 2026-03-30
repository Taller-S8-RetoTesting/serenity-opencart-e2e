# Conclusiones del ejercicio E2E con Serenity

## Hallazgos principales

- La automatización cubre el flujo funcional solicitado: agregar dos productos, revisar el carrito, completar el guest checkout y validar el mensaje final de compra exitosa.
- La solución quedó ejecutable con Gradle Wrapper y genera evidencia en Serenity, lo que permite revisar pasos, tiempos y fallos desde reporte HTML.
- La separación en `tasks`, `questions`, `ui`, `stepdefinitions` y `runner` dejó una base coherente con Screenplay y más mantenible que una suite acoplada en step definitions.
- La parte crítica del trabajo no fue crear clases, sino estabilizar la ejecución real del flujo en una UI pública y cambiante.

## Transparencia sobre la construcción

- El proyecto se apoyó en un template base ya existente para acelerar la estructura inicial y las dependencias.
- También hubo apoyo de IA para descomponer el problema y redactar una primera versión de varios artefactos.
- Nada de eso evitó el trabajo real: hubo que revisar el flujo, corregir integración del runner, ajustar locators y endurecer esperas para que la automatización funcionara de verdad.

## Observaciones honestas

- La automatización apunta al happy path del ejercicio; no cubre escenarios negativos ni variaciones amplias de catálogo, stock o validaciones de formulario.
- El sitio de OpenCart usado para la prueba es público y compartido, así que siempre existe riesgo de intermitencia por latencia, estado del ambiente o cambios menores del DOM.
- En este tipo de pruebas E2E, detalles aparentemente menores como un selector genérico o una espera atada a mensajes transitorios pueden romper la suite aunque la lógica de negocio siga siendo correcta.

## Conclusiones finales

- El ejercicio queda reproducible, entendible y técnicamente consistente con lo pedido en el taller.
- La aceleración con template y asistencia de IA fue útil, pero la confiabilidad salió de la validación humana, no de la generación automática.
- Si hubiera una mejora inmediata, sería reforzar todavía más la tolerancia a intermitencias del sitio y ampliar cobertura con algunos escenarios negativos o validaciones intermedias adicionales.