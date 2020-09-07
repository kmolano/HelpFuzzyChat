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
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
/**
 *
 * @author julia
 */
public class Cliente {
    JFrame ventanaChat =null;
    JButton boton = null;
    JTextField mensaje = null;
    JTextArea areaChat = null;
    JPanel contenedorAreaChat = null;
    JPanel contenedorBoton = null;
    JScrollPane scroll = null;
    Socket socket = null;
    BufferedReader lector = null;
    PrintWriter escritor = null;
    JLabel label = null;
    JPanel contenedorLabel = null;


    public Cliente(){
        interfaz();
    }
    public void interfaz(){

        label = new JLabel("Bienvenido, estamos para ayudarte!");
        contenedorLabel = new JPanel();
        contenedorLabel.setLayout(new GridLayout(1,1));
        contenedorLabel.add(label);
        ventanaChat = new JFrame("HelpFuzzyChat");
        boton = new JButton("Enviar");
        mensaje = new JTextField(4);
        areaChat = new JTextArea(20,12); //// areaChat = new JTextArea(10,12);
        scroll = new JScrollPane(areaChat);
        contenedorAreaChat = new JPanel();
        contenedorAreaChat.setLayout(new GridLayout(1,1));
        contenedorAreaChat.add(scroll);
        contenedorBoton = new JPanel();
        contenedorBoton.setLayout(new GridLayout(1,2));
        contenedorBoton.add(mensaje);
        contenedorBoton.add(boton);
        ventanaChat.setLayout(new BorderLayout());
        ventanaChat.add(contenedorLabel,BorderLayout.PAGE_START);
        ventanaChat.add(contenedorAreaChat,BorderLayout.CENTER);
        ventanaChat.add(contenedorBoton,BorderLayout.PAGE_END);
        ventanaChat.setSize(610,386);
        ventanaChat.setVisible(true);
        ventanaChat.setResizable(false);
        ventanaChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ventanaChat.getContentPane().setBackground(Color.BLACK); //////////
        areaChat.setBackground(Color.white);  /////////
        areaChat.setForeground(Color.black);        ///////
        mensaje.setForeground(Color.black);         ///////////
        contenedorLabel.setBackground(Color.CYAN); //
        contenedorLabel.setForeground(Color.white); //




        Thread principal = new Thread(new Runnable(){
            public void run(){        
                try{
                    socket = new Socket("localhost",9000);

                    escribir();
                    leer();
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
                    lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    while(true){
                        String mensajeRecibido = lector.readLine();
                        String[] mensajes = mensajeRecibido.split(" ");
                        boolean res = true;
                        for (String i: mensajes
                             ) {
                            if(i.equals("Tu")){
                                areaChat.append(mensajeRecibido+ "\n");
                                res = true;
                                break;
                            }else{
                                res = false;
                            }
                        }
                        if(!res){
                            areaChat.append("FuzzyChat: "+mensajeRecibido+ "\n");
                        }
                        //areaChat.append("Servidor dice: "+mensajeRecibido+ "\n");


                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
                
        });
        leerHilo.start();;
    }
    public void escribir(){
        Thread escribirHilo = new Thread(new Runnable(){
            public void run(){        
                try{
                    escritor = new PrintWriter(socket.getOutputStream(),true);
                    boton.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            String enviarMensaje = mensaje.getText();
                            escritor.println(enviarMensaje);
                            mensaje.setText("");

                        }
                    });
                    
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
                
        });
        escribirHilo.start();;
    }
}
