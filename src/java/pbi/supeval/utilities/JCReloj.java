/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbi.supeval.utilities;

/**
 *
 * @author depdes10
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Pon el código dentro de un método que se ejecute al inicio y una sola vez
public class JCReloj{// No olvides importar las clases en la parte superior de tu archivo:
    private String hora;
    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm:ss");
    Runnable runnable = new Runnable() {
        @Override
            public void run() {
                while (true) {
                try {
                    Thread.sleep(500);
                    hora = formateador.format(LocalDateTime.now());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    public JCReloj(){
        Thread hilo = new Thread(runnable);
        hilo.start();
    }   
    public String getHora(){
        return this.hora;
    }
}
