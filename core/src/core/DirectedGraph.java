/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author charles.strong
 */
public class DirectedGraph {
    
    //constructor
    DirectedGraph()
    {
        this._isAcyclic = NullableBoolean.NOTSET;
        this._vertices = new ArrayList<Vertex>();
    }
    
    //private member variables
    private NullableBoolean _isAcyclic;
    
    private List<Vertex> _vertices;
    
    //public methods
    public boolean IsAcyclic()
    {
        //A digraph can be Acyclic only if there are no Directed loops
        //Meaning you cannot start and return to any given vertex
        //(following path direction)
        
        if(this._isAcyclic == NullableBoolean.NOTSET)
        {
            //add logic to determine if this DirectedGraph is acyclic
        }
        
        return (this._isAcyclic == NullableBoolean.TRUE);
    }
    
    public void AddVertex(Vertex vertex)
    {
        this._vertices.add(vertex);
    }
    
    public List<Vertex> GetVertices()
    {
        return this._vertices;
    }
    
}
