import freemarker.template.TemplateExceptionHandler;
import org.junit.Test;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * *
 *
 * @author: xujian
 * @create: 2023-12-05 09:38
 **/
public class FreeMarkerTest {

    @Test
    public void dataModel() throws IOException, TemplateException {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setDirectoryForTemplateLoading(new File("src/main/resources/template"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setNumberFormat("0.######");
        // FreeMarker模板保存在src/main/resources/templates目录下的maxie.html.ftl文件里
        // 创建模板对象，加载指定模板
        Template template = cfg.getTemplate("maxie.html.ftl");

        //设置数据模型
  //       {
  //           "currentYear": 2023,
  //               "menuItems": [
  //           {
  //               "url": "https://baidu.cn",
  //                   "label": "编程"
  //           },
  //           {
  //               "url": "https://baidu.com",
  //                   "label": "maxie出版"
  //           }
  // ]
  //       }


        HashMap<Object, Object> dataModelMap = new HashMap<>();

        dataModelMap.put("currentYear",2023);
        ArrayList<Map<String,String>> lists = new ArrayList<>();
        HashMap<String, String> liMap = new HashMap<>();
        liMap.put("url","https://baidu.cn");
        liMap.put("label","编程");
        lists.add(liMap);

        liMap = new HashMap<>();
        liMap.put("url","https://baidu.cn");
        liMap.put("label","maxie出版");
        lists.add(liMap);

        dataModelMap.put("menuItems",lists);

        // 指定生成的文件
        Writer out = new FileWriter("myweb.html");
        // 调用process方法，处理并生成文件
        template.process(dataModelMap, out);

        // 生成文件后别忘了关闭哦
        out.close();
    }
}
