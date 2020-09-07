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
   // Fuzzify procesador{malo, medio, alto}
      FUZZIFY procesador
    TERM malo := (-2, 0.5) (2, 1) (8.5,0) ;
    TERM medio := (6.5, 0) (11,1) (15.5,0);
    TERM alto := (12.5, 0) (18, 1) (22,0);
   END_FUZZIFY
   ```
    
   - Reglas de inferencia difusa.
     ```
     Print("Casa")
     ```

