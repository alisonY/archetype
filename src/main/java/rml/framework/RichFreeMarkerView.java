package rml.framework;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

/**
 * 项目中rootPath不可用 这里赋值
 */
public class RichFreeMarkerView extends FreeMarkerView {
	
    /** 项目根路径 **/
    private static final String ANOTHER_CONTEXT_PATH = "rootPath";
    /** 项目上下文 **/
    private static final String CONTEXT_PATH_SIGN    = "BasePath";

    protected void exposeHelpers(Map<String, Object> model,HttpServletRequest request) throws Exception {
        super.exposeHelpers(model, request);
        StringBuffer url = new StringBuffer(request.getScheme() + "://");
        //使用下面的方式会出多出一个斜杠 http://10.10.10.230:9090//css/h5.cs 
        //url.append(request.getServerName()).append(":").append(request.getServerPort()).append(request.getContextPath());
        url.append(request.getServerName()).append(":").append(request.getServerPort());
        model.put(ANOTHER_CONTEXT_PATH, url.toString());
        model.put(CONTEXT_PATH_SIGN, request.getContextPath());
    }

}
