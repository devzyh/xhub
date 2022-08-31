package cn.devzyh.xhub.web.config;

import cn.devzyh.xhub.web.utils.ModelUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.web.bind.annotation.ControllerAdvice
public class WebControllerAdvice {

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     *
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        ModelUtils.loadGlobal(model);
    }

    /**
     * 统一异常处理
     *
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHander(Exception e) throws Exception {
        e.printStackTrace();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        return mv;
    }

}
