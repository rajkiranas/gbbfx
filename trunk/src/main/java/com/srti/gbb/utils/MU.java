/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.utils;

import com.srti.gbb.global.GlobalConstants;

/**
 *
 * @author sateri
 */
public class MU {
    
    public static String getMsg(String property)
    {
        return GlobalConstants.getProperty(property);
    }
    
}
