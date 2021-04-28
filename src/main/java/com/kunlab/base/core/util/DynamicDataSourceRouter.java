package com.kunlab.base.core.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源切换，例子如下：
 * <pre class="code">
 * &lt;bean id="dataSourceRouter" class="com.kunlab.base.core.util.DynamicDataSourceRouter"&gt;sql将两张表格合并
 *   &lt;property name="targetDataSources"&gt;
 *     &lt;map&gt;
 *       &lt;entry key="writeDataSource" value-ref="writeDataSource"/&gt;
 *       &lt;entry key="readDataSource" value-ref="readDataSource"/&gt;
 *     &lt;/map&gt;
 *   &lt;/property&gt;
 *   &lt;property name="defaultTargetDataSource" ref="writeDataSource"/&gt;
 * &lt;/bean&gt;</pre>
 *
 * @author likun
 * @date 2021/4/25
 */
public class DynamicDataSourceRouter extends AbstractRoutingDataSource{

    /**
     * 查找线程当前的数据源
     */
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getDataSourceKey();
    }
}
