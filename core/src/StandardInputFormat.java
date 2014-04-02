/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author charles.strong
 */
public class StandardInputFormat {
    //constructor
    StandardInputFormat(InputStream stream) throws IOException{
        this._graphEdges = new ArrayList<Edge>();
        
        int currentOrigin = 0;
        int currentDestination = 0;
        int currentDistance = 0;
        
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
                        currentOrigin = value;
                        break;
                    case 2:
                        currentDestination = value;
                        break;
                    default://should be 0
                        this._graphEdges.add(
                                new Edge(
                                        new Vertex(currentOrigin, currentDestination, value));
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
    private List<Edge> _graphEdges;
    
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
    
    public List<Edge> GetGraphEdges()
    {
        return this._graphEdges;
    }
    
}
