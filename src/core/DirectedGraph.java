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

import java.util.Set;
/*
 * @author charles.strong
 */
public class DirectedGraph {
    
    //constructor
    DirectedGraph(Set<Vertex> vertices, Set<Edge> edges)
    {
        this._isAcyclic = NullableBoolean.NOTSET;
        this._vertices = vertices;
        this._edges = edges;
        
        //determine if is acyclic
        this.IsAcyclic();
       
    }
    
    //private member variables
    private NullableBoolean _isAcyclic;
    
    private Set<Vertex> _vertices;
    private Set<Edge> _edges;
      
    //public methods
    public boolean IsAcyclic()
    {
        //A digraph can be Acyclic only if there are no Directed loops
        //Meaning you cannot start and return to any given vertex
        //(following path direction)
        
        if(this._isAcyclic == NullableBoolean.NOTSET)
        {
            //add logic to determine if this DirectedGraph is acyclic
        	//for now just set to true
        	this._isAcyclic = NullableBoolean.TRUE;
        }
        
        return (this._isAcyclic == NullableBoolean.TRUE);
    }
      
    public Set<Vertex> GetVertices()
    {
        return this._vertices;
    }
    
    public Set<Edge> GetEdges()
    {
        return this._edges;
    }
    
    public int GetNumberOfEdges()
    {
        return this._edges.size();
    }
    
    public void FindShortestPath(int origin, int destination)
    {
        if(!this.IsAcyclic())
            return;//Add error: Wee only want Acyclic Graphs
       
    }
    
}
