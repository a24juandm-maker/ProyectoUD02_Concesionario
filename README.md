# ProyectoUD02_AD_Concesionario
**Índice**   
 
- [Introducción](#introducción)
- [Manual técnico](#manual-técnico)
- [Estructura](#estructura)
- [Metodología](#metodología)
- [Funcionamiento del programa](#funcionamiento-del-programa)
- [Reparto de tareas](#reparto-de-tareas)
- [Código a destacar](#código-a-destacar)
- [Mejoras](#mejoras)
- [Conclusiones](#conclusiones)

## Introducción

Nuestra aplicación está inspirada en un concesionario de la marca BMW en el cual se podrán realizar las operaciones de venta y alquiler  de vehiculos. Cuando un trabajador se registra en la aplicación, accede como empleado y puede realizar la gestión de  ventas , alquileres y creación de clientes.

## Manual técnico

- **Java SE 17 o superior:** El proyecto se ha desarrollado usando la version 17 de Java, lo cual se requiere usar la misma version o superior
- **Maven:** La gestión de las dependencias se hace con Maven, lo cual se deberá tener Maven instalado.
- **IDE Recomendado:** Para este proyecto se ha usado Apache NetBeans como IDE pero se puede usar cualquiera que soporte el lenguaje de Java.
- **Workbench:** Utilizamos el workbench para la creación y gestión de los campos de base de datos.
- **mysql-connector-j-8.1.0:** Utilizado para acceder a la base de datos desde Java. 

## Estructura
Nuestro proyecto esta planteado siguiendo el patrón MVC(Modelo,Vista,Controlador)
<img width="1920" height="1032" alt="Captura de pantalla 2026-01-23 124607" src="https://github.com/user-attachments/assets/f8b32439-9470-457f-9dc5-2b439bc80e19" />

<img width="1920" height="1032" alt="image" src="https://github.com/user-attachments/assets/32b43c89-1c81-4a0b-ad58-d46b5a2edce5" />


### Modelo
El modelo contiene los datos del programa y define cómo estos deben ser manipulados, es decir, contiene la lógica que interactúa respondiendo a las solicitudes del controlador para acceder o actualizar los datos. Notifica indirectamente a la vista cuando los datos han cambiado para que se actualice la presentación. 
Nuestro modelo esta compuesto de los diferentes POJOS de las clases principales de la aplicación  y de la clase **ConexionBD** desde la cual gestionamos la comunicación con la base de datos: manejamos toda la conexión , introducción y consulta de datos, gestión de usuarios...
 


### Controlador
El controlador recibe las entradas del usuario desde la vista y las traduce en acciones que el modelo debe ejecutar. Se encarga de interpretar las acciones del usuario, manejar los eventos, y de actualizar tanto el modelo como la vista. Nuestro controlador consta de las siguientes clases:
- **FrontController**:controlador principal de la aplicación,encargado de coordinar.
- **AlquileresController**:Gestiona la tabla de alquileres y la opción de eliminar un alquiler.
- **NuevoAlquilerController**: Gestiona la creacion de nuevos alquileres.
- **ClienteController**:Gestiona la creacion de clientes.
- **CochesController**:Gestiona la visualizacion y actualizaciob tabla de coches. 
- **LoginController**: Gestiona la validacion de credenciales para iniciar sesión.
- **RegistroController**:Gestiona la creacion de un nuevo usuario de la aplicación.
- **NuevaVentaController**:Gestiona la creacion de ventas.
- **VentasController**: Gestiona la visualizacion ,actualizacion y eliminacion de las ventas.




### Vista
Se encarga de la mostrar los datos del modelo de manera que el usuario pueda interactuar con ellos de manera sencilla. Nuestras vistas estan compuestas de las siguientes clases:
- **MainJFrame**: Ventana principal de la aplicación.
- **NuevoAlquilerJDialog**: Interfaz para introducir los datos para un nuevo alquiler.
- **TablaAlquileresJDialog**: Ventana donde se muestran todos los alquileres realizados.
- **TablaCochesJDialog**: Interfaz para mostrar las información de los  coches: disponibilidad,fabricación...
- **NuevoClienteJDialog**: Interfaz para introducir los datos de un nuevo cliente.
- **NuevaVentaJDialog**:Interfaz para introducir los datos para una nueva venta.
- **TablaVentasJDialog**: Ventana donde veremos todos las ventas realizados.
- **LoginJDialog**: Interfaz para el inicio de sesión de los usuarios.
- **UserJDialog**: Interfaz para la creación de nuevos usuarios.


## Metodología

Uso de Git

Este proyecto sigue una metodología de desarrollo incremental basado en ramas, lo que facilita la gestión de versiones y la colaboración de todos nosotros.

El flujo de trabajo que ha tenido nuestra Aplicación es:
<img width="1920" height="1032" alt="image" src="https://github.com/user-attachments/assets/60eaebd8-f8a8-4a67-997e-f18c73e502b7" />



Añadir Nuevas Funcionalidades: Cuando implementamos una nueva funcionalidad, se trabaja en la rama propia al paquete que pertenece. Cada uno de nosotros trabaja en una única rama, permitiendo que el trabajo avance de manera independiente.

Testeo: Una vez que se ha completado la funcionalidad, se realizan pruebas para asegurar que todo funciona correctamente y cumple con los requisitos establecidos.

Merge a Develop: Después de las pruebas exitosas, se realiza un "merge" de la rama de funcionalidad a develop. Esto es importante para comprobar la integración de la nueva funcionalidad con el resto del código del proyecto.

Merge a Main: Finalmente, cuando la versión en develop ha sido probada y es estable, se realiza un "merge" a la rama main. Esto marca el lanzamiento de una nueva versión del proyecto.

Este enfoque permite una colaboración fluida entre los dos desarrolladores, asegurando que el código sea de alta calidad y esté bien integrado antes de ser lanzado.


## Funcionamiento del Programa

En este apartado se describe el funcionamiento del programa. La aplicación esta diseñada para utilizarla desdde el punto de vista de un empleado para poder realizar las gestiones necesarias

El funcionamiento de la aplicación sería:

### Pantalla inicial de la app 

<img width="656" height="452" alt="vistaInicial" src="https://github.com/user-attachments/assets/c2bd3f0a-d03f-4b43-a0f9-f1c797b3bbd0" />

Al iniciar la aplicación se muestra la siguiente pantalla,en la cual el usuario debera pulsar el botón "Login" para poder acceder al sistema.

### Registro de usuarios

<img width="805" height="669" alt="a" src="https://github.com/user-attachments/assets/468ad82a-e15a-4811-9f6c-344f5b09e52e" />

Al acceder a la opción de "Registrarse", se mostrara una ventana donde el trabajador debe introducir sus datos para crear una cuenta.


<img width="622" height="630" alt="login2" src="https://github.com/user-attachments/assets/5af8e679-4d43-4d4e-9cf0-e346672f7f30" />

<img width="620" height="630" alt="login3" src="https://github.com/user-attachments/assets/20d58f99-9328-4ed3-a093-c2af3464924b" />

Si el usuario se registra con exito saldra este aviso y despues de eso pasaremos a logearnos.
En el caso de que el usuario ya exista nos mostraria el siguiente mensaje.

<img width="772" height="785" alt="Captura de pantalla 2026-01-30 225153" src="https://github.com/user-attachments/assets/8c5494e5-b57f-492e-8ff2-9f81d1046e98" />


### Inicio de sesión

Al intentar entrar sin introducir las credenciales o introduciendo datos incorrectos , la aplicación mostrará un mensaje de advertencia indicando el error.

<img width="807" height="667" alt="LoginVacio" src="https://github.com/user-attachments/assets/c4a2514d-7844-4a18-a6a1-6b1a91bd5f0f" />


<img width="647" height="537" alt="login4" src="https://github.com/user-attachments/assets/3776b257-0e2b-4435-af38-29f00474434b" />

Una vez iniciada la sesion con un usuario valido  aparecere la pantalla con todas sus funcionalidades.

<img width="658" height="457" alt="VistaPostLogin" src="https://github.com/user-attachments/assets/fe948173-b4c1-4e1b-88c9-3e5c2fac9e31" />

En caso de que el usuario quiera cambiar la contraseña debera  introducirla y presionar el boton de "Cambiar contraseña" 

<img width="657" height="457" alt="CambioContraseña" src="https://github.com/user-attachments/assets/d94fd4ba-d13e-412b-bb74-4aa2163b2ba3" />

<img width="657" height="455" alt="AvisoCambioContraseña" src="https://github.com/user-attachments/assets/3fdf95dd-9f53-48b0-9877-39fab062c414" />



### Ventas
Al acceder al apartado de ventas, la aplicación muestra una tabla con la informacion de las ventas.

<img width="823" height="511" alt="Ventas1" src="https://github.com/user-attachments/assets/2e888208-91c3-4eac-b4cf-cf03fa3cc85a" />

#### Generamos una nueva venta
Para generar una nueva venta , el usuario pulsará el boton "Nueva venta" lo que abrira el una ventana para introducir los datos de esta.

<img width="471" height="330" alt="ventas2" src="https://github.com/user-attachments/assets/a28f139f-86ca-4daa-955c-17266d6dae2d" />

Para que se pueda crear correctamente es obligatorio rellenar todos los campos. En caso de que no exista el cliente , habria que crearlo.

<img width="470" height="326" alt="VentaConClienteQueNoExiste" src="https://github.com/user-attachments/assets/6cb72528-1663-4a15-bfbf-edaacb8f337e" />

<img width="481" height="327" alt="VentaConClienteQueNoExisteError" src="https://github.com/user-attachments/assets/e428f23e-9186-4493-93a2-956c6da56784" />

Si todos los datos son correctos , la venta se registra de manera exitosa y se muestra el siguiente mensaje y el estado del coche pasaria a no disponible.

<img width="472" height="327" alt="VentaConClienteExistente" src="https://github.com/user-attachments/assets/399b0471-b5de-43c1-8bf9-7e3f4bbc0a85" />

<img width="473" height="330" alt="VentaCreadaConExito" src="https://github.com/user-attachments/assets/32d9ae85-11eb-48a1-90df-382b77ece9d2" />

Una vez finalizado , la tabla se actualizaría con la nueva venta.

<img width="825" height="508" alt="actualizacionventas" src="https://github.com/user-attachments/assets/6a3678df-c511-47ca-89c1-5215fcce6e01" />

#### Borrar venta
 Para eliminar una venta, el usuario deberá seleccionar la venta en la tabla y pulsar el botón de "Borrar". Una vez confirmada la acción la venta se eliminará del sistema y la tabla y el estado del coche se actualizaran de manera automatica
 <img width="1030" height="636" alt="Captura de pantalla 2026-01-25 184633" src="https://github.com/user-attachments/assets/073870cb-5363-4c66-9157-9a54deaa0e81" />


### Clientes
Para crear un nuevo cliente pulsaremos el boton de "Nuevo cliente" lo que abrira una  interfaz para introducir los datos necesarios.
Una vez completado el formulario, el cliente pasara a formar parte la base de datos y ya podra realizar tanto compras como alquileres.

<img width="420" height="332" alt="CreacionCliente" src="https://github.com/user-attachments/assets/9cf95075-9e73-4c73-a84b-f3758dd65d7a" />

<img width="417" height="331" alt="CreacionCLiente2" src="https://github.com/user-attachments/assets/66c760f1-91ef-4b60-aa1c-1600b8bb855a" />

### Alquileres
Una vez lanzamos el apartado de alquileres por defecto no aparece ningun alquiler
<img width="892" height="517" alt="VistaAlquileres" src="https://github.com/user-attachments/assets/ebb80dd0-7ab4-4edc-b2ea-42bfdf607e6b" />



#### Creamos un nuevo alquiler 
Para generar un nuevo alquiler , el usuario debera pulsar el botón "Nuevo alquiler", lo que abrira la ventana para introducir los datos de esta operación.
El proceso es igual al de una venta por lo tanto tienen que estar todos los campos rellenados y el cliente y el coche disponible.

<img width="527" height="387" alt="NuevoAlquiler" src="https://github.com/user-attachments/assets/0b6c0e02-5753-4e8c-9008-d3c1f48d87c8" />

Una vez introducidos los datos correctamente , el sistema mostrará un mensaje de confirmación.

<img width="527" height="385" alt="AlquilerCreadoConExito" src="https://github.com/user-attachments/assets/c85d025e-24b2-46c6-8e95-8f4587085207" />

La tabla se actualizará de manera automatica.

<img width="893" height="520" alt="VistaAlquileresConAlquileres" src="https://github.com/user-attachments/assets/c090afd5-eee3-4f48-8cd2-b4dc604558e0" />


#### Borrar alquiler

 Para eliminar una lquiler, el usuario deberá seleccionar el alquiler en la tabla y pulsar el botón de "Borrar". Una vez confirmada la acción, el alquiler se eliminara del sistema y la tabla y el estado del coche se actualizaran de manera automatica
 
<img width="895" height="522" alt="BorrarAlquiler" src="https://github.com/user-attachments/assets/96a67d40-e157-4cd8-ba6e-b7d9c4da4ae1" />


### Coches

Se muestra una tabla con la información de los coches sobre los coches del concesionario. Desde aqui el trabajador y el cliente pueden comprobar toda la información de los vehiculos asi como las caracteristicas de disponibilidad. 

<img width="1136" height="825" alt="cambio" src="https://github.com/user-attachments/assets/1fb0cf87-a415-4b0e-a3ef-d5f917b69764" />


## Código a destacar

- Verificación de usuario

<img width="882" height="436" alt="image" src="https://github.com/user-attachments/assets/456e7b0e-22c4-4198-aa20-a7837bf90e71" />

- Creación de ventas y de alquileres

  <img width="1246" height="615" alt="image" src="https://github.com/user-attachments/assets/bdfac228-0c3f-4af0-bad2-062537d950af" />



## Reparto de tareas


Juanjo hizo las vistas el diseño de la base de datos  
Fran hizo la lectura de la Api y algunos controladores
Angel hizo el modelo y otros controladores

De esta manera cada uno fue haciendo los commits necesarios para que la aplicación fuera avanzando al mismo tiempo que se seguía trabajando en ella.


## Mejoras
Algunas mejoras que podríamos implementar si tuviéramos mas tiempo son las siguientes:

- Usar un layout para que la pantalla del programa se redimensione automáticamente a la pantalla en la que esta siendo mostrada 
- Cambiar algunos JLabel por JTextField ya que en la mayoría de las vistas 
- Mejorar el filtrado de datos erróneos en la creación
- Filtrar los datos introducidos como puede ser DNI o número de teléfono
- Poder seleccionar el cliente si ya esta creado al crear una venta o alquiler
- Cambiar el formato de las fechas




## Conclusiones




## Créditos
  Francisco Alende Antelo(a24francisco)
  
  Juan José Dorado Maquieira(a24juandm)

  Ángel Gestoso Agrelo(angel2ga)




## Créditos
  Francisco Alende Antelo(a24francisco)
  
  Juan José Dorado Maquieira(a24juandm)

  Ángel Gestoso Agrelo(angel2ga)
