/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author charles.strong
 */
public class Main {

    /**
     * @param args the command line arguments
     */
		
    public static void main(String[] args) {
        
        try (ServerSocket server = new ServerSocket( 7777 );
             Socket socket = server.accept())
        {
            //send recieved values to DirectedGraph
            DirectedGraph graph = new DirectedGraph(socket.getInputStream());
            
            graph.FindShortestPath(1, 1);
            //this wont work the stream is already closed.
        }
        catch(Exception ex)
        {
            //something went wrong
        }
        
        //run Shortest Path algorythm using the given start and end vertices
        //return result in printed format specified
    }
    
}
