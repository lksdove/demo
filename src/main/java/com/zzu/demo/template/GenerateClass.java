package com.zzu.demo.template;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: likangshuai
 * @Date: 2020/7/16 13:02
 * @Describe
 * @Since V1.0
 */
public class GenerateClass {
    private static final String TEMPLATE_PATH = "src/main/java/com/zzu/demo/template/";
    private static final String CLASS_PATH = "src/main/java/com/zzu/demo/template/";
    private static final String PACKAGE_PATH = "com.zzu.demo.template";

    /**
     * 1、生成一个ftl模板文件（new-》edit file template-》ftl设置之后，
     * 可以直接new-》ftl，生成一个ftl文件，然后进行模板编辑即可）
     * 2、设置生成参数、生成路径
     */
    public static void main(String[] args) throws IOException, TemplateException {
        //1、 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        String genClassName = "HelloFreeMaker";
        // 2、 获取模版路径
        configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
        // 3、 准备数据，等会替换用内容，key为模板内变量
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("packagePath", PACKAGE_PATH);
        dataMap.put("className", genClassName);
        dataMap.put("helloWorld", "hello freeMaker,from 香菜");
        // 4、 加载模版文件
        Template template = configuration.getTemplate("helloFreemaker.ftl");
        // 5、将生成的内容
        File docFile = new File(CLASS_PATH + genClassName + ".java");
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
        // 6、输出文件
        template.process(dataMap, out);
        System.out.println(genClassName + ".java 文件创建成功 !");
    }
}
