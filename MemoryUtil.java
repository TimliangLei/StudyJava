package com.inspur.pmv5.dpl.pif2pia.util;

public final class MemoryUtil {
    private MemoryUtil(){
        
    }
    /**
     * 获取当前Java虚拟机申请的总内存
     * @return
     */
    public static long getJVMCallocMemory () {
        return Runtime.getRuntime().totalMemory();
    }
    
    /**
     * 获取当前Java虚拟机最大内存
     * @return
     */
    public static long getJVMMaxMemory () {
        return Runtime.getRuntime().maxMemory();
    }
    
    /**
     * 获取当前Java虚拟机被使用的内存
     * @return
     */
    public static long getJVMUsedMemory () {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }
    
    /**
     * 获取当前Java虚拟机空闲内存
     * @return
     */
    public static long getJVMFreeMemory () {
        return Runtime.getRuntime().freeMemory();
    }
    
    /**
     * 
     * 获取当前Java虚拟机最大可用内存,当前申请的总内存,空闲内存和使用内存
     * @return [Max|Total|Free|Used]=[?|?|?|?]
     *      String 返回[]=[]形式，=前面是标题后面是对应的值
     */
    public static String getJVMMMemoryInfo () {
        String meoryInfoStr = "[Max|Calloc|Free|Used]=[" + getJVMMaxMemory();
        long totalL = getJVMCallocMemory();
        long freeL = getJVMFreeMemory();
        long usedL = totalL - freeL;
        meoryInfoStr += "|" + totalL + "|" + freeL + "|" + usedL + "]";
        return meoryInfoStr;
    }
}
