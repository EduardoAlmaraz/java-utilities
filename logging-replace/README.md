# Ejemplo de enmascaramiento de cadenas en log

El ejemplo presenta un servicio rest que pinta en bitácora un mensaje que contiene un tag reservado.
El ejercicio considera remplazar la cadena para que no se muestre dicha información.

Para ello se, se utilizan las opciones del patrón de salida especificado en la configuración como sigue:

logback-spring.xml

``` xml
<pattern>
  %d{dd-MM-yyyy HH:mm:ss.SSS} %green([%thread]) %highlight(%-5level) %logger{36}.%M - %replace(%msg){"&lt;password&gt;.*&lt;", "&lt;password&gt;\*\*\*\*&lt;"}%n
</pattern>
```

La función que se utiliza es `%replace` que se describe como sigue:

| Syntax | Description |
| --- | ----------- |
| _**replace(p){r, t}**_ | Replaces occurrences of 'r', a regex, with its replacement 't' in the string produces by the sub-pattern 'p'. For example, "%replace(%msg){'\s', ''}" will remove all spaces contained in the event message. The pattern 'p' can be arbitrarily complex and in particular can contain multiple conversion keywords. For instance, "%replace(%logger %msg){'\.', '/'}" will replace all dots in the logger or the message of the event with a forward slash. |

El ejemplo escribe en bitácora la cadena `<password>my password</password>` y al hacer match con la expresión regular indicada en el patrón, deberá remplazarse.

```java 
...
    @RequestMapping("/")
    String hello() {

        // Se pinta en el log la etiqueta <password>mi password</password>, al ser revisada por la función %replace
        // la cambiará por *****
        // Output: <password>****</password>
        log.info("<password>mi password</password>");
        
        return "Hello World!";
    }
...
```

Ejecutar la aplicación:
``` bash
mvn spring-boot:run
```
invocar el servicio
``` bash
curl http://localhost:8080/
```
Al realizar la invocación del servicio deberá mostar una salida de bitácora como la siguiente:

``` log
03-02-2021 12:17:18.945 [http-nio-8080-exec-1] INFO  com.almaraze.HelloController.hello - <password>****</password>
```

# Referencia
[Logback replace](http://logback.qos.ch/manual/layouts.html#replace)
