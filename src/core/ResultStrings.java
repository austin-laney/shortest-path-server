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
public final class ResultStrings {
    public static final String START_END_EQUAL = "%d->%d (0) START AND END ARE EQUAL";
    public static final String START_CONNECTED_TO_END = "%d->%d (%d)";
    public static final String PATH_FOUND = "%d->%s";
    public static final String PATH_NOT_FOUND = "No path from '%d' to '%d'";

    private ResultStrings(){
    }  
}
