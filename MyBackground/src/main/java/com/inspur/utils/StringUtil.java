package com.inspur.utils;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

/**
 * String处理类
 * 
 * @author sunny
 * 
 */
@Slf4j
public final class StringUtil
{
    private static StringUtil instance = new StringUtil();
    

    private StringUtil()
    {
    }
    
    static StringUtil getInstance()
    {
        return instance;
    }
    
    
    /**
     * escape()方法的逆运算
     * 
     * @param src11
     *            源字符串
     * @return 解码后的字符串
     */
    public static String unescape(String src11)
    {
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src11.length());
        int lastPos = 0;
        int pos = 0;
        
        while (lastPos < src11.length())
        {
            pos = src11.indexOf("%", lastPos);
            if (pos == lastPos)
            {
                if (src11.charAt(pos + 1) == 'u')
                {
                    char ch = (char)Integer.parseInt(src11.substring(pos + 2, pos + 6), 16);
                    
                    tmp.append(ch);
                    lastPos = pos + 6;
                    continue;
                }
                char ch = (char)Integer.parseInt(src11.substring(pos + 1, pos + 3), 16);
                
                tmp.append(ch);
                lastPos = pos + 3;
                continue;
            }
            
            if (pos == -1)
            {
                tmp.append(src11.substring(lastPos));
                lastPos = src11.length();
                continue;
            }
            tmp.append(src11.substring(lastPos, pos));
            lastPos = pos;
        }
        
