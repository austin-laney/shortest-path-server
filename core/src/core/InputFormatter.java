/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
