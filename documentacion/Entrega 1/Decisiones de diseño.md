# Decisiones de diseño

## Actuadores y sensores
+ Los sensores conocen muchas reglas. Las reglas son observadoras de los sensores. Cuando un sensor mide, le notifica a cada regla acerca de su medicion para que ellas hagaan lo que tengan que hacer.
+ Las reglas conocen muchos actuadores y 1 dispositivo. Cuando son notificadas de una medicion, le dicen a los actuadores que se accionen.
+ El actuador recibe al dispositivo como parámetro en su metodo actuaSobre(unDispositivo) por parte de las reglas para favorecer el desacoplamiento entre este mismo y el dispositivo.
+ El actuador no depende de la regla ni del sensor. Esto quiere decir que puede ser llamado por distintas reglas, si éstas luego de ejecutar su lógica consideran que ese actuador debe actuar sobre algun dispositivo.