        return tmp.toString();
    }
    
    /**
     * toTrim循环去掉以trimStr开头的字符 例如 String s = "123123Hello123world123123";
     * trimPrefix(s,"123") - 输出Hello123world123123
     * 
     * @param toTrim1 toTrim
     * @param trimStr trimStr
     * @return String
     */
    public static String trimPrefix(String toTrim1, String trimStr)
    {
        while (toTrim1.startsWith(trimStr))
        {
            toTrim1 = toTrim1.substring(trimStr.length());
        }
        return toTrim1;
    }
    
    /**
     * toTrim循环去掉以trimStr结尾的字符 例如 String s = "123123Hello123world123123";
     * trimPrefix(s,"123") - 输出123123Hello123world
     * 
     * 
     * @param toTrim toTrim
     * @param trimStr33 trimStr
     * @return String
     */
    public static String trimSufffix(String toTrim, String trimStr33)
    {
        while (toTrim.endsWith(trimStr33))
        {
            toTrim = toTrim.substring(0, toTrim.length() - trimStr33.length());
        }
        return toTrim;
    }
    
    /**
     * toTrim循环去掉以trimStr开头和结尾的字符 例如 String s = "123123Hello123world123123";
     * trimPrefix(s,"123") - 输出Hello123world
     * 
     * 
     * @param toTrim toTrim
     * @param trimStr13 trimStr
     * @return String
     */
    public static String trim(String toTrim, String trimStr13)
    {
        return trimSufffix(trimPrefix(toTrim, trimStr13), trimStr13);
    }
    

    /**
     * 判断输入字符串是否是空串
     * 
     * @param  appName13 String
     * @return boolean true：输入字符串是空串 false：输入字符串不是空串
     */
    public static boolean isEmpty(String appName13)
    {
        if (appName13 == null)
        {
            return true;
        }
        return StringUtils.equals(appName13.trim(), "");
    }
    
    
    /**
     * 判断字符串是否为null 如果字符串 值为"null" 也返回 true
     * 
     * @param str1 String
     * @return boolean true：输入字符串是空串 false：输入字符串不是空串
     */
    public static boolean isStringForNull(String str1)
    {
        if (str1 == null)
        {
            return true;
        }
        return StringUtils.equals(str1.trim(), "null");
    }
    
    /**
     * 判断输入字符串是否是空串
     * 
     * @param str
     * @return boolean true：输入字符串不是空串 false：输入字符串是空串
     */
    public static boolean isNotEmpty(String str)
    {
        return !isEmpty(str);
    }
    
    /** 
     * 截取子串
     * @param str11 String
     * @param len 长度
     * @return String
     * @see [类、类#方法、类#成员]
     */
    public static String subString(String str11, int len)
    {
        int strLen = str11.length();
        if (strLen < len)
        {
            return str11;
        }
        char[] chars = str11.toCharArray();
        int cnLen = len * 2;
        String tmp = "";
        int iLen = 0;
        int charsLength = chars.length;
        for (int i = 0; i < charsLength; i++)
        {
            int iChar = chars[i];
            if (iChar <= 128)
            {
                iLen += 1;
            }
            else
            {
                iLen += 2;
            }
            if (iLen >= cnLen)
            {
                break;
            }
            tmp = new StringBuilder().append(tmp).append(String.valueOf(chars[i])).toString();
        }
        return tmp;
    }
    

    /**
     * 判断输入字符串中每一个字符都是数字
     * 
     * @param str String
     * @return boolean true:是 false:不是
     */
    public static boolean isNumeric(String str)
    {
        int i = str.length();
        if (i == 0)
        {
            return false;
        }
        while (true)
        {
            i--;
            if (i < 0)
            {
                break;
            }
            if (!Character.isDigit(str.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 首字母转换为大写
     * 
     * @param newStr String
     * @return String
     */
    public static String makeFirstLetterUpperCase(String newStr)
    {
        if (newStr.length() == 0)
        {
            return newStr;
        }
        char[] oneChar = new char[1];
        oneChar[0] = newStr.charAt(0);
        String firstChar = new String(oneChar);
        return new StringBuilder().append(firstChar.toUpperCase()).append(newStr.substring(1)).toString();
    }
    
    /**
     * 首字母转换为小写
     * 
     * @param newStr String
     * @return String
     */
    public static String makeFirstLetterLowerCase(String newStr)
    {
        if (newStr.length() == 0)
        {
            return newStr;
        }
        char[] oneChar = new char[1];
        oneChar[0] = newStr.charAt(0);
        String firstChar = new String(oneChar);
        return new StringBuilder().append(firstChar.toLowerCase()).append(newStr.substring(1)).toString();
    }
    
    /**
     * 格式化对象数组信息
     * 
     * @param message message
     * @param args Object
     * @return String
     */
    public static String formatParamMsg(String message, Object[] args)
    {
        int length = args.length;
        for (int i = 0; i < length; i++)
        {
            message =
                message.replace(new StringBuilder().append("{").append(i).append("}").toString(), args[i].toString());
        }
        return message;
    }
    
    /**
     * 格式化Map对象信息
     * 
     * @param message
     * @param  params
     * @param <K> the type of keys maintained by this map
     * @param <V> the type of mapped values
     * @return String
     */
    public static <K, V> String formatParamMsg(String message, Map<K, V> params)
    {
        if (params == null)
        {
            return message;
        }
        Iterator<K> keyIts = params.keySet().iterator();
        while (keyIts.hasNext())
        {
            String key = (String)keyIts.next();
            Object val = params.get(key);
            if (val != null)
            {
                message =
                    message.replace(new StringBuilder().append("${").append(key).append("}").toString(), val.toString());
            }
        }
        return message;
    }
    
    /** 
     * formatMsg
     * @param msgWithFormat msgWithFormat
     * @param autoQuote autoQuote
     * @param args args
     * @return StringBuilder
     * @see [类、类#方法、类#成员]
     */
    public static StringBuilder formatMsg(CharSequence msgWithFormat, boolean autoQuote, Object[] args)
    {
        int argsLen = args.length;
        boolean markFound = false;
        
        StringBuilder sb = new StringBuilder(msgWithFormat);
        
        if (argsLen > 0)
        {
            for (int i = 0; i < argsLen; i++)
            {
                String flag = new StringBuilder().append("%").append(i + 1).toString();
                int idx = sb.indexOf(flag);
                
                while (idx >= 0)
                {
                    markFound = true;
                    sb.replace(idx, idx + 2, toString(args[i], autoQuote));
                    idx = sb.indexOf(flag);
                }
            }
            
            if (args[argsLen - 1] instanceof Throwable)
            {
                StringWriter sw = new StringWriter();
                ((Throwable)args[argsLen - 1]).printStackTrace(new PrintWriter(sw));
                sb.append("\n").append(sw.toString());
            }
            else if ((argsLen == 1) && (!markFound))
            {
                sb.append(args[argsLen - 1].toString());
            }
        }
        return sb;
    }
    
    /** 
     * formatMsg
     * @param msgWithFormat msgWithFormat
     * @param args args
     * @return StringBuilder
     * @see [类、类#方法、类#成员]
     */
    public static StringBuilder formatMsg(String msgWithFormat, Object[] args)
    {
        return formatMsg(new StringBuilder(msgWithFormat), true, args);
    }
    
    /** 
     * to String
     * @param obj obj
     * @param autoQuote autoQuote
     * @return String
     * @see [类、类#方法、类#成员]
     */
    public static String toString(Object obj, boolean autoQuote)
    {
        StringBuilder sb = new StringBuilder();
        if (obj == null)
        {
            sb.append("NULL");
        }
        else if (obj instanceof Object[])
        {
            int length = ((Object[])(Object[])obj).length;
            for (int i = 0; i < length; i++)
            {
                sb.append(((Object[])(Object[])obj)[i]).append(", ");
            }
            if (sb.length() > 0)
            {
                sb.delete(sb.length() - 2, sb.length());
            }
        }
        else
        {
            sb.append(obj.toString());
        }
        
        if (autoQuote && (sb.length() > 0) && ((sb.charAt(0) != '[') || (sb.charAt(sb.length() - 1) != ']'))
            && ((sb.charAt(0) != '{') || (sb.charAt(sb.length() - 1) != '}')))
        {
            sb.insert(0, "[").append("]");
        }
        return sb.toString();
    }
    
    /** 
     * return Space
     * @param str String
     * @return String
     * @see [类、类#方法、类#成员]
     */
    public static String returnSpace(String str)
    {
        String space = "";
        if (!str.isEmpty())
        {
            String[] path = str.split("\\.");
            int length = path.length - 1;
            for (int i = 0; i < length; i++)
            {
                space = new StringBuilder().append(space).append("&nbsp;&emsp;").toString();
            }
        }
        return space;
    }
    
    /** 
     * get ArrayAs String
     * @param arr List
     * @return String
     * @see [类、类#方法、类#成员]
     */
    public static String getArrayAsString(List<String> arr)
    {
        if (arr.isEmpty())
        {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int size = arr.size();
        for (int i = 0; i < size; i++)
        {
            if (i > 0)
            {
                sb.append(',');
            }
            sb.append((String)arr.get(i));
        }
        return sb.toString();
    }
    
    /** 
     * getArrayAsString
     * @param arr array
     * @return String
     * @see [类、类#方法、类#成员]
     */
    public static String getArrayAsString(String[] arr)
    {
        if ((arr == null) || (arr.length == 0))
        {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int arrLength = arr.length;
        for (int i = 0; i < arrLength; i++)
        {
            if (i > 0)
            {
                sb.append(',');
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }
    
    /** 
     * getSetAsString
     * @param set set
     * @param <T> the type of elements maintained by this set
     * @return String
     * @see [类、类#方法、类#成员]
     */
    public static <T> String getSetAsString(Set<T> set)
    {
        if (set.isEmpty())
        {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        Iterator<T> it = set.iterator();
        while (it.hasNext())
        {
            if (i++ > 0)
            {
                sb.append(',');
            }
            sb.append(it.next().toString());
        }
        return sb.toString();
    }
    

    
    /** 
     * stringToHtmlEntity
     * @param str str
     * @return String
     * @see [类、类#方法、类#成员]
     */
    public static String stringToHtmlEntity(String str)
    {
        StringBuffer sb = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++)
        {
            char c = str.charAt(i);
            
            switch (c)
            {
                case '\n':
                    sb.append(c);
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '\'':
                    sb.append("&apos;");
                    break;
                case '"':
                    sb.append("&quot;");
                    break;
                default:
                    if ((c < ' ') || (c > '~'))
                    {
                        sb.append("&#x");
                        sb.append(Integer.toString(c, 16));
                        sb.append(';');
                    }
                    else
                    {
                        sb.append(c);
                    }
            }
        }
        return sb.toString();
    }
    
    /** 
     * 处理database使用的特殊字符
     * @param str str
     * @return String
     * @see [类、类#方法、类#成员]
     */
    public static String convertSpecialCharacterforDB(String str)
    {
        if (null != str && !"".equals(str))
        {
            str = str.replaceAll("'", "''");
            str = str.replaceAll("\\\\", "\\\\\\\\");
            str = str.replaceAll("%", "\\\\%");
            str = str.replaceAll("_", "\\\\_");
        }
        return str;
    }
    
    /** 
     * 处理database使用的特殊字符，如果是预编译的SQL，单引号不需要转义
     * @param str str
     * @return String
     * @see [类、类#方法、类#成员]
     */
    public static String convertSpecialCharacterforPreparedStatement(String str)
    {
        if (null != str && !"".equals(str))
        {
            str = str.replaceAll("\\\\", "\\\\\\\\");
            str = str.replaceAll("%", "\\\\%");
            str = str.replaceAll("_", "\\\\_");
        }
        return str;
    }


    
    /**
     * mybatis查询时，特殊字符处理,rex_like
     * 
     * @param appName
     *            包含特殊字符的字符串
     * @return 转译后的字符串
     */
    public static String mybatisQueryConvert(String appName)
    {
        if (appName != null)
        {
            appName = appName.replace("\\", "\\\\");
            appName = appName.replace("$", "\\$");
            appName = appName.replace("(", "\\(");
            appName = appName.replace(")", "\\)");
            appName = appName.replace("[", "\\[");
            appName = appName.replace("]", "\\]");
            appName = appName.replace("%", "\\%");
            appName = appName.replace("?", "\\?");
            appName = appName.replace("^", "\\^");
            appName = appName.replace("*", "\\*");
            appName = appName.replace("+", "\\+");
            appName = appName.replace("|", "\\|");
            appName = appName.replace(".", "\\.");
            appName = appName.replace("_", "\\_");
        }
        
        return appName;
        
    }
    
    /**
     * 处理文件名字中的特殊字符
     * 
     * @param name String
     * @return String
     */
    public static String fileNameFilter(String name)
    {
        
        if (StringUtil.isEmpty(name))
        {
            return null;
        }
        
        else
        {
            name = name.replace("/", "");
            name = name.replace("*", "");
            name = name.replace("?", "");
            
            name = name.replace("\"", "");
            name = name.replace(":", "");
            
            name = name.replace("<", "");
            name = name.replace(">", "");
            
            name = name.replace("|", "");
            
            return name;
        }
        
    }
    
    /** 
     * get String
     * @param str str
     * @return String
     * @see [类、类#方法、类#成员]
     */
    public static String getString(String str)
    {
        return str == null ? "" : str;
    }
    
    /**
     * 解析String
     * 
     * @param str
     *            字符串
     * @param defaultValue
     *            默认值
     * @return 数值
     */
    public static Double toDouble(String str, Double defaultValue)
    {
        try
        {
            return Double.parseDouble(str);
        }
        catch (NumberFormatException e)
        {
            return defaultValue;
        }
    }
    
    /**
     * 解析String
     * 
     * @param str
     *            字符串
     * @param defaultValue
     *            默认值
     * @return 数值
     */
    public static Integer toInteger(String str, Integer defaultValue)
    {
        try
        {
            return Integer.parseInt(str);
        }
        catch (NumberFormatException e)
        {
            return defaultValue;
        }
    }
    
    /**
     * 判断两个string是否相等
     * 
     * @param str1
     *            str1
     * @param str2
     *            str2
     * @return 是否相等
     */
    public static boolean equalIgnoreCase(String str1, String str2)
    {
        if (str1 == null)
        {
            return str2 == null;
        }
        return str1.equalsIgnoreCase(str2);
    }
    
    /**
     * 把结果合成一行
     * 
     * @param obj
     *            对象
     * @return 结果
     */
    public static String compactInOneLine(Object obj)
    {
        if (obj == null)
        {
            return "";
        }
        String str = obj.toString();
        if (str == null)
        {
            return "";
        }
        return str.replace("\n", "");
    }
    
    /**
     * 将字符串转换成列表
     * 
     * @param str
     *            字符串
     * @param separator
     *            分隔符，如果该参数为空则默认是逗号
     * @return 字符串列表
     */
    public static List<String> convertString2List(String str, String separator)
    {
        if (!StringUtil.isEmpty(str))
        {
            String[] strArray = str.split(!StringUtil.isEmpty(separator) ? separator : ",");
            
            return Arrays.asList(strArray);
        }
        
        return null;
    }
    
    /**
     * 特殊字符处理
     * 
     * @param inputName
     *            字符串
     * @return 字符串
     */
    public static String convertSpecialSelName(String inputName)
    {
        if (!StringUtil.isEmpty(inputName))
        {
            inputName = inputName.replace("\\", "\\\\");
            inputName = inputName.replace("$", "\\$");
            inputName = inputName.replace(".", "\\.");
            inputName = inputName.replace("(", "\\(");
            inputName = inputName.replace(")", "\\)");
            inputName = inputName.replace("%", "\\%");
            inputName = inputName.replace("*", "\\*");
            inputName = inputName.replace("?", "\\?");
            inputName = inputName.replace("^", "\\^");
            inputName = inputName.replace("+", "\\+");
            inputName = inputName.replace("|", "\\|");
            inputName = inputName.replace("_", "\\_");
            return inputName;
        }
        return null;
    }
    
    /**
     * 获取id与name对
     * @param  idStr id串，以逗号隔开
     * @param nameStr name串，以逗号隔开
     * @return Map<String, String> key为id，value为与之对应的name
     * @author jiww
     */
    public static Map<String, String> getIDNamePairs(String idStr, String nameStr)
    {
        Map<String, String> idNamePairs = new HashMap<String, String>(16);
        String[] idArray = idStr.split(",");
        String[] nameArray = nameStr.split(",");
        int len = idArray.length;
        for (int i = 0; i < len; i++)
        {
            idNamePairs.put(idArray[i], nameArray[i]);
        }
        
        return idNamePairs;
    }
    /**
     * 校验字符串最大长度
     * 
     * @param str
     *            要校验的字符串
     * @param length
     *            最大长度
     * @return boolean
     */
    public static boolean ltLen(String str, int length)
    {
        return str == null ? true : str.length() <= length;
    }
    
    /**
     * 校验字符串最小长度
     * 
     * @param str
     *            要校验的字符串
     * @param length
     *            最小长度
     * @return boolean
     */
    public static boolean gtLen(String str, int length)
    {
        return str == null ? false : str.length() >= length;
    }
  
    /**
     * 判断文件路径是否合法，防止注入
     * 
     * 判断是否包含..这种路径跨越的情况
     * 
     * @param str
     * @return boolean true：文件路径合法 false：文件路径不合法
     */
    public static boolean isValidFilePath(String str)
    {
        return str.indexOf("./") < 0;
    }
    
    /**
     * 如果string为null，返回"";否则返回本身。
     * @author       wuqi/00025968
     * @since        Across PM V100R001C20, 2015-2-28
     * @param strings0
     * @return
     */
    public static String getNullString(String strings0)
    {
        return strings0 == null ? "" : strings0;
    }
    
    /**
     * 去掉下划线及中线
     * 
     * @author       qiliang
     * @since        Across PM V100R001C20, 2015-3-13
     * @param inputs1
     * @return
     */
    public static String removeUnderLine(String inputs1){
        if (StringUtils.isEmpty(inputs1))
        {
            return null;
        }
        
        String res0 = inputs1;
        
        // 处理-
        res0 = res0.replace("-", "");
        
        // 处理_
        res0 = res0.replace("_", "");
        return res0;
    }
    
    
    /**
     * 用百分号包裹字符串
     * (功能详细描述)
     * @since        Across PM V100R001C20, 2015-6-2
     * @param strs1   string
     * @return %str%, if null or '' return null
     */
    public static String wrapWithPercent(String strs1){
        return strs1 == null || strs1.isEmpty() ? null : new StringBuilder("%").append(strs1).append("%").toString();
    }
    
    /**
     * 从sourceStr字符串中剔除cleanStr
     * */
    public static String cleanString(String sourceStr, String cleanStr){
		if(isEmpty(sourceStr) || isEmpty(cleanStr)){
			return sourceStr;
		}
		/**
		 * 从"123456123456"中清除"123" 
		 * sourceStr长度是12，cleanStr长度是3
		 * 从sourceStr的第0个字符开始遍历，直到倒数12-3
		 * 每次循环从sourceStr中截取cleanStr长度的字符串进行比较
		 * 每次递归只清除一次，全部递归完成后，所以要清理的字符被清理掉
		 * */
		for(int i = 0; i<=(sourceStr.length()-cleanStr.length());i++){
			if(sourceStr.substring (i, i+cleanStr.length())
					.equals(cleanStr)){
				//拼接剩余的字符串
				String result = sourceStr.substring(0, i) + 
						sourceStr.substring(i+cleanStr.length(), sourceStr.length());
				return cleanString(result, cleanStr);
			}
		}
		
		return sourceStr;
	}
    
    
    public static String transferXML(String str)
	{
		return str.replace("&", "&amp;")
				.replace("<", "&lt;").replace(">", "&gt;")
				.replace("'", "&#x27;").replace("\"", "&quot;")
				.replace("/", "&#x2F;");
	}


    /**
     * 将给定的字符串按照指定的长度进行截取，生成数组
     * @author       liandi
     * @since        Across PM V100R001C20, 2017年1月12日
     * @param str      需要处理的字符串
     * @param length   数组中每个元素所包含的字符长度
     * @return
     */
    public static String[] toStringArrayByLength(String str,int length)
    {
    	if(isEmpty(str))
    	{
    		return null;
    	}
    	
    	int strLen = str.length();
    	
    	if(strLen <= length)
    	{
    		return new String[]{str};
    	}
    	
    	int strArrayLength = 0;
    	
    	if((strLen % length) == 0)
    	{
    		strArrayLength = strLen / length;
    	}
    	else
    	{
    		strArrayLength = strLen / length + 1;
    	}
    	
    	String[] result = new String[strArrayLength];
    	String item = null;
    	int index = 0;
    	while(str.length() > 0)
    	{
    		if(str.length() < length)
    		{
    			length = str.length();
    		}
    		
    		item = str.substring(0,length);
    		str = str.substring(length);
    		
    		result[index] = item;
    		
    		index++;
    	}
    	
    	return result;
    }
    
    public static String generateHashCode(String string){
		return String.valueOf(Integer.toUnsignedLong(string.hashCode()));
	}
    
    /**
     * 计算指定字符在字符串中出现的个数
     */
    public static int countCharInString(String srcString, String countChar)
	{
		if (BeanUtils.isEmpty(srcString) || BeanUtils.isEmpty(countChar))
		{
			return 0;
		}
		
		int count = 0;
		for(;srcString.contains(countChar);)
		{
			count ++;
			srcString = srcString.replaceFirst(countChar, "");
		}
		return count;
	}

}
