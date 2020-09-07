package Chat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author julia
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class Servidor {
    ServerSocket servidor = null;
    Socket socket = null;
    BufferedReader lector = null;
    PrintWriter escritor = null;
    
    public Servidor(){
        interfaz();
    }
    public void interfaz(){
        Thread principal = new Thread(new Runnable(){
            public void run(){        
                try{
                    servidor = new ServerSocket(9000);
                    while(true){
                        socket = servidor.accept();
                        leer();
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
                
        });
        principal.start();;
        
    }



    public void leer(){
        Thread leerHilo = new Thread(new Runnable(){
            public void run(){        
                try{
                    Volver:
                    while(true){
                        try{
                            String fileName = "src/difusa/Archivo FCL.fcl";
                            FIS fis = FIS.load(fileName, true);
                            // Error while loading?
                            if (fis == null) {
                                System.err.println("Can't load file: '" + fileName + "'");
                                return;
                            }

                            lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            escritor = new PrintWriter(socket.getOutputStream(), true);
                            escritor.println("Hola, buenos dias es un placer ayudarle!!!!\n" +
                                    "Ingrese el numero correspondiente a su procesador" +
                                    "\n 1* Intel Celeron" +
                                    "\n 2* Intel Pentium" +
                                    "\n 3*  AMD Phenom" +
                                    "\n 4*  AMD Fusion" +
                                    "\n 5*  AMD Buldozer" +
                                    "\n 6*  Intel Atom" +
                                    "\n 7*  AMD Vishera " +
                                    "\n 8*  Intel Core I3" +
                                    "\n 9*  Intel Core I5" +
                                    "\n10* AMD Ryzen 3" +
                                    "\n11* Intel Core I7" +
                                    "\n12* AMD Ryzen 5" +
                                    "\n13* Intel Core I9" +
                                    "\n14* Intel Xeon" +
                                    "\n15* AMD Ryzen 7" +
                                    "\n16* AMD Ryzen threadripper");

                            int procesador = Integer.parseInt(lector.readLine());

                            fis.setVariable("procesador",  procesador);
                            escritor.println("                                                              Tu : "+ procesador);

                            escritor.println("Ingrese la capacidad correspondiente a su RAM (Entre 2-20)");

                            int ram = Integer.parseInt(lector.readLine());
                            fis.setVariable("ram", ram);
                            escritor.println("                                                              Tu : "+ ram);

                            escritor.println("Ingrese la capacidad correspondiente a su GPU (Entre 2-20)");
                            int capacidad_gpu = Integer.parseInt(lector.readLine());
                            fis.setVariable("capacidad_gpu",  capacidad_gpu);
                            escritor.println("                                                              Tu : "+ capacidad_gpu);

                            escritor.println("Ingrese la capacidad correspondiente a los nucleos de procesador");
                            int nucleos_procesador = Integer.parseInt(lector.readLine());
                            fis.setVariable("nucleos_procesador",  nucleos_procesador);
                            escritor.println("                                                              Tu : "+ nucleos_procesador);

                            escritor.println("Ingrese la capacidad correspondiente a su memoria ROM (64-128-256-512-1024-2048-4096)");
                            int rom = Integer.parseInt(lector.readLine());
                            fis.setVariable("rom",  rom);
                            escritor.println("                                                              Tu : "+ rom);

                            escritor.println("Ingrese el numero correspondiente al campo de uso\n" +
                                    "1* Estudiantil para colegio" +
                                    "\n2* Hogar" +
                                    "\n3* Administrativo" +
                                    "\n4* Estudiante Universidad Idiomas/Humanas/Artes/Derecho/Medicina" +
                                    "\n5* Profesional Idiomas/Humanas/Artes/Derecho/Medicina" +
                                    "\n6* Estudiante Universidad Ingenieria/Ciencias/Arquitectura/Estadistica" +
                                    "\n7* Profesional Ingenieria/Ciencias/Arquitectura/Estadistica" +
                                    "\n8* Gamer");
                            int campos_de_uso = Integer.parseInt(lector.readLine());
                            fis.setVariable("campos_de_uso",  campos_de_uso);
                            escritor.println("                                                              Tu : "+ campos_de_uso);

                            fis.evaluate();
                            JFuzzyChart.get().chart(fis.getFunctionBlock("tipper"));
                            double x = fis.getVariable("suficiencia_pc").getLatestDefuzzifiedValue();
                            System.err.println(x);
                            if (0<x && x<5){
                                escritor.println("La suficiencia del PC con los componentes dados para el campo de uso es muy mediocre");
                            }else if(5<x && x<6){
                                escritor.println("La suficiencia del PC con los componentes dados para el campo de uso es muy mediocre tirando a mediocre");
                            }else if(6<x && x<11){
                                escritor.println("La suficiencia del PC con los componentes dados para el campo de uso es mediocre");
                            }else if(11<x && x<12){
                                escritor.println("La suficiencia del PC con los componentes dados para el campo de uso es muy mediocre tirando a normal");
                            }else if(12<x && x<17){
                                escritor.println("La suficiencia del PC con los componentes dados para el campo de uso es normal");
                            }else if(17<x && x<18){
                                escritor.println("La suficiencia del PC con los componentes dados para el campo de uso normal tirando a calificado");
                            }else if(18<x && x<23){
                                escritor.println("La suficiencia del PC con los componentes dados para el campo de uso es calificado");
                            }else if(23<x && x<24){
                                escritor.println("La suficiencia del PC con los componentes dados para el campo de uso es calificado tirando a sobre calificado");
                            }else{
                                escritor.println("La suficiencia del PC con los componentes dados para el campo de uso es sobre calificado");
                            }

                            for (Rule r : fis.getFunctionBlock("tipper").getFuzzyRuleBlock("No1").getRules()) {
                                System.out.println(r);
                            }
                            break;
                        }catch(Exception e){
                            escritor.println("Ingresaste un dato que no es valido, por favor intentelo de nuevo\n");
                            continue Volver;
                        }
                    }

                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
                
        });
        leerHilo.start();;
    }
 
}
    


