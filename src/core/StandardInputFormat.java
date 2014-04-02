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

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Set;
import java.util.HashSet;
/**
 *
 * @author charles.strong
 */
public class StandardInputFormat {
    //constructor
    StandardInputFormat(InputStream stream) throws IOException{
    	
        int currentOrigin = 0;
        int currentDestination = 0;
        
        //Was using lists but this needs to be unique;
        
        int index = 1;
        byte[] data = new byte[2]; //two byte (16 bit) increments
        while( stream.read( data )  != -1 )  { //read input to end
            ByteBuffer buffer = ByteBuffer.wrap( data )
                                          .order(ByteOrder.BIG_ENDIAN);

            short value = buffer.getShort();
            //Cycle threw data and assign vertices and edges
            if(index > 3){//edge data                
                int sub = (index % 3);
                switch(sub){
                    case 1:
                        this._vertices.add((int)value);
                        currentOrigin = value;
                        break;
                    case 2:
                        this._vertices.add((int)value);
                        currentDestination = value;
                        break;
                    default://should be 0
                        this._graphEdges.add(
                             new Edge(currentOrigin, currentDestination, value));
                        break;
                }
            } else {//sudo header data
                switch(index){
                    case 1:
                        this._startingVertexIdentifier = value;
                        break;
                    case 2:
                        this._endingVertexIdentifier = value;
                        break;
                    default:
                        this._numberOfGraphEdges = value;
                        break;
                }
            }
            index++;
        }
        
        
        stream.close();
    }
    
    private int _startingVertexIdentifier;
    private int _endingVertexIdentifier;
    private int _numberOfGraphEdges;
    private Set<Edge> _graphEdges = new HashSet<Edge>();
    private Set<Integer> _vertices = new HashSet<Integer>();;
    
    //public instance methods
    public int GetStartingVertexIdentifier()
    {
        return this._startingVertexIdentifier;
    }
    
    public int GetEndingVertexIdentifier()
    {
        return this._endingVertexIdentifier;
    }
    
    public int GetNumberOfGraphEdges()
    {
        return this._numberOfGraphEdges;
    }
    
    public Set<Edge> GetGraphEdges()
    {
        return this._graphEdges;
    }
    
    public Set<Integer> GetVertices()
    {
        return this._vertices;
    }
    
}
