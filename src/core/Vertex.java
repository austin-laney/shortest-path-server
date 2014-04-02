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
    }
    
    //private member variables    
    private int _identifier;
    private Set<Edge> _edges;
    
    //public instance methods
    public int GetIdentifier()
    {
        return this._identifier;
    }
    
    public Set<Edge> GetOrigin()
    {
        return this._edges;
    }
    
    //now that I am using hashset for vertices I also whant to use it for this
    //"complex" HAHA object
    //this means I need to override GetHashCode and Equals
    public int GetHashCode()
    {                        
        return Integer.toString(this._identifier,2).hashCode();
    }
    
    public boolean equals(Object o)
    {
        Vertex obj = (Vertex)o;
        if (obj == null)
        {
            return false;
        }
    
        return this.GetIdentifier() == obj.GetIdentifier();
    }

}
