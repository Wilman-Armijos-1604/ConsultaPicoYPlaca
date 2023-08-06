# Requisitos:

## Docker:
Para poder construir y lanzar la aplicación, es necesario contar con algún cliente de Docker dentro del computador.

En el siguiente enlace:
- https://www.docker.com/get-started/
Se puede descargar el cliente oficial de Docker para Windows, Linux y MacOS.

## Proyecto:
Para poder construir y lanzar la aplicación, es necesario también que el proyecto sea descargado dentro del computador local. Para ello, puede descargarlo directamente desde el presente repositorio de GitHub, o puede utilizar algún cliente de Git.

En el siguiente enlace:
- https://docs.github.com/es/repositories/working-with-files/using-files/downloading-source-code-archives
Se muestra como descargar de forma manual el proyecto.

Y, en el siguiente enlace:
- https://docs.github.com/es/repositories/creating-and-managing-repositories/cloning-a-repository
Se muestra cómo se puede utilizar Git para clonar el proyecto y acceder a él en el computador local.



# Instrucciones:

Una vez se ha instalado Docker correctamente en el sistema, y este se encuentra listo para funcionar, es posible construir y lanzar la aplicación. 
Para ello, se recomienda seguir los siguientes pasos:

## Construcción y ejecución del Proyecto:
1. Abrir la consola de comandos del Sistema Operativo correspondiente. (Windows, Linux, MacOS)
2. Navegar a través de la consola hacia el directorio raíz del proyecto.
3. Ejecutar el comando "docker compose up --build" en el directorio raíz. (Puede verificarse comprobando que el archivo "docker-compose.yml" se encuentra en el directorio)

## Acceso a la aplicación:
1. Abrir un navegador web.
2. Acceder a la dirección "localhost:8080". (También es posible y en algunos casos necesario utilizar la dirección completa "http://localhost:8080")

Y listo, a través de esto ahora puede acceder y utilizar la aplicación "Consulta Pico y Placa".


# Opciones adicionales.

Si se quiere probar la aplicación en otros dispositivos distintos al computador local, se recomienda seguir los siguientes pasos:

## Modificación, construcción y ejecución del proyecto:
1. Verificar la dirección IPv4 del computador. (Puede utilizarse una interfaz de línea de comandos o una interfaz gráfica) (Ejemplo: 127.0.0.10)
2. Abrir el archivo "\able-check-vehicle-date-time.service.ts" ubicado en el directorio "consultapicoyplaca-frontend\src\app\services". (puede utilizar cualquier editor de texto de preferencia)
3. Modificar la línea del archivo descrito en el pasos anterior archivo cuyo valor por defecto es:
        private API_URL: string = "http://localhost:9000/VehicleDateTimeCheck";
    Por la línea:
        private API_URL: string = "http://XXX.XXX.XXX.XXX:9000/VehicleDateTimeCheck";
    Donde XXX.XXX.XXX.XXX es la dirección IPv4 de su computador, que fue encontrada en el paso 1. 
    Ejemplo: 
        private API_URL: string = "http://127.0.0.10:9000/VehicleDateTimeCheck";
4. Una vez hecho esto, puede ejecutar los pasos previamente descritos en la sección de Instrucciones.

## Acceso a la aplicación:
1. Comprobar que el dispositivo desde el cuál desea abrir la aplicación se encuentra dentro de la misma red que el computador en el que ha sido construida y ejecutada. (Puede utilizarse una interfaz de línea de comandos o una interfaz gráfica)
2. Abrir un navegador web dentro del dispositivo.
3. Acceder a la dirección "XXX.XXX.XXX.XXX:8080". (También es posible y en algunos casos necesario utilizar la dirección completa "http://XXX.XXX.XXX.XXX:8080")
    Donde XXX.XXX.XXX.XXX es la dirección IPv4 del computador en el que el proyecto se encuentra en ejecución, la misma del paso 1 de la sección anterior.
    Ejemplo: 
        127.0.0.10:8080 (o http://127.0.0.10:8080)

Y listo, a través de estos pasos ahora la aplicación ha sido accedida desde un dispositivo distinto al de ejecución.


# Notas adicionales
- En caso de no poder acceder desde un dispositivo externo hacia el computador donde se encuentra la aplicación en ejecución, se recomienda revisar las reglas de firewall del computador donde se encuentran la aplicación en ejecución, pues es posible que existan reglas que no permitan peticiones entrantes. Para eliminar este problema puede:
    - Desactivar temporalmente el Firewall de su computador. (NO RECOMENDADO)
    - Crear una nueva regla que permita el acceso desde fuera a cualquier dirección hacia el puerto 8080 del computador donde se encuentra la aplicación en ejecución.
