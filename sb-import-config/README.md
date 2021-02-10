# Spring Config Tree

El siguiente ejercicio tiene como finalidad demostrar la importación de propiedades por medio de `spring.config.import` [Volume Mounted Configuration Trees](https://spring.io/blog/2020/08/14/config-file-processing-in-spring-boot-2-4), integrarlo con [Docker secrets](https://docs.docker.com/engine/swarm/secrets/) para ocultar propiedades sensibles.

## Descargar y ejecutar el proyecto

Para ejecutar el ejemplo, descargar el código de este repositorio y ejecutarlo con el siguiente comando:

```sh
$ cd /some_path/sb-import-config/
$ mvn spring-boot:run
```

Después de haber ejecutado el proyecto, acceder a la url [http://localhost:7090/properties](http://localhost:7090/properties), obteniendo la siguiente respuesta:

``` json
{
  "foo": "Propiedad foo desde desarrollo",
  "bar": "Propiedad bar desde desarrollo"
}
```

## Descripción del perfil de desarrollo 

En el archivo de propiedades `application.yml` se especifica el perfil `des` que nos permite asignar valores a las variable `foo` y `bar` que se consultaron en el paso anterior. 

``` yml
---
# Configuraciones que se aplican en el ambiente de desarrollo de la aplicación
spring:
  config:
    activate:
      on-profile: [ des ]
app:
  properties:
    foo: Propiedad foo desde desarrollo
    bar: Propiedad bar desde desarrollo
```

## Descripción perfil docker

``` yml
---
# Configuraciones que se aplican en el ambiente de docker de la aplicación
spring:
  config:
    activate:
      on-profile: [ docker ]
    import: [ configtree:/run/secrets/ ]
```

En el caso del perfil de Docker, se hace referencia al path `/run/secrets/`, donde se ligan los secretos dentro del contenedor del servicio y se describe su comportamiento más adelante.

## Generar la imagen de la aplicación

Después de haber comprobado el funcionamiento de la aplicación, hay que construir la imagen de la aplicación:

``` sh
$ mvn spring-boot:build-image
```
arrojando la siguiente salida:

``` log
...
[INFO] <<< spring-boot-maven-plugin:2.4.2:build-image (default-cli) < package @ sb-import-config <<<
[INFO] 
[INFO] --- spring-boot-maven-plugin:2.4.2:build-image (default-cli) @ sb-import-config ---
[INFO] Building image 'docker.io/library/sb-import-config:1.0.0'
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 52.139 s
[INFO] Finished at: 2021-02-10T14:08:59-06:00
[INFO] Final Memory: 20M/74M
[INFO] ------------------------------------------------------------------------
```

Listar la imágenes para verificar la existencia de la nueva imagen.
``` sh
$ docker image ls | grep sb-import
sb-import-config                                         1.0.0                 384d9a615734        41 years ago        224MB
```

## Crear secreto en Docker

Abrir una terminal y ejecutar el siguiente comando para crear el secreto, para ello, debe nombrarse exactamente como las propiedades declaradas en el archivo `application.yml`.

``` sh
$ printf "Mi secreto foo guardado en Docker" | docker secret create app.properties.foo -
1ud1c265eep3wtaezyuwhq1ml
$ printf "Mi secreto bar guardado en Docker" | docker secret create app.properties.bar -
m7lihq2oe0g0251t6iadzwjxi
```

## Arrancar el servicio

Ya listos los secretos en Docker, es posible arrancar la aplicación.

``` sh
$ docker service create \
  --name sb-secrets \
  --secret app.properties.foo \
  --secret app.properties.bar \
  --env SPRING_PROFILES_ACTIVE=pro,docker \
  -p 7090:7090 \
  sb-import-config:1.0.0
```

Esperar a que el scheduler despliegue el servicio y se verifica el servicio

``` sh
$ docker service ls
ID                  NAME                MODE                REPLICAS            IMAGE                    PORTS
azxkhw7xhl47        sb-secrets          replicated          1/1                 sb-import-config:1.0.0   *:7090->7090/tcp
```

Por último se verifica el funcionamiento del servicio accediendo a [http://localhost:7090/properties](http://localhost:7090/properties) obteniendo el siguiente resultado:

``` json
{
  "foo": "Mi secreto foo guardado en Docker",
  "bar": "Mi secreto bar guardado en Docker"
}
```

### Documentación de referencia

* [Docker Service](https://docs.docker.com/engine/reference/commandline/service/) 
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.2/maven-plugin/reference/html/#build-image)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#configuration-metadata-annotation-processor)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#using-boot-devtools)

