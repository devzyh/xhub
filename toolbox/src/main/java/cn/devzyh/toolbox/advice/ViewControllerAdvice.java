package cn.devzyh.toolbox.advice;

import cn.devzyh.toolbox.utils.ViewModelUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class ViewControllerAdvice {

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     *
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        ViewModelUtils.loadGlobal(model);
    }

}
