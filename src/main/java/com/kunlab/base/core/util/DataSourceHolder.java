package com.kunlab.base.core.util;

/**
 * 持有线程当前使用的数据源的key
 *
 * @author likun
 * @date 2021/4/26
 */
public class DataSourceHolder {

    private static final ThreadLocal<String> HOLDER = new ThreadLocal<String>();

    /**
     * 获取当前线程持有数据源的key
     * @return java.lang.String
     */
    public static String getDataSourceKey() {
        return HOLDER.get();
    }

    /**
     * 切换当前线程的数据源
     * @param dataSourceKey
     */
    public static void setDataSourceKey(String dataSourceKey) {
        HOLDER.set(dataSourceKey);
    }

    /**
     * 移除当前线程的数据源
     */
    public static void removeDataSourceKey() {
        HOLDER.remove();
    }
}
