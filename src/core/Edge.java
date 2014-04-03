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

/**
 *
 * @author charles.strong
 */
public class Edge {
    
    //constructor
    public Edge(int origin, int destination, int distance)
    {
        this._origin = origin;
        this._desintination = destination;
        this._distance = distance;
    }
    
    //private member variables    
    private int _origin;
    private int _desintination;
    private int _distance;
   
    //public instance methods
    public int GetDestination()
    {
        return this._desintination;
    }
    
    public int GetOrigin()
    {
        return this._origin;
    }
    
    public int GetDistance()
    {
        return this._distance;
    }
    
    //now that I am using set for vertices I also want to use it for this
    //"complex" HAHA object
    //this means I need to override GetHashCode and Equals
    //Overrides
    @Override
    public int hashCode()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(Integer.toString(this.GetOrigin(),2));
        builder.append(Integer.toString(this.GetDestination(),2));
        builder.append(Integer.toString(this.GetDistance(),2));
                        
        return builder.toString().hashCode();
    }
    
    @Override
    public boolean equals(Object o)
    {
        Edge obj = (Edge)o;
        if (obj == null)
            return false;
    
        return this.GetOrigin() == obj.GetOrigin() &&
                this.GetDestination() == obj.GetDestination() &&
                this.GetDistance() == obj.GetDistance();
    }
}
