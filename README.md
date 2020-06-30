
# ESPECIFICACIONES TÉCNICAS DEL SOFTWARE

## Nombre del  Proyecto: Coding-challenge Java Microservoces Developer

## Elaborado por: Fabio Hernández
## Fecha: 29-Junio-2020
## IDE ECLIPSE sts-4.6.0.RELEASE
## JDK java-8-openjdk

## Introducción
Se desarrolla una API usando el marco de Java Spring Boot, en el cual se simula una operación de pago típica en una solucon de comercio electrónico.
Motor de base de datos: PostgresSQL 9.5. Aunque se uso un ORM por lo tanto no es obligatorio usar la misma base de datos para ejecutar el proyecto.
ORM: JPA: el cual permite de form fácil interactual con la base de datos a través de objetos

Se crearon cuatro microservicios, dos de consulta y dos de pago.
## Los microservicios de consulta son:
Los microservicios de consulta son:
## MicroConsultaDocumento:
MicroConsultaDocumento: Consulta por el documento del cliente y retorna un array de objetos con los diferentes pagos que tiene pendiente por pagar ese numero de documento

## MicroConsultaReferencia:
Consulta por número de referencia del pago y retorna un objeto que representa el pago pendiente por pagar
## Los microservicios de pago son:
## MicroPago:
MicroPago: Realizar págos de un solo regístro

## MicroPagos:
MicroPagos: Recibe una lista de pagos para que sean procesados y almacenados en la base de dataos

# Componentes
### MicroConsultaDocumento
Componente creado bajo el marco Spring Boot, el cual publica el servicio referencia de tipo GET, recibiendo como un único parámetro de tipo String, el cual representa el número del cliente
Este servicio retorna un Json con una lista de objetos de los pagos por pagar asociados al número de documento.
http://localhost:8090/consulta/documento/14796525

Las conexiones a la base de datos se encuentran configuradas en el archivo aplication.properties.

#### Dependencias del proyecto
spring-boot-starter-data-jpa: para la capa de persistencia
spring-boot-starter-data-rest: para realizar configuraciones de servicios Rest
postgresql: Driver de conexion para postgresSql

**El componente MicroConsultaDocumento cuenta con la siguiente paquetería:
**
#### co.com.microconsulta:
En este paquete se encuentra la clase main del microservicio llamada MicroConsultaApplication.

#### co.com.microconsulta.Entity:
En este paquete se encuentras las entidades
ConsolidadoVendedorEntity
DetallePagoEntity
PagoPendienteEntity

#### co.com.microconsulta.controller: 
Este paquete cuenta con la clase ConsultaPagoCtrl etiquetiada como @RestController y mapeada como /consulta con la etiqueta @RequestMapping. Esta clase contiene el servicio que se publicará para que sea consumido.
Servicio: EL servicio creado se consume bajo el nombre de documento y recibe un parámetro tipo String el cual representa el documento del cliente que va a realizar el pago y retorna un Json con la siguiente estructura:
#### Json Response
{
    "estado": "0",
    "descripcion": "Transaccion Exitosa",
    "pagoPendiente": null,
    "pagosPendientes": [
        {
            "valor": 10000.0,
            "referencia": "12345",
            "fechaLimPago": "2020-12-30", 
            "documento": "14796525",
            "nombre1": "Fabio",
            "nombre2": null,
            "apellido1": "Hernandez",
            "apellido2": "Quintana"
        },
        {
            "valor": 5000.0,
            "referencia": "12346",
            "fechaLimPago": "2020-12-30",
            "documento": "14796525",
            "nombre1": "Fabio",
            "nombre2": null,
            "apellido1": "Hernandez",
            "apellido2": "Quintana"
        },
        {
            "valor": 3000.0,
            "referencia": "12347",
            "fechaLimPago": "2020-12-30",
            "documento": "14796525",
            "nombre1": "Fabio",
            "nombre2": null,
            "apellido1": "Hernandez",
            "apellido2": "Quintana"
        }
    ]
}

#### Descripción del Json Response
 "estado": "0",--> Estado de la transacción valor cero Exitosa, diferente de cero Error
