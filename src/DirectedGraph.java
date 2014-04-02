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
 * converted back to eclipse after git for netbeans failed 
 */
public class DirectedGraph {
    
    //constructor
    DirectedGraph( List<Edge> edges, Integer edgeCount)
    {
        
        this._isAcyclic = NullableBoolean.NOTSET;
        this._vertices = new ArrayList<Vertex>();
        this._edgeCount = edgeCount;
        
        this.BuildGraph(edges);

        //determine if is acyclic
        this.IsAcyclic();
       
    }
    
    //private member variables
    private NullableBoolean _isAcyclic;
    
    private List<Vertex> _vertices;
    private int _edgeCount;
    
    //private instance methods
    private void BuildGraph(List<Edge> edges)
    {
        for(Edge edge : edges)
        {
            if(!this._vertices.contains(edge.GetOrigin()))
            {
                this._vertices.add(edge.GetOrigin());
            }
           //get the current vertex (eg: edge.origin)
        }
    }
    
    
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
      
    public List<Vertex> GetVertices()
    {
        return this._vertices;
    }
    
    
    
    public void FindShortestPath(int originID, int destinationID)
    {
        if(!this.IsAcyclic())
            return;//Add error: Wee only want Acyclic Graphs
        
        //logic here
    }
    
}
