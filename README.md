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
   
    
   - Reglas de inferencia difusa.
    ```
     RULE 1 : If procesador is malo and ram is mala and capacidad_gpu is mala and nucleos_procesador is malo and rom is mala and campos_de_uso is noExigente then                suficiencia_pc is normal ;
     RULE 2 : If procesador is malo and ram is mala and capacidad_gpu is mala and nucleos_procesador is malo and rom is mala and campos_de_uso is medioExigente then              suficiencia_pc is mediocre ;
     RULE 3 : If procesador is malo and ram is mala and capacidad_gpu is mala and nucleos_procesador is malo and rom is mala and campos_de_uso is exigente then                  suficiencia_pc is muy_mediocre ;
     RULE 4 : If procesador is malo and ram is mala and capacidad_gpu is mala and nucleos_procesador is malo and rom is media and campos_de_uso is noExigente then suficiencia_pc is calificado ;
     RULE 5 : If procesador is malo and ram is mala and capacidad_gpu is mala and nucleos_procesador is malo and rom is media and campos_de_uso is medioExigente then suficiencia_pc is mediocre ;
     RULE 6 : If procesador is malo and ram is mala and capacidad_gpu is mala and nucleos_procesador is malo and rom is media and campos_de_uso is exigente then suficiencia_pc is muy_mediocre ;
     RULE 7 : If procesador is malo and ram is mala and capacidad_gpu is mala and nucleos_procesador is malo and rom is alta and campos_de_uso is noExigente then suficiencia_pc is sobre_calificado ;
     RULE 8 : If procesador is malo and ram is mala and capacidad_gpu is mala and nucleos_procesador is malo and rom is alta and campos_de_uso is medioExigente then suficiencia_pc is mediocre ;
     RULE 9 : If procesador is malo and ram is mala and capacidad_gpu is mala and nucleos_procesador is malo and rom is alta and campos_de_uso is exigente then suficiencia_pc is muy_mediocre ;
     RULE 10 : If procesador is malo and ram is mala and campos_de_uso is noExigente then suficiencia_pc is normal ;
     RULE 11 : If procesador is malo and ram is mala and campos_de_uso is medioExigente then suficiencia_pc is muy_mediocre ;
     RULE 12 : If procesador is malo and ram is mala and campos_de_uso is exigente then suficiencia_pc is muy_mediocre ;
     RULE 13 : If procesador is malo and ram is alta and campos_de_uso is noExigente then suficiencia_pc is calificado ;
     RULE 14 : If procesador is malo and ram is alta and campos_de_uso is medioExigente then suficiencia_pc is mediocre ;
     RULE 15 : If procesador is malo and ram is alta and campos_de_uso is exigente then suficiencia_pc is muy_mediocre ;
     RULE 16 : If procesador is medio and ram is media and capacidad_gpu is mala and nucleos_procesador is alta and rom is mala and campos_de_uso is noExigente then suficiencia_pc is normal ;
     RULE 17 : If procesador is medio and ram is media and capacidad_gpu is mala and nucleos_procesador is alta and rom is mala and campos_de_uso is medioExigente then suficiencia_pc is mediocre ;
     RULE 18 : If procesador is medio and ram is media and capacidad_gpu is mala and nucleos_procesador is alta and rom is mala and campos_de_uso is exigente then suficiencia_pc is muy_mediocre ;
     RULE 19 : If procesador is medio and ram is media and capacidad_gpu is mala and nucleos_procesador is alta and rom is media and campos_de_uso is noExigente then suficiencia_pc is normal ;
     RULE 20 : If procesador is medio and ram is media and capacidad_gpu is mala and nucleos_procesador is alta and rom is media and campos_de_uso is medioExigente then suficiencia_pc is mediocre ;
     RULE 21 : If procesador is medio and ram is media and capacidad_gpu is mala and nucleos_procesador is alta and rom is media and campos_de_uso is exigente then suficiencia_pc is muy_mediocre ;
     RULE 22 : If procesador is medio and ram is media and capacidad_gpu is mala and nucleos_procesador is alta and rom is alta and campos_de_uso is noExigente then suficiencia_pc is normal ;
     RULE 23 : If procesador is medio and ram is media and capacidad_gpu is mala and nucleos_procesador is alta and rom is alta and campos_de_uso is medioExigente then suficiencia_pc is normal ;
     RULE 24 : If procesador is medio and ram is media and capacidad_gpu is mala and nucleos_procesador is alta and rom is alta and campos_de_uso is exigente then suficiencia_pc is mediocre ;
     RULE 25 : If procesador is medio and ram is media and capacidad_gpu is media and nucleos_procesador is alta and rom is mala and campos_de_uso is noExigente then suficiencia_pc is normal ;
     RULE 26 : If procesador is medio and ram is media and capacidad_gpu is media and nucleos_procesador is alta and rom is mala and campos_de_uso is medioExigente then suficiencia_pc is normal ;
     RULE 27 : If procesador is medio and ram is media and capacidad_gpu is media and nucleos_procesador is alta and rom is mala and campos_de_uso is exigente then suficiencia_pc is normal ;
     RULE 28 : If procesador is medio and ram is media and capacidad_gpu is media and nucleos_procesador is alta and rom is alta and campos_de_uso is noExigente then suficiencia_pc is normal ;
     RULE 29 : If procesador is medio and ram is media and capacidad_gpu is media and nucleos_procesador is alta and rom is alta and campos_de_uso is medioExigente then suficiencia_pc is normal ;
     RULE 30 : If procesador is medio and ram is media and capacidad_gpu is media and nucleos_procesador is alta and rom is alta and campos_de_uso is exigente then suficiencia_pc is mediocre ;
     RULE 31 : If procesador is medio and ram is media and capacidad_gpu is alta and nucleos_procesador is alta and rom is alta and campos_de_uso is noExigente then suficiencia_pc is sobre_calificado ;
     RULE 32 : If procesador is medio and ram is media and capacidad_gpu is alta and nucleos_procesador is alta and rom is alta and campos_de_uso is medioExigente then suficiencia_pc is calificado ;
     RULE 33 : If procesador is medio and ram is media and capacidad_gpu is alta and nucleos_procesador is alta and rom is alta and campos_de_uso is exigente then suficiencia_pc is normal ;
     RULE 34 : If procesador is medio and ram is media and capacidad_gpu is alta and nucleos_procesador is alta and rom is media and campos_de_uso is noExigente then suficiencia_pc is calificado ;
     RULE 35 : If procesador is medio and ram is media and capacidad_gpu is alta and nucleos_procesador is alta and rom is media and campos_de_uso is medioExigente then suficiencia_pc is normal ;
     RULE 36 : If procesador is medio and ram is media and capacidad_gpu is alta and nucleos_procesador is alta and rom is media and campos_de_uso is exigente then suficiencia_pc is mediocre ;
     RULE 37 : If procesador is medio and ram is media and capacidad_gpu is media and nucleos_procesador is alta and rom is media and campos_de_uso is noExigente then suficiencia_pc is normal ;
     RULE 38 : If procesador is medio and ram is media and capacidad_gpu is media and nucleos_procesador is alta and rom is media and campos_de_uso is medioExigente then suficiencia_pc is normal ;
     RULE 39 : If procesador is medio and ram is media and capacidad_gpu is media and nucleos_procesador is alta and rom is media and campos_de_uso is exigente then suficiencia_pc is mediocre ;
     RULE 40 : If procesador is alto and ram is mala and rom is mala and campos_de_uso is noExigente then suficiencia_pc is calificado ;
     RULE 41 : If procesador is alto and ram is media and campos_de_uso is noExigente then suficiencia_pc is sobre_calificado ;
     RULE 42 : If procesador is alto and ram is alta and campos_de_uso is noExigente then suficiencia_pc is sobre_calificado ;
     RULE 43 : If procesador is alto and ram is alta and capacidad_gpu is mala and rom is mala and campos_de_uso is medioExigente then suficiencia_pc is calificado ;
     RULE 44 : If procesador is alto and ram is alta and rom is mala and campos_de_uso is medioExigente then suficiencia_pc is calificado ;
     RULE 45 : If procesador is alto and ram is alta and rom is media and campos_de_uso is medioExigente then suficiencia_pc is sobre_calificado ;
     RULE 46 : If procesador is alto and ram is alta and rom is alta and campos_de_uso is medioExigente then suficiencia_pc is calificado ;
     RULE 47 : If procesador is alto and ram is media and capacidad_gpu is mala and rom is mala and campos_de_uso is medioExigente then suficiencia_pc is normal ;
     RULE 48 : If procesador is alto and ram is media and rom is mala and campos_de_uso is medioExigente then suficiencia_pc is normal ;
     RULE 49 : If procesador is alto and ram is media and campos_de_uso is medioExigente then suficiencia_pc is calificado ;
     RULE 50 : If procesador is alto and ram is mala and capacidad_gpu is mala and rom is mala and campos_de_uso is medioExigente then suficiencia_pc is calificado ;
     RULE 51 : If procesador is alto and ram is mala and rom is mala and campos_de_uso is medioExigente then suficiencia_pc is calificado ;
     RULE 52 : If procesador is alto and ram is mala and campos_de_uso is medioExigente then suficiencia_pc is sobre_calificado ;
     RULE 53 : If procesador is alto and ram is mala and campos_de_uso is exigente then suficiencia_pc is muy_mediocre ;
     RULE 54 : If procesador is alto and ram is media and capacidad_gpu is mala and rom is mala and campos_de_uso is exigente then suficiencia_pc is muy_mediocre ;
     RULE 55 : If procesador is alto and ram is media and capacidad_gpu is mala and rom is media and campos_de_uso is exigente then suficiencia_pc is muy_mediocre ;
     RULE 56 : If procesador is alto and ram is media and capacidad_gpu is mala and rom is alta and campos_de_uso is exigente then suficiencia_pc is mediocre ;
     RULE 57 : If procesador is alto and ram is media and capacidad_gpu is media and rom is mala then suficiencia_pc is muy_mediocre ;
     RULE 58 : If procesador is alto and ram is media and capacidad_gpu is media and campos_de_uso is exigente then suficiencia_pc is mediocre ;
     RULE 59 : If procesador is alto and ram is media and capacidad_gpu is alta and rom is mala and campos_de_uso is exigente then suficiencia_pc is mediocre ; ////
     RULE 60 : If procesador is alto and ram is media and capacidad_gpu is alta and rom is media and campos_de_uso is exigente then suficiencia_pc is normal ;
     RULE 61 : If procesador is alto and ram is media and capacidad_gpu is alta and rom is alta and campos_de_uso is exigente then suficiencia_pc is calificado ;
     RULE 62 : If procesador is alto and ram is alta and capacidad_gpu is alta and rom is mala and campos_de_uso is exigente then suficiencia_pc is normal ;
     RULE 63 : If procesador is alto and ram is alta and capacidad_gpu is alta and nucleos_procesador is alta and rom is media and campos_de_uso is exigente then suficiencia_pc is calificado ;
    RULE 64 : If procesador is alto and ram is alta and capacidad_gpu is alta and nucleos_procesador is alta and rom is alta and campos_de_uso is exigente then suficiencia_pc is calificado ;
    RULE 65 : If procesador is malo and ram is media and capacidad_gpu is mala and nucleos_procesador is malo and rom is mala and campos_de_uso is noExigente then suficiencia_pc is mediocre;
    RULE 66 : If procesador is malo and ram is media and capacidad_gpu is mala and nucleos_procesador is medio and rom is alta and campos_de_uso is medioExigente then suficiencia_pc is normal;
    RULE 67 : If procesador is medio and ram is media and capacidad_gpu is mala and nucleos_procesador is malo and rom is mala and campos_de_uso is noExigente then suficiencia_pc is mediocre;
    RULE 68 : If procesador is malo and ram is media and capacidad_gpu is alta and nucleos_procesador is alta and rom is alta and campos_de_uso is exigente then suficiencia_pc is mediocre;
    RULE 69 : If procesador is medio and ram is mala and capacidad_gpu is alta and nucleos_procesador is medio and rom is media and campos_de_uso is exigente then suficiencia_pc is mediocre;
    RULE 70 : If procesador is medio and ram is mala and capacidad_gpu is mala and nucleos_procesador is medio and rom is media and campos_de_uso is medioExigente then suficiencia_pc is normal;
    RULE 71 : If procesador is medio and ram is mala and campos_de_uso is medioExigente then suficiencia_pc is mediocre;
    RULE 72 : If procesador is medio and ram is media and capacidad_gpu is mala and  rom is alta and nucleos_procesador is medio and campos_de_uso is medioExigente then suficiencia_pc is normal;
    RULE 72 : If procesador is medio and ram is media and capacidad_gpu is mala and  rom is alta and nucleos_procesador is malo and campos_de_uso is medioExigente then suficiencia_pc is mediocre;
     ```


