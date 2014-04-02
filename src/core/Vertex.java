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

/**
*
* @author charles.strong
*/
public class Vertex {
	
	Vertex(int identifier, Set<Edge> edges)
    {
		this._identifier = identifier;
		for(Edge edge : edges)
		{
			if(edge.GetOrigin() == identifier)
			{
				this._edges.add(edge);
			}
		}
    }
    
    //private member variables    
    private int _identifier;
    private Set<Edge> _edges;
    private boolean _checkedAllEdges = false;
    
    //public instance methods
    public int GetIdentifier()
    {
        return this._identifier;
    }
    
    public Set<Edge> GetEdges()
    {
        return this._edges;
    }
    
    public int GetClosestVertexIdentifier()
    {
    	Edge shortestEdge = new Edge(0,0,Integer.MAX_VALUE);
    	for(Edge edge : this._edges)
    	{
    		if(edge.GetDistance() < shortestEdge.GetDistance())
    		{
    			shortestEdge = edge;
    		}
    	}
    	return shortestEdge.GetDestination();
    }
      
    public void SetAsChecked()
    {
    	this._checkedAllEdges = true;
    }
    
    public boolean HasBeenChecked()
    {
    	return this._checkedAllEdges;
    }
    
   //Overrides
    @Override
    public int hashCode()
    {
    	
        return Integer.toString(this._identifier,2).hashCode();
    }
    
    @Override
    public boolean equals(Object o)
    {
        Vertex obj = (Vertex)o;
        if (obj == null)
        {
            return false;
        }
    
        return this._identifier == obj.GetIdentifier();
    }

}
