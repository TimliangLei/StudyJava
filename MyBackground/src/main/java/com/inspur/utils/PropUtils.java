package com.inspur.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.URL;
import java.util.Properties;

@Slf4j
public final class PropUtils {

    private static Properties properties = new Properties();

    private static String dDEFAULTPROPPATH = null;

    private static String oDEFAULTPATH = "C:\\Users\\#\\AppData\\Local\\Packages\\Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy\\LocalState\\Assets";

    // 存放default_prop_path。properties或者jvm参数中的key值
//    -DDEFAULT_PROP_PATH=E:\background\prop
    private static String dDEFAULTPROPPATHKEY = "DEFAULT_PROP_PATH";

    public static void loadProperties(){
        new PropUtils().readPropPath();
        InputStream fisPtlP = null;

        if (dDEFAULTPROPPATH != null){
            File foldersPt = new File(dDEFAULTPROPPATH);
            if (foldersPt.exists() && foldersPt.isDirectory() && foldersPt.listFiles().length > 0)
            {
                File[] confPtFiles = foldersPt.listFiles();

                // 将目录中的所有配置文件中的配置项均读入到properties对象中
                // 如果配置项存在重复key，则后加载的将覆盖先加载的，应避免重复key的出现
                for (File filesPt : confPtFiles)
                {
                    if (filesPt.isDirectory())
                    {
                        continue;
                    }
                    // 只读properties文件
                    if (!filesPt.getName().endsWith(".properties"))
                    {
                        continue;
                    }
                    try
                    {
                        fisPtlP = new FileInputStream(filesPt);
                        properties.load(fisPtlP);
                        new PropUtils().modifyPath();
                    }
                    catch (FileNotFoundException e_lP)
                    {
                        log.error(e_lP.getMessage());
                    }
                    catch (IOException e_lP)
                    {
                        log.error(e_lP.getMessage());
                    }
                    finally
                    {
                        if (fisPtlP != null)
                        {
                            try
                            {
                                fisPtlP.close();
                            }
                            catch (IOException ex)
                            {
                                log.error(ex.getMessage());
                            }
                        }
                    }
                }
            }
        } else {
            URL url = Thread.currentThread()
                    .getClass()
                    .getResource("/prop.properties");
            String fileName = null;
            if(null != url){
                fileName = url.getFile();
            }
            if (StringUtils.isNotEmpty(fileName)) {
                log.info("file in jar: /prop.properties");
                fisPtlP = Thread.currentThread().getClass().getResourceAsStream("/prop.properties");
                try {
                    properties.load(fisPtlP);
                    new PropUtils().modifyPath();
                }catch (IOException e){
                    log.error(e.getMessage());
                }

            }
        }
    }
    private void setDefualtPath(){
        StringBuffer str = new StringBuffer(properties.getProperty("file.origin"));
        String userName = System.getenv().get("USERNAME");
        str.replace(str.indexOf("#"),str.indexOf("#")+1,userName);
        properties.setProperty("file.origin",str.toString());
    }
    private void modifyPath(){
        String origin = properties.getProperty("file.origin");
        if (origin == null){
            StringBuffer str = new StringBuffer(oDEFAULTPATH);
            String userName = System.getenv().get("USERNAME");
            str.replace(str.indexOf("#"),str.indexOf("#")+1,userName);
            properties.setProperty("file.origin",str.toString());
        }

    }
    private void readPropPath() {
        String propFilePaths = "";
        // 2. 如果相对路径不存在，再从JVM参数中读
        if (!checkPathExist(propFilePaths)) {
            propFilePaths = System.getProperty(dDEFAULTPROPPATHKEY);
        }
        if (!checkPathExist(propFilePaths)) {
            propFilePaths = System.getProperty(dDEFAULTPROPPATHKEY.toLowerCase());
        }
        // 3. 如果上述两者都没有读到DEFAULTPROPPATH，再读默认值
        if (checkPathExist(propFilePaths)) {
            dDEFAULTPROPPATH = propFilePaths;

        }
    }
    /**
     * 检查目录是否存在
     *
     * @param paths 目录
     *
     * @return true:存在；false:不存在
     */
    private boolean checkPathExist(String paths)
    {
        boolean existFlag1 = false;
        if (StringUtil.isEmpty(paths))
        {
            return existFlag1;
        }
        File file = new File(paths);
        if (file.exists())
        {
            existFlag1 = true;
        }
        return existFlag1;
    }

    /**
     * 根据key读取配置项的value
     *
     * @param keys 配置项的key
     *
     * @return 配置项的value
     */
    public static String getProperties(String keys)
    {
        String values = null;
        if (properties == null || properties.isEmpty())
        {
            loadProperties();
        }
        if (properties != null && !properties.isEmpty())
        {
            values = properties.getProperty(keys);
        }
        return values;
    }
}
