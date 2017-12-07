package cn.home.modules.webmvc.exceptionhandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import cn.home.util.ApplicationUtil;
import cn.home.util.ResponseUtils;



/**
 * @author donald
 * 2017年11月16日
 * 下午4:28:52
 */
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {
	private final String pageError = "common/error";

	public final Log log = LogFactory.getLog(getClass());

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		log.warn("Handle exception: " + ex.getClass().getName());

		if (this.processException(request, response, ex)) {
			return null;
		}
		ex.printStackTrace();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("exception", ex);
		model.put("message", ex.getMessage());
		return new ModelAndView(pageError, model);
	}

	private boolean processException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
		if (ex instanceof org.springframework.web.multipart.MaxUploadSizeExceededException) {
			try {
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("success", false);
				String message = "上传的文件超过系统限制！";
				CommonsMultipartResolver resolver = ApplicationUtil.getBean("multipartResolver",
						CommonsMultipartResolver.class);
				if (resolver != null) {
					long size = resolver.getFileUpload().getSizeMax() / (1024 * 1024);
					if (size > 0) {
						message = String.format("系统文件上传最大支持%sM", size);
					}
				}
				model.put("errorMessage", message);
				ResponseUtils.write(response, model);
			} catch (IOException e) {
				log.error(e);
			}
			return true;
		}
		return false;
	}
}
