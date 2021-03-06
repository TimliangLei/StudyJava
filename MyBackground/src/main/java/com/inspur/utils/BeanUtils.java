package com.inspur.utils;

import java.util.Collection;
import java.util.Map;

//import org.apache.commons.beanutils.ConvertUtilsBean;

/**
 * <p>
 * Title:Bean 工具处理类
 * </p>
 * <p>
 * Description:Bean 工具处理类
 * </p>
 * 
 * @author 杨伟俊 2013-04-07 23：:55
 *         <p>
 *         Company:浪潮通信-OBD
 *         </p>
 * @version 1.1
 */
public abstract class BeanUtils
{

    /**
     * 判断参数对象是否为空
     * 
     * @param o
     *            需要判断的对象
     * @return boolean true:对象为空 false:对象不为空
     */
    public static boolean isEmpty(Object o)
    {
        if (o == null)
        {
            return true;
        }
        if (o instanceof String)
        {
            if (((String)o).trim().length() == 0)
            {
                return true;
            }
        }
        else if (o instanceof Collection)
        {
            if (((Collection)o).isEmpty())
            {
                return true;
            }
        }
        else if (o.getClass().isArray())
        {
            if (java.lang.reflect.Array.getLength(o)==0)
            {
                return true;
            }
        }
        else if (o instanceof Map)
        {
            if (((Map)o).isEmpty())
            {
                return true;
            }
        }
        return false;
    }
    

    
    /**
     * 判断输入参数是否可以转换为数字
     * 
     * 
     * @param oPt
     *            输入参数
     * @return boolean true:是数字 false:不是数字
     */
    public static boolean isNumber(Object oPt)
    {
        if (oPt == null)
        {
            return false;
        }
        if (oPt instanceof Number)
        {
            return true;
        }
        if (oPt instanceof String)
        {
            try
            {
                Double.parseDouble((String)oPt);
                return true;
            }
            catch (NumberFormatException e)
            {
                return false;
            }
        }
        return false;
    }
}