"descripcion": "Transaccion Exitosa",--> Mensaje que indica explicitamente como se comportó la transaccion
"pagoPendiente": null,-->Objeto que contiene los datos del cliente que tiene la deuda, Importante: para las consultas por documento se retorna nulo
"pagosPendientes": [--> Arregle de objetos tipo pagosPendientes que contiene los datos del cliente y datos del pago de un cliente.
"valor": 10000.0, --> Valor a pagar
"referencia": "12345",--> Número de referencia de la deuda
"fechaLimPago": "2020-12-30", --> Fecha Límite de pago
"documento": "14796525",--> Documento del cliente
"nombre1": "Fabio",-- Primer nombre del cliente
"nombre2": null,--> segundo nombre del cliente
"apellido1": "Hernandez",-->Primer Apellido del cliente
"apellido2": "Quintana"-->Segundo Apellido del cliente

#### co.com.microconsulta.service: 
Este paquete cuenta con una clases y una interface:
##### IConsultaPagoServ: 
Una interface con el método findByDocumento que recibe un parámetro tipo String y representa el documento del cliente, y retorna un objeto tipo ResponseConsultaPagoDTO.
##### ConsultaPagoServImpl:
Clase que implementa la interface IConsultaPagoServ y que contiene la lógica de una consulta por docuento

#### co.com.microconsulta.repository: 
Este paquete cuenta con una interface llamada IConsultaPagoRepo la cual extiende de la interface JpaRepository para manejar las consultas a la base de datos a traves de JPA.
la interface IConsultaPagoRepo cuenta con el método findByDocumento el cual recibe como parámetro un dato tipo String que representa el documento del cliente, y con el cual se realiza la consulta por número de documento retornando una lista de tipo PagoPendienteEntity

#### co.com.microconsulta.vo: 
En este paquete se encuentra la clase PagoPendienteVO la cual es un una clase modelo usada para transferir datos hacia el FrontEnd

#### co.com.microconsulta.DTO: 
En este paquete se encuentra la clase ResponseConsultaPagoDTO y es la encargada de transferir objetos VO hacia el FrontEnd

#### co.com.microconsulta.helpers:
En este paquete se encuentra la clase Util, esta clase se utiliza para almacenar datos estaticos usados en la aplicación.

### MicroConsultaReferencia
Componente creado bajo el marco Spring Boot, el cual publica el servicio referencia de tipo GET, recibiendo como un único parámetro de tipo String, el cual representa el número de referencia del pago.
El número de referencia es un número único por por pago. Este servicio retorna un Json con los datos del pago.
http://localhost:8091/consulta/referencia/12345

Las conexiones a la base de datos se encuentran configuradas en el archivo aplication.properties

#### Dependencias del proyecto
spring-boot-starter-data-jpa: para la capa de persistencia
spring-boot-starter-data-rest: para realizar configuraciones de servicios Rest
postgresql: Driver de conexion para postgresSql

**El componente MicroConsultaDocumento cuenta con la siguiente paquetería:**

#### co.com.microconsulta:
En este paquete se encuentra la clase main del microservicio llamada MicroConsultaApplication.

#### co.com.microconsulta.Entity:
En este paquete se encuentras las entidades
ConsolidadoVendedorEntity
DetallePagoEntity
PagoPendienteEntity

#### co.com.microconsulta.controller: 
Este paquete cuenta con la clase ConsultaPagoCtrl etiquetiada como @RestController y mapeada como /consulta con la etiqueta @RequestMapping. Esta clase contiene el servicio que se publicará para que sea consumido.
Servicio: EL servicio creado se consume bajo el nombre de referencia y recibe un parámetro tipo String el cual representa la referencia del pago, retornando un Json con la siguiente estructura:
####
{
    "estado": "0",
    "descripcion": "Transaccion Exitosa",
    "pagoPendiente": {
        "valor": 10000.0,
        "referencia": "12345",
        "fechaLimPago": "2020-12-30",
        "documento": "14796525",
        "nombre1": "Fabio",
        "nombre2": null,
        "apellido1": "Hernandez",
        "apellido2": "Quintana"
    },
    "pagosPendientes": null
}

#### Descripcion del Json Response
 "estado": "0",--> Estado de la transacción valor cero Exitosa, diferente de cero Error
"descripcion": "Transaccion Exitosa",--> Mensaje que indica explicitamente como se comportó la transaccion
"pagoPendiente": {,-->Objeto que contiene los datos del cliente que tiene la deuda.
"valor": 10000.0, --> Valor a pagar
"referencia": "12345",--> Número de referencia de la deuda
"fechaLimPago": "2020-12-30", --> Fecha Límite de pago
"documento": "14796525",--> Documento del cliente
"nombre1": "Fabio",-- Primer nombre del cliente
"nombre2": null,--> segundo nombre del cliente
"apellido1": "Hernandez",-->Primer Apellido del cliente
"apellido2": "Quintana"-->Segundo Apellido del cliente
}
"pagosPendientes": null--> Lista de objetos, solo retornado cuado la consulta se realiza por documento de lo contrario se retorna nulo
#### co.com.microconsulta.service: 
Este paquete cuenta con una clases y una interface:
##### IConsultaPagoServ:
Una interface con el método getByReferencia que recibe un parámetro tipo String el cual representa la referencia del pago, y retorna un objeto tipo ResponseConsultaPagoDTO.
##### ConsultaPagoServImpl:
Clase que implementa la interface IConsultaPagoServ y que contiene la lógica de una consulta por referencia  y retorna un objeto tipo ResponseConsultaPagoDTO.

#### co.com.microconsulta.repository: 
Este paquete cuenta con una interface llamada IConsultaPagoRepo la cual extiende de la interface JpaRepository para manejar las consultas a la base de datos a través de JPA.
la interface IConsultaPagoRepo cuenta con el método getByReferencia el cual recibe como parámetro un dato tipo String el cual representa la referencia del pago, y con el cual se realiza la consulta por número de referencia retornando un objeto tipo ResponseConsultaPagoDTO.

#### co.com.microconsulta.vo: 
En este paquete se encuentra la clase PagoPendienteVO, la cual es un una clase modelo usada para transferir datos hacia el FrontEnd

#### co.com.microconsulta.DTO: 
En este paquete se encuentra la clase ResponseConsultaPagoDTO y es la encargada de transferir objetos VO hacia el FrontEnd

#### co.com.microconsulta.helpers:
En este paquete se encuentra la clase Util, esta clase se utiliza para almacenar datos estaticos usados en la aplicación.

## MicroPago
Componente creado bajo el marco Spring Boot, el cual publica el servicio pago de tipo POST, recibiendo como parámetro un Json, con los datos del pago que se van a registrar en la base de dtaos

http://localhost:8092/registro/pago

Las conexiones a la base de datos se encuentran configuradas en el archivo aplication.properties

#### Dependencias del proyecto
spring-boot-starter-data-jpa: para la capa de persistencia
spring-boot-starter-data-rest: para realizar configuraciones de servicios Rest
postgresql: Driver de conexion para postgresSql

**El componente MicroConsultaDocumento cuenta con la siguiente paquetería:**

#### co.com.micropago:
En este paquete se encuentra la clase main del microservicio llamada MicroConsultaApplication.

#### co.com.micropago.Entity:
En este paquete se encuentras las entidades
ConsolidadoVendedorEntity
DetallePagoEntity
PagoPendienteEntity

#### co.com.micropago.controller: 
Este paquete cuenta con la clase RegistroPagoCtrl etiquetiada como @RestController y mapeada como /registro con la etiqueta @RequestMapping. Esta clase contiene el servicio que se publicará para que sea consumido.
Servicio: EL servicio creado se consume bajo el nombre de pago y recibe un Json, con los datos del pago que se van a registrar en la base de dtaos
#### JSon Request
{
    "detallePago": {
        "valor": 10000.0,
        "referencia": "12345",
        "docCliente": "14796525",
        "nombreCliente": "Fabio Hernandez Quintana",
        "docVendedor": "14796524"
    },
    "consolidadoVendedor":{
        "docVendedor":"14796524",
        "valor": 10000.0

    }
}

#### Descripcion del Json Request
 "detallePago":{,--> Objeto que encapsula los datos del detalle del pago
"valor": 10000.0, --> Valor a pagar
"referencia": "12345",--> Número de referencia de la deuda
"docCliente": "14796525",--> Documento del cliente
"nombreCliente": "Fabio",--> Nombre completo del cliente
}
"consolidadoVendedor":{-->  Objeto que encapsula los datos del consolidado del vendedor
"docVendedor":"14796524"--> Documento del vendedor
"valor": 10000.0--> valor del pago

#### JSon Response
{
    "estado": "0",
    "descripcion": "Transaccion Exitosa",
    "fehcaPago": "2020-06-30",
    "horaPago": "0:2:51",
    "detallePago": {
        "idDetallePago": 0,
        "idConsolidadoVendedor": 17,
        "fechaPago": "2020-06-30",
        "horaVenta": "0:2:51",
        "valor": 10000.0,
        "referencia": "12345",
        "docCliente": "14796525",
        "nombreCliente": "Fabio Hernandez Quintana",
        "docVendedor": "14796524"
    }
}

#### Descripcion del Json Response
"estado": "0",--> Estado de la transacción valor cero Exitosa, diferente de cero Error
"descripcion": "Transaccion Exitosa",--> Mensaje que indica explicitamente como se comportó la transaccion
"idDetallePago": 0,-->Id del detalle del pago
"idConsolidadoVendedor": 17--> id del consolidado del vendedor
"fechaPago": "2020-12-30", --> Fecha de pago
 "horaVenta": "0:2:51",--> Hora de pago
"valor": 10000.0, --> Valor a pagar
"referencia": "12345",--> Número de referencia de la deuda
"docCliente": "14796525",--> Documento del cliente
"nombreCliente": "Fabio Hernandez Quintana",--> Nombre del cliente
 "docVendedor": "14796524"--> Documento del vendedor
 
#### co.com.micropago.service: 
Este paquete cuenta con cuatro clases y cuatro interfaces:
##### IConsolidadoVendedorServ:
Interface con el método registrarConsolidadoVendedor que recibe un parámetro tipo RequestRegistroPagoDTO, y retorna un objeto tipo ConsolidadoVendedorEntity.

##### IDetallePagoServ:
Interface con los métodos:
registrarDetallePago: Método encargado de persistir en la tabla detalle pago de la base de datos. Recibe un parámetro tipo RequestRegistroPagoDTO, y retorna un objeto tipo DetallePagoEntity.

actualizarIdConsolidadoVendedor: Método encargado de actualizar la columna idConsolidadoVendedor de la tabla detalle pago. Recibe un parámetro tipo DetallePagoEntity, y retorna un objeto tipo DetallePagoEntity.

##### IPagoPendienteServ:
Interface con los métodos:
actualizarIdDetallePago: Método void encargado de actualizar la columna idDetallePago de la tabla pago pendiente. Recibe un parámetro tipo PagoPendienteEntity.

getByReferencia: Método encargado de obtener un registro de la tabla Pago pendiente por número de referencia la columna idDetallePago de la tabla pago pendiente. Recibe un parámetro tipo String que representa el número de referencia del pago y retorna un objeto de tipo PagoPendienteEntity.

##### IRegistrarPagoServ:
Interface con el método:
registarPago: Este método contiene toda la lógica para persistir un registro en la base de datos, recibe como parámetro un objeto de tipo RequestRegistroPagoDTO y retorna un objeto de tipo RequestRegistroPagoDTO

##### ConsolidadoVendedorServImpl:
Clase que implementa la interface IConsolidadoVendedorServ

##### DetallePagoServImpl:
Clase que implementa la interface IDetallePagoServ

##### PagoPendienteServImpl:
Clase que implementa la interface IPagoPendienteServ

##### RegistrarPagoServImpl:
Clase que implementa la interface IRegistrarPagoServ

#### co.com.micropago.repository: 
Este paquete cuenta con cuatro interfaces 

IConsolidadoVendedorRepo: extiende de la interface JpaRepository para manejar las consultas y registros a la base de datos a través de JPA.

IDetallePagoRepo: extiende de la interface JpaRepository para manejar las consultas y registros a la base de datos a través de JPA.

IPagoPendienteRepo: extiende de la interface JpaRepository para manejar las consultas y registros a la base de datos a través de JPA.

#### co.com.microconsulta.vo: 
En este paquete se encuentra las clases:

ConsolidadoVendedorVO: la cual es un una clase modelo usada para transferir el consolidado del vendedor hacia el FrontEnd

DetallePagoVO: la cual es un una clase modelo usada para transferir los detalles del pago hacia el FrontEnd


#### co.com.microconsulta.DTO: 
En este paquete se encuentra las clases:

RequestRegistroPagoDTO se mapea el JSon recibido desde el FrontEnd y se pasa hasta la capa repository

ResponseRegistroPagoDTO: Encargada de enviar los datos del backEnd hacia el FrontEnd
#### co.com.microconsulta.helpers:
En este paquete se encuentra la clase Util, esta clase se utiliza para almacenar datos usados en la aplicación.

## MicroPagos
Componente creado bajo el marco Spring Boot, el cual publica el servicio pago de tipo POST, recibiendo como parámetro un Json, con una lista de de pagos que se van a registrar en la base de dtaos

http://localhost:8093/registro/pagos

Las conexiones a la base de datos se encuentran configuradas en el archivo aplication.properties

#### Dependencias del proyecto
spring-boot-starter-data-jpa: para la capa de persistencia
spring-boot-starter-data-rest: para realizar configuraciones de servicios Rest
postgresql: Driver de conexion para postgresSql

**El componente MicroConsultaDocumento cuenta con la siguiente paquetería:**

#### co.com.micropago:
En este paquete se encuentra la clase main del microservicio llamada MicroConsultaApplication.

#### co.com.micropago.Entity:
En este paquete se encuentras las entidades
ConsolidadoVendedorEntity
DetallePagoEntity
PagoPendienteEntity

#### co.com.micropago.controller: 
Este paquete cuenta con la clase RegistroPagoCtrl etiquetiada como @RestController y mapeada como /registro con la etiqueta @RequestMapping. Esta clase contiene el servicio que se publicará para que sea consumido.
Servicio: EL servicio creado se consume bajo el nombre de pago y recibe un Json, con los datos del pago que se van a registrar en la base de dtaos
#### JSon Request
{
    "docVendedor":"14796532",
    "detallePagos": [
        {
            "valor": 10000.0,
            "referencia": "12345",
            "docCliente": "14796525",
            "nombreCliente": "Fabio Hernandez Quintana"
        },
        {
            "valor": 5000.0,
            "referencia": "12346",
            "docCliente": "14796525",
            "nombreCliente": "Fabio Hernandez Quintana"
        },
        {
            "valor": 3000.0,
            "referencia": "12347",
            "docCliente": "14796525",
            "nombreCliente": "Fabio Hernandez Quintana"
        }
    ]
}

#### Descripcion del Json Request
"docVendedor":"14796532",--> Documento del vendedor
 "detallePagos": [--> Arraay que contiene los objetos de tipo detalle pago
"valor": 10000.0, --> Valor a pagar
"referencia": "12345",--> Número de referencia de la deuda
"docCliente": "14796525",--> Documento del cliente
"nombreCliente": "Fabio",--> Nombre completo del cliente


#### JSon Response
{
    "estado": "0",
    "descripcion": "Transaccion Exitosa",
    "fehcaPago": "2020-06-30",
    "horaPago": "1:3:48",
    "detallePagos": [
        {
            "idDetallePago": 0,
            "idConsolidadoVendedor": 18,
            "fechaPago": "2020-06-30",
            "horaVenta": "1:3:48",
            "valor": 10000.0,
            "referencia": "12345",
            "docCliente": "14796525",
            "nombreCliente": "Fabio Hernandez Quintana",
            "docVendedor": "14796532"
        },
        {
            "idDetallePago": 0,
            "idConsolidadoVendedor": 18,
            "fechaPago": "2020-06-30",
            "horaVenta": "1:3:48",
            "valor": 5000.0,
            "referencia": "12346",
            "docCliente": "14796525",
            "nombreCliente": "Fabio Hernandez Quintana",
            "docVendedor": "14796532"
        },
        {
            "idDetallePago": 0,
            "idConsolidadoVendedor": 18,
            "fechaPago": "2020-06-30",
            "horaVenta": "1:3:48",
            "valor": 3000.0,
            "referencia": "12347",
            "docCliente": "14796525",
            "nombreCliente": "Fabio Hernandez Quintana",
            "docVendedor": "14796532"
        }
    ]
}
#### Descripcion del Json Response
"estado": "0",--> Estado de la transacción valor cero Exitosa, diferente de cero Error
"descripcion": "Transaccion Exitosa",--> Mensaje que indica explicitamente como se comportó la transaccion
"fehcaPago": "2020-06-30",--> fecha en la que se realizó el pago
"horaPago": "1:3:48",--> Hora en la que se realizó el pago
detallePagos": [--> Contiene una lista con el detalle de los pagos que se realizaron
"idDetallePago": 0,-->Id del detalle del pago
"idConsolidadoVendedor": 17--> id del consolidado del vendedor
"fechaPago": "2020-12-30", --> Fecha de pago
 "horaVenta": "0:2:51",--> Hora de pago
"valor": 10000.0, --> Valor a pagar
"referencia": "12345",--> Número de referencia de la deuda
"docCliente": "14796525",--> Documento del cliente
"nombreCliente": "Fabio Hernandez Quintana",--> Nombre del cliente
 "docVendedor": "14796524"--> Documento del vendedor

#### co.com.micropago.service: 
Este paquete cuenta con cuatro clases y cuatro interfaces:
##### IConsolidadoVendedorServ:
Interface con el método registrarConsolidadoVendedor que recibe un parámetro tipo RequestRegistroPagoDTO, y retorna un objeto tipo ConsolidadoVendedorEntity.

##### IDetallePagoServ:
Interface con los métodos:
registrarDetallePago: Método encargado de persistir en la tabla detalle pago de la base de datos. Recibe un parámetro tipo RequestRegistroPagoDTO, y retorna un objeto tipo DetallePagoEntity.

actualizarIdConsolidadoVendedor: Método encargado de actualizar la columna idConsolidadoVendedor de la tabla detalle pago. Recibe un parámetro tipo DetallePagoEntity, y retorna un objeto tipo DetallePagoEntity.

##### IPagoPendienteServ:
Interface con los métodos:
actualizarIdDetallePago: Método void encargado de actualizar la columna idDetallePago de la tabla pago pendiente. Recibe un parámetro tipo PagoPendienteEntity.

getByReferencia: Método encargado de obtener un registro de la tabla Pago pendiente por número de referencia la columna idDetallePago de la tabla pago pendiente. Recibe un parámetro tipo String que representa el número de referencia del pago y retorna un objeto de tipo PagoPendienteEntity.

##### IRegistrarPagoServ:
Interface con el método:
registarPago: Este método contiene toda la lógica para persistir un registro en la base de datos, recibe como parámetro un objeto de tipo RequestRegistroPagoDTO y retorna un objeto de tipo RequestRegistroPagoDTO

##### ConsolidadoVendedorServImpl:
Clase que implementa la interface IConsolidadoVendedorServ

##### DetallePagoServImpl:
Clase que implementa la interface IDetallePagoServ

##### PagoPendienteServImpl:
Clase que implementa la interface IPagoPendienteServ

##### RegistrarPagoServImpl:
Clase que implementa la interface IRegistrarPagoServ

#### co.com.micropago.repository: 
Este paquete cuenta con cuatro interfaces 

IConsolidadoVendedorRepo: extiende de la interface JpaRepository para manejar las consultas y registros a la base de datos a través de JPA.

IDetallePagoRepo: extiende de la interface JpaRepository para manejar las consultas y registros a la base de datos a través de JPA.

IPagoPendienteRepo: extiende de la interface JpaRepository para manejar las consultas y registros a la base de datos a través de JPA.

#### co.com.microconsulta.vo: 
En este paquete se encuentra las clases:

ConsolidadoVendedorVO: la cual es un una clase modelo usada para transferir el consolidado del vendedor hacia el FrontEnd

DetallePagoVO: la cual es un una clase modelo usada para transferir los detalles del pago hacia el FrontEnd


#### co.com.microconsulta.DTO: 
En este paquete se encuentra las clases:

RequestRegistroPagoDTO se mapea el JSon recibido desde el FrontEnd y se pasa hasta la capa repository

ResponseRegistroPagoDTO: Encargada de enviar los datos del backEnd hacia el FrontEnd
#### co.com.microconsulta.helpers:
En este paquete se encuentra la clase Util, esta clase se utiliza para almacenar datos usados en la aplicación.
