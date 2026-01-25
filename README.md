# ProyectoUD02_AD_Concesionario

# Introducción:

Nuestra aplicación esta inspirada en una compra y venta de coches de la empresa BMW, cuando una persona se registra accede como empleado y puede realizar tanto ventas como alquileres, en caso de que el cliente no este creado se podira crear a ese cliente tanto en la opcion de la nueva venta o del nuevo alquiler, asi cada vez que se genera tanto la neuva venta como el nuevo alquiler se puede gestionar la creacion de clientes 
El programa cuenta con un registro de usuarios mediante el cual podemos registrar o iniciar sesión.

# Workbench:
Utilizamos el workbench para la creacion y la modificacion de la base de datos, le pasamos el sql con toda la informacion de la base de datos.


# Estructura:
Nuestro proyecto esta planteado siguiendo el patrón MVC(Modelo,Vista,Controlador)
<img width="1920" height="1032" alt="Captura de pantalla 2026-01-23 124607" src="https://github.com/user-attachments/assets/f8b32439-9470-457f-9dc5-2b439bc80e19" />

<img width="1920" height="1032" alt="image" src="https://github.com/user-attachments/assets/32b43c89-1c81-4a0b-ad58-d46b5a2edce5" />


# Modelo:
El modelo contiene los datos del programa y define cómo estos deben ser manipulados, es decir, contiene la lógica que Interactúa respondiendo a las solicitudes del controlador para acceder o actualizar los datos. Notifica indirectamente a la vista cuando los datos han cambiado para que se actualice la presentación.


# Controlador:
El controlador recibe las entradas del usuario desde la vista y las traduce en acciones que el modelo debe ejecutar. Se encarga de interpretar las acciones del usuario, manejar los eventos, y de actualizar tanto el modelo como la vista.


# Vista:
Se encarga de la visualización de los datos del modelo de manera que el usuario los entienda es decir lo entienda.

# Metodología

Uso de Git

Este proyecto sigue una metodología de desarrollo incremental basado en ramas, lo que facilita la gestión de versiones y la colaboración de todos nosotros.

El flujo de trabajo que ha tenido nuestra Aplicación es:
<img width="1920" height="1032" alt="image" src="https://github.com/user-attachments/assets/60eaebd8-f8a8-4a67-997e-f18c73e502b7" />



Añadir Nuevas Funcionalidades: Cuando implementamos una nueva funcionalidad, se trabaja en la rama propia al paquete que pertenece. Cada uno de nosotros trabaja en una única rama, permitiendo que el trabajo avance de manera independiente.

Testeo: Una vez que se ha completado la funcionalidad, se realizan pruebas para asegurar que todo funciona correctamente y cumple con los requisitos establecidos.

Merge a Develop: Después de las pruebas exitosas, se realiza un "merge" de la rama de funcionalidad a develop. Esto es importante para comprobar la integración de la nueva funcionalidad con el resto del código del proyecto.

Merge a Main: Finalmente, cuando la versión en develop ha sido probada y es estable, se realiza un "merge" a la rama main. Esto marca el lanzamiento de una nueva versión del proyecto.

Este enfoque permite una colaboración fluida entre los dos desarrolladores, asegurando que el código sea de alta calidad y esté bien integrado antes de ser lanzado.


# Funcionamiento del Programa:

El funcionamiento de la aplicación es el siguiente, al iniciar la aplicacion nos debemos de registar para poder acceder a las demas funcionalidades de la app, cuando entramos a la app accedemos como empleados para poder tener acceso a todos los campos de la misma, podremos mostrar todas las ventas que tiene nuestro concesionario, crear una nueva venta, dentro de esta en caso de que el cliente no este registrado podemos crearlo en el momento , para poder asi seguir realizando la venta, en el apartado de alquileres tenemos la misma opcion de ver todas los registros de alquiler de nuestro concesionario, tambien podemos crear un nuevo alquiler, como pasa en el caso de venta tambien se puede crear un cliente para podeer realizar el alquiler y en la tabla de coches aparece una lista de todos los coches que tenemos en el concesionario, mostrando toda la informacion del vehiculo, para que en caso de que un cliente no este seguro de la compra que quiere hacer puede ver todos los modelos para decidir asi cual es la mejor opcion para el.

# Pantalla principal de la app 
<img width="656" height="452" alt="vistaInicial" src="https://github.com/user-attachments/assets/c2bd3f0a-d03f-4b43-a0f9-f1c797b3bbd0" />

# Registro de usuarios
<img width="622" height="630" alt="login2" src="https://github.com/user-attachments/assets/5af8e679-4d43-4d4e-9cf0-e346672f7f30" />

Una vez rellandos los campos usaremos el nombre de usario y la contraseña para poder acceder a todas la funcionalidades del programa 

# Logeo de Usuarios
En caso de que la persona intente entrar sin intorducir ninguna credencial el programa dara el siguiente error
<img width="807" height="667" alt="LoginVacio" src="https://github.com/user-attachments/assets/c4a2514d-7844-4a18-a6a1-6b1a91bd5f0f" />


<img width="647" height="537" alt="login4" src="https://github.com/user-attachments/assets/3776b257-0e2b-4435-af38-29f00474434b" />

Una vez iniciada la sesion con el usuario corespondiente aparece la pantalla con todas sus funcionalidades

<img width="658" height="457" alt="VistaPostLogin" src="https://github.com/user-attachments/assets/fe948173-b4c1-4e1b-88c9-3e5c2fac9e31" />

En caso de que el usuario quiera cambiar la contraseña debera hacer lo siguiente: introducira la nueva contraseña y le dara al boton de cambiar contraseña 

