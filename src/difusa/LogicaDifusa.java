/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package difusa;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

import java.util.Scanner;

/**
 * Test parsing an FCL file
 * @author pcingola@users.sourceforge.net
 */
public class LogicaDifusa {

    public static void main(String[] args) throws Exception {
        // Load from 'FCL' file


        String fileName = "src/difusa/Archivo FCL.fcl";
        FIS fis = FIS.load(fileName, true);
        // Error while loading?
        if (fis == null) {
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        int procesador;
        int ram;
        int capacidad_gpu;
        int nucleos_procesador;
        int rom;
        int campos_de_uso;

        System.err.println("Ingrese el numero correspondiente a su procesador");
        System.out.println(
                " 1* Intel Celeron" +
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
        procesador = scanner.nextInt();
        System.err.println("Ingrese la capacidad correspondiente a su RAM");
        ram = scanner.nextInt();
        System.err.println("Ingrese la capacidad correspondiente a su GPU");
        capacidad_gpu = scanner.nextInt();
        System.err.println("Ingrese la capacidad correspondiente a los nucleos de procesador");
        nucleos_procesador = scanner.nextInt();
        System.err.println("Ingrese la capacidad correspondiente a su memoria ROM");
        rom = scanner.nextInt();
        System.err.println("Ingrese el numero correspondiente al campo de uso");
        System.out.println(
                "1* Estudiantil para colegio" +
                        "\n2* Hogar" +
                        "\n3* Administrativo" +
                        "\n4* Estudiante Universidad Idiomas/Humanas/Artes/Derecho/Medicina" +
                        "\n5* Profesional Idiomas/Humanas/Artes/Derecho/Medicina" +
                        "\n6* Estudiante Universidad Ingenieria/Ciencias/Arquitectura/Estadistica" +
                        "\n7* Profesional Ingenieria/Ciencias/Arquitectura/Estadistica" +
                        "\n8* Gamer");
        campos_de_uso = scanner.nextInt();



        fis.setVariable("procesador",         procesador);
        fis.setVariable("ram",                ram);
        fis.setVariable("capacidad_gpu",      capacidad_gpu);
        fis.setVariable("nucleos_procesador", nucleos_procesador);
        fis.setVariable("rom",                rom);
        fis.setVariable("campos_de_uso",      campos_de_uso);

        fis.evaluate();
        JFuzzyChart.get().chart(fis.getFunctionBlock("tipper"));
        double x = fis.getVariable("suficiencia_pc").getLatestDefuzzifiedValue();
        System.err.println("Para los valores de salida el grado de pertenencia es: " + x);

        for (Rule r : fis.getFunctionBlock("tipper").getFuzzyRuleBlock("No1").getRules()) {
            System.out.println(r);
        }
    /*

        // Set inputs
        fis.setVariable("medida_cuarto", 5);
        fis.setVariable("cantidad_personas", 10);
        fis.setVariable("temperatura_cuarto", 27);

        // Evaluate
        fis.evaluate();

        // Show
        JFuzzyChart.get().chart(fis.getFunctionBlock("tipper"));

        Double x = fis.getVariable("potencia").getLatestDefuzzifiedValue();
        System.err.println("Para los valores de salida el grado de pertenencia es: " + x);
        
        // Show rules
        for (Rule r : fis.getFunctionBlock("tipper").getFuzzyRuleBlock("No1").getRules()) {
            System.out.println(r);
        }

     */
    }
}