# HelpFuzzyChat
Tema: asistentes virtuales inteligentes (Chatbots)

Integrantes:

- **Sergio Esteban Cabrera Eraso.**
- **Kevin Andrés Molano Gamarra.**
- **Julián Ospina Murgueitio.**

1. #### Planteamiento del problema:
   > En varias ocasiones, usuarios que desean adquirir un PC no tienen los conocimientos necesarios para sacar el mayor provecho de los componentes y se llegan 
   a dos posibles situaciones: la máquina que adquieren puede ser muy costosa para las tareas básicas en las cuales serán usadas y puede significar una pérdida de 
   dinero considerable; por otro lado, contrario al anterior caso, los componentes pueden ser muy básicos para las tareas a las cuales pretende desempeñarse. 
   De esta manera, se puede llegar a casos en los que, por ejemplo, una persona requiera un computador solo para utilizar herramientas de office y adquiera uno 
   con una tarjeta gráfica que sirva para correr juegos de última generación, cuando en realidad no la necesita y eso solo aumenta el precio; y está el otro caso 
   en el que alguien necesita un computador para ejecutar redes neuronales con múltiples iteraciones y capas y adquiera uno con procesador de los años 90. Dicho esto, 
   vemos que hace falta asesoramiento frente al tema de la adquisición de productos tecnológicos, en este caso PCs
   ##### Función principal:
   > El sistema tiene como objetivo brindar asesoría a los clientes a la hora de escoger un PC para las actividades que ellos requieran. El usuario conversará con 
   el sistema describiendo mediante una serie de pasos las características y/o componentes del PC que desea adquirir y de esta manera, el sistema definirá si el 
   computador es apto o es adecuado para las tareas que desea realizar.
   
2. #### Problema a resolver:
   - ##### Razones para utilizar lógica difusa en la solución:
     - Dada que la utilidad de los componentes de un computador depende mucho del campo de acción en el cual se usará el PC y que la lógica difusa les da valor cualitativo a los parámetros cuantitativos quisimos definir esa utilidad de los componentes basados en nuestra experiencia y lo que hemos visto de carrera.
     - En muchos casos la persona que quiere comprar estos equipos no tiene los conocimientos de los componentes de un PC y no toman en cuenta el campo de acción donde será usado, de manera que quisimos pasar estos componentes a términos más sencillos en donde puedan entender sin términos técnicos si es suficiente los componentes para su área de trabajo.
     - A pesar de que existen personas que tienen conocimiento acerca de la información de los componentes de su PC, esto también tiende a ser algo subjetivo y la opinión respecto a un componente puede variar dependiendo de la persona.

   - #### Nombre del Sistema:
     - FIS_E-HelpChatbot.
3. #### Descripción del FIS:
   - Variables Lingüísticas de Entrada y de Salida y sus respectivos Universos de discurso
   ```
   FUZZIFY procesador
      TERM malo := (-2, 0.5) (2, 1) (8.5,0) ;
      TERM medio := (6.5, 0) (11,1) (15.5,0);
      TERM alto := (12.5, 0) (18, 1) (22,0);
   END_FUZZIFY
   ```
   
   ```
   FUZZIFY ram
      TERM mala := (0, 0.5) (4, 1) (6.5, 0);
      TERM media := (3.5,0) (10,1)  (17.5,0);
      TERM alta := (13.5,0) (20,1) (29,0);
   END_FUZZIFY
   ```
   
   ```
   FUZZIFY capacidad_gpu
      TERM mala := (-0.5, 0) (3.5, 1) (7.5, 0) ;
      TERM media := (4,0) (9,1) (13,0);
      TERM alta := (9,0) (18,1) (26,0);
   END_FUZZIFY
   ```
   
   ```
   FUZZIFY nucleos_procesador
      TERM malo := (-3, 0) (3, 1) (4.5, 0) ;
      TERM medio := (3.5,0) (7,1) (9,0);
      TERM alta := (7,0) (10,1) (14,0);
   END_FUZZIFY
   ```
   
   ```
   FUZZIFY rom
      TERM mala := (0, 0) (256, 1) (300, 0) ;
      TERM media := (100,0) (780,1) (1300,0);
      TERM alta := (1000,0) (2050,1) (5100,0);
   END_FUZZIFY
   ```
   
   ```
   FUZZIFY campos_de_uso
      TERM noExigente := (-1, 0) (2, 1) (5.5, 0) ;
      TERM medioExigente := (3.5,0) (6,1) (7.5,0);
      TERM exigente := (6.5,0) (9,1) (10,0);
   END_FUZZIFY
   ```
   ```
   DEFUZZIFY suficiencia_pc
      TERM muy_mediocre := (0,0)(3,1)(6,0);
      TERM mediocre  :=  (5,0)(8,1)(10,1)(12,0);
      TERM normal  :=  (11,0)(14,1)(16,1)(18,0);
      TERM calificado  := (17,0)(20,1)(22,1)(24,0);
      TERM sobre_calificado := (23,0)(27,1)(30,0);
   END_DEFUZZIFY
   ```
   
   - **Explicación semántica de la construcción de las Reglas:**
   > Como nuestro sistema de Lógica Difusa toma en cuenta los componentes del computador que el usuario ingresa, y teniendo en cuenta que la principal cualidad de un PC es su procesador y su memoria RAM, decidimos las reglas por estos dos componente teniendo en cuenta su campo de uso, ya sea exigente, medio_exigente y no_exigente, por lo que pudimos depurar gran mayoria de las combinaciones entre las variables que se podían lograr, a su vez, cabe aclarar que adaptamos las variables de entrada a términos numéricos discretos, que se relacionan con cada variable lingüística de entrada, como por ejemplo el procesador 1 es Intel Celeron, así con las demás variables que requieren nombres propios como entrada y que presentaban un problema cuando el usuario no digitaba de forma correcta el nombre de dicha variable.


4. #### Despliegue del FIS con Interfaces Gráficas.
     [![carbon-31.png](https://i.postimg.cc/yxsVTCGx/carbon-31.png)](https://postimg.cc/9Rg5WKCH)
     [![carbon-30.png](https://i.postimg.cc/dVxrN5ww/carbon-30.png)](https://postimg.cc/68C8yL8m)
     [![carbon-28.png](https://i.postimg.cc/fRCt1BsJ/carbon-28.png)](https://postimg.cc/Jsyzk3GL)
     
     
