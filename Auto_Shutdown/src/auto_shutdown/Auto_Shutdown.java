/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto_shutdown;

import java.io.IOException;

/**
 *
 * @author edura
 */
public class Auto_Shutdown {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        shutdownProgram();
    }

    private static void shutdownProgram() {  
        //Process to cancel shutdown if shutdown is already programmed
        ProcessBuilder cancelShutdown = new ProcessBuilder("cmd.exe", "/c", "shutdown /a");

        try {
            System.out.println("Checking programmed shutdown ...");
            //Execute process
            cancelShutdown.start();
            
            int hours = Keyboard.IntroInteger("In how many HOURS do you want to shutdown the system?");
            int minutes =  Keyboard.IntroInteger("In how many MINUTES do you want to shutdown the system?");
            
            //1 hour have 3600 seconds
            int convertToSeconds = hours * 3600 + minutes * 3600;
            //Procces to program automatic shutdown
            ProcessBuilder shutdownProgrammed = new ProcessBuilder("cmd.exe", "/c", "shutdown -s -t "+convertToSeconds);

            //Execute process
            shutdownProgrammed.start();
    
            System.out.println("Programmed shutdown has been realized correctly");
        } catch (IOException e) {
            System.out.println("Error during executing the child process");
            e.printStackTrace();
        }
    }
}
