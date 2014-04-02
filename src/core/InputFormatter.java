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
/**
 *
 * @author charles.strong
 */
public class InputFormatter {
    //helper methods
    public static StandardInputFormat FormatInputStandard(InputStream stream) throws IOException
    {
        return new StandardInputFormat(stream);
    }
}
