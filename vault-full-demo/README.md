# Administración de propiedades vía Vault

Proyecto Spring Boot demo de integración con el servicio de [Vault](https://learn.hashicorp.com/vault/getting-started/install) para el manejo de propiedades.

## Ambientación
### Variables 

<code>APP\_LOG\_FILE=/vault/logs/vault-app</code> Archivo de bitácora de la aplicación (No debe tener extensión).

<code>APP\_NODE\_NAME=vault</code> Nombre de la aplicación (identifica a la aplicación y el path de vault ej: secret/<b><i>vault</i></b>).

<code>BOOTSTRAP\_LOG\_FILE=/vault/logs/spring-cloud-bootstrap</code> Nombre del archivo de bitácora para el arranque de los servicios de Spring Cloud (en este caso Vault).

<code>SPRING\_PROFILES\_ACTIVE=development</code> Perfil de la aplicación (necesario para especificar el path del secreto de Vault ej: secret/vault/<b><i>development</i></b>).

<code>VAULT_HOST=msp.intranet.telmex.com</code> Especifica IP o Nombre de dominio del servidor Vault.

NOTA: En el ambiente de desarrollo, <b>msp.intranet.telmex.com</b> debe resolverse como <b>10.169.6.240</b>.

<code>VAULT\_PASSWORD=60cf266b-bbca-3558-f8c3-f6592e28b9b7</code> Corresponde al <i>secret_id</i> generado para la autenticación con Vault.

<code>VAULT\_PORT=18200</code> Puerto donde escucha el servidor Vault.

<code>VAULT\_TRUST\_STORE=file:/config/vault/msp-vault-keystore.p12</code> Si Vault utiliza SSL, especificar dónde se encuentra el almacén de claves. 
En el directorio <i>vault</i> de este proyecto se encuentra el archivo <i>msp-vault-keystore.p12</i> para el ambiente de desarrollo.

<code>VAULT\_TRUST\_STORE\_PSWD=M5Ps3cur3#%zY</code> Contraseña del almacén de claves.

<code>VAULT\_USERNAME=207125c8-666c-5c14-70ab-7f4ad5dd890e</code> Corresponde al <i>role_id</i> generado para la autenticación con Vault.

### Documentación
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/maven-plugin/)
* [Spring Boot Vault](https://spring.io/projects/spring-vault)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#configuration-metadata-annotation-processor)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#using-boot-devtools)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#production-ready)

### Guías
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Secretos en Vault](https://cloud.spring.io/spring-cloud-vault/reference/html/)