<img width="657" height="457" alt="CambioContraseña" src="https://github.com/user-attachments/assets/d94fd4ba-d13e-412b-bb74-4aa2163b2ba3" />
<img width="657" height="455" alt="AvisoCambioContraseña" src="https://github.com/user-attachments/assets/3fdf95dd-9f53-48b0-9877-39fab062c414" />



# Mostramos todas las ventas 
<img width="823" height="511" alt="Ventas1" src="https://github.com/user-attachments/assets/2e888208-91c3-4eac-b4cf-cf03fa3cc85a" />

Una vez lanzamos el apartado de ventas por defecto no aparece ninguna venta

# Generamos una nueva venta
Para generar una nueva venta le damos al boton de nueva venta y nos mostrara la siguiente ventana 

<img width="471" height="330" alt="ventas2" src="https://github.com/user-attachments/assets/a28f139f-86ca-4daa-955c-17266d6dae2d" />

Cuando queremos hacer una nueva venta para que este registrada tendremos que rellenar cada uno de los campos, en caso de que el cliente no este creado y intentemos crear la venta nos dara el siguiente error 

<img width="470" height="326" alt="VentaConClienteQueNoExiste" src="https://github.com/user-attachments/assets/6cb72528-1663-4a15-bfbf-edaacb8f337e" />

<img width="481" height="327" alt="VentaConClienteQueNoExisteError" src="https://github.com/user-attachments/assets/e428f23e-9186-4493-93a2-956c6da56784" />

# Creamos un nuevo Cliente
Para crear un nuevo cliente pulsaremos el boton de nuevo cliente y nos aparecera la interfaz para crearlo 

<img width="420" height="332" alt="CreacionCliente" src="https://github.com/user-attachments/assets/9cf95075-9e73-4c73-a84b-f3758dd65d7a" />
<img width="417" height="331" alt="CreacionCLiente2" src="https://github.com/user-attachments/assets/66c760f1-91ef-4b60-aa1c-1600b8bb855a" />

Ahora una vez que el cliente esta creado correctamente podremos generar correctamente la nueva venta 

<img width="472" height="327" alt="VentaConClienteExistente" src="https://github.com/user-attachments/assets/399b0471-b5de-43c1-8bf9-7e3f4bbc0a85" />
<img width="473" height="330" alt="VentaCreadaConExito" src="https://github.com/user-attachments/assets/32d9ae85-11eb-48a1-90df-382b77ece9d2" />


# Borramos los datos de una venta especifica 
Para borar los datos de una venta selecionamos la venta especifica que queremos borar y pulsamos el boton de borar y en el mismo momento la tabla se actualiza para dejar el resto de las ventas en caso de que haya alguna venta mas 



# Mostramos todos los alquileres
Una vez lanzamos el apartado de alquileres por defecto no aparece ningun alquiler
<img width="892" height="517" alt="VistaAlquileres" src="https://github.com/user-attachments/assets/ebb80dd0-7ab4-4edc-b2ea-42bfdf607e6b" />



# Creamos un nuevo alquiler 
Para generar una nuevo alquiler le damos al boton de nuevo alquiler y nos mostrara la siguiente ventana 
<img width="527" height="387" alt="NuevoAlquiler" src="https://github.com/user-attachments/assets/0b6c0e02-5753-4e8c-9008-d3c1f48d87c8" />
<img width="527" height="385" alt="AlquilerCreadoConExito" src="https://github.com/user-attachments/assets/c85d025e-24b2-46c6-8e95-8f4587085207" />
<img width="893" height="520" alt="VistaAlquileresConAlquileres" src="https://github.com/user-attachments/assets/c090afd5-eee3-4f48-8cd2-b4dc604558e0" />
<img width="895" height="522" alt="BorrarAlquiler" src="https://github.com/user-attachments/assets/96a67d40-e157-4cd8-ba6e-b7d9c4da4ae1" />


Pulsamos en el boton de eliminar en caso de querer borrarlo y si no lo queremos borrar en cancelar 
<img width="2555" height="1390" alt="Captura de pantalla 2025-11-18 200419" src="https://github.com/user-attachments/assets/142abddb-85f4-4a26-8be5-240f1f5b280c" />

# Mostramos todos los coches

<img width="952" height="651" alt="VistaCoches" src="https://github.com/user-attachments/assets/2977cef8-2aa1-450a-ad07-1322647c079d" />

<img width="907" height="658" alt="CochesDespuesDeBorrarElAlquiler" src="https://github.com/user-attachments/assets/fb5e678e-6c39-4c6a-bb1e-e00f47be5866" />


# Reparto de tareas:
A la hora de dividir el trabajo nos repartimos de la siguiente manera: 

Juanjo hizo las vistas el diseño de la base de datos  
Fran hizo la lectura de la Api y algunos controladores
Angel hizo el modelo y otros controladores

De esta manera cada uno fue haciendo los commits necesarios para que la aplicación fuera avanzando al mismo tiempo que se seguía trabajando en ella.


# Mejoras:
Algunas mejoras que podríamos implementar si tuviéramos mas tiempo son las siguientes:

Usar un layout para que la pantalla del programa se redimensione automáticamente a la pantalla en la que esta siendo mostrada 
Cambiar algunos JLabel por JTextField ya que en la mayoría de las vistas 
Mejorar el filtrado de datos erróneos en la creación 



# Conclusiones: 




# Créditos:
  Francisco Alende Antelo(a24francisco)
  
  Juan José Dorado Maquieira(a24juandm)

  Ángel Gestoso Agrelo(angel2ga)
