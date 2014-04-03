/*
 * This file is part of Shortest-Path-Server.
 * 
 * Copyright (c) 2014 Charles Strong
 * 
 * Shortest-Path-Server is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * Shortest-Path-Server is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with Shortest-Path-Server.
 * If not, see http://www.gnu.org/licenses/.
 */

package core;

import java.io.InputStream;
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
        
        try (ServerSocket server = new ServerSocket( 7777 ); Socket socket = server.accept())
        {
            InputStream stream = socket.getInputStream();
            
            StandardInputFormat input = InputFormatter.FormatInputStandard(stream);
        
            //send received values to DirectedGraph
            DirectedGraph graph = new DirectedGraph(input.GetVertices(), input.GetGraphEdges());
            
            //compute result
            String result = graph.FindShortestPath(input.GetStartingVertexIdentifier(), input.GetEndingVertexIdentifier());
            
            //There is no way that I can find to write to an input stream. 
        	//Maybe if there was an authentication handshake (two physical devices)
        	//or if the file name was passed via the input stream (locally ran eg: 127.0.0.1)
        	//just print the result to the system console
            System.out.println(result);
            
            
        }
        catch(Exception ex)
        {
            //something went wrong
        	//need to add real handling
        }
        
    }
    
}
