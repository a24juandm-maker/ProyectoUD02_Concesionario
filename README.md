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
<img width="1920" height="1032" alt="image" src="https://github.com/user-attachments/assets/cf177046-b25d-471b-8429-20c5fe46450d" />

# Registro de usuarios
<img width="1920" height="1032" alt="image" src="https://github.com/user-attachments/assets/ab69ae52-8609-431d-ae90-b379ac4e70a7" />
Una vez rellandos los campos usaremos el nombre de usario y la contraseña para poder acceder a todas la funcionalidades del programa 

# Logeo de Usuarios

<img width="2559" height="1389" alt="Captura de pantalla 2025-11-19 192743" src="https://github.com/user-attachments/assets/82787240-0d60-4bbc-8d43-a076dcd5659b" />
El programa detecta cuales de los personajes empiezan o contienen las letras que escribimos en el buscador y va deshabilitando al resto 

# Mostramos todas las ventas 
<img width="2559" height="1391" alt="Captura de pantalla 2025-11-19 192754" src="https://github.com/user-attachments/assets/470b77d8-24b8-4a40-ab82-387f7fad0d9e" />

En este caso solo saldrán los personajes que tienen dicho rol 

# Generamos una nueva venta

<img width="280" height="221" alt="Captura de pantalla 2025-11-19 192820" src="https://github.com/user-attachments/assets/1fdbb5ef-2881-4a7d-b47b-16298cf69096" /> 
<img width="260" height="214" alt="Captura de pantalla 2025-11-19 192830" src="https://github.com/user-attachments/assets/e79ad5b0-5071-40b7-8856-6bb272738955" />
<img width="262" height="208" alt="Captura de pantalla 2025-11-19 192852" src="https://github.com/user-attachments/assets/42a69998-eaad-4186-ba9a-9de927d0934f" />
<img width="266" height="121" alt="Captura de pantalla 2025-11-19 192908" src="https://github.com/user-attachments/assets/aa200cfd-d371-4d86-870f-37aa849e8d25" />




# Creamos un nuevo Cliente

Al presionar en cada agente aparecerá una foto de su cuerpo entero, una descripción del personaje y sus correspondientes habilidades con sus respectivas imágenes de cada habilidad junto a lo que hace cada habilidad
<img width="1922" height="1034" alt="image" src="https://github.com/user-attachments/assets/c5d153cc-4521-423d-aef6-c9e02017a61f" />
<img width="2552" height="1389" alt="Captura de pantalla 2025-11-18 200107" src="https://github.com/user-attachments/assets/13a48d32-a719-48f9-b440-4c91da79217b" />

# Borramos los datos de una venta especifica 
Pulsamos en el botón de crear y se nos abre la siguiente ventana para la creación del nuevo personaje
<img width="2556" height="1389" alt="Captura de pantalla 2025-11-18 200821" src="https://github.com/user-attachments/assets/eb41ba9d-9dd2-4024-9288-63ffe7a32d1b" />



# Mostramos todos los alquileres
Clickamos en el personaje que deseamos editar y se nos abrirá una ventana con todos los datos iniciales del personaje para que nosotros podamos modificarlo
<img width="2552" height="1385" alt="Captura de pantalla 2025-11-18 200251" src="https://github.com/user-attachments/assets/d347c722-f35e-44d1-bd63-c063d2c8f887" />

Una vez acabamos de modificar el personaje aparecerá una ventana que guardara los cambios que hayamos hecho 
<img width="2551" height="1391" alt="Captura de pantalla 2025-11-18 200335" src="https://github.com/user-attachments/assets/9c6fe838-9a2a-455b-9936-991c276eaf20" />

Si volvemos a clickar en el personaje este aparecerá con los cambios realizados anteriormente
<img width="2552" height="1391" alt="Captura de pantalla 2025-11-18 200348" src="https://github.com/user-attachments/assets/c6c1e21a-9057-404c-8371-e1a9c44a0c32" />

# Creamos un nuevo alquiler 
Pulsamos en el botón de eliminar, aparece una ventana en la cual se nos pide que introduzcamos un nombre para borrar ese personaje
<img width="2552" height="1390" alt="Captura de pantalla 2025-11-18 200407" src="https://github.com/user-attachments/assets/d9931464-eb9e-459c-b9aa-5ac47847cd24" />

Pulsamos en el boton de eliminar en caso de querer borrarlo y si no lo queremos borrar en cancelar 
<img width="2555" height="1390" alt="Captura de pantalla 2025-11-18 200419" src="https://github.com/user-attachments/assets/142abddb-85f4-4a26-8be5-240f1f5b280c" />

# Mostramos todos los coches




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
