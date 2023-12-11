
<#--注意包名路径-->
package ${basePackage}.model;

import lombok.Data;

/**
* 数据模型
**/
@Data
public class DataModel {

<#--多个属性需要list-->
<#list modelConfig.models as modelInfo>
    <#if modelInfo.description??>
<#--        判断modelInfo.description是否为空，不为空则显示注解，否则不显示-->
        /**
        * ${modelInfo.description}
        */
    </#if>
<#--    注意只有属性的默认值不为空，才能出现等号-->
    private ${modelInfo.type} ${modelInfo.fieldName}<#if modelInfo.defaultValue??> = ${modelInfo.defaultValue?c}</#if>;
</#list>
}
