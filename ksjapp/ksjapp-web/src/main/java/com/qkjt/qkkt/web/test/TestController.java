package com.qkjt.qkkt.web.test;

import com.qkjt.qkkt.domain.beans.EasyuiDataGridJson;
import com.qkjt.qkkt.service.test.TestService;
import com.qkjt.qkkt.web.base.BaseController;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * Created by chenfei on 2015/7/1.
 */
@Controller
@RequestMapping("/sys/test")
public class TestController extends BaseController {
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/tolist")
    public ModelAndView tolist(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("test");
        return mv;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public EasyuiDataGridJson list(){
        HashMap<String, Object> map = this.getQueryMap();
        EasyuiDataGridJson json=new EasyuiDataGridJson();
        json.setTotal(testService.findListCount(map));
        json.setRows(testService.findList(map));
        return json;
    }

    /*
     * 获取翻页、查询参数
     */
    protected HashMap<String, Object> getQueryMap() {
        HashMap<String, Object> map =super.getQueryMap();
        // 查询字段相关参数
        if (StringUtils.isNotBlank(request.getParameter("id"))) {
            map.put("id", request.getParameter("id"));
        }
        if (StringUtils.isNotBlank(request.getParameter("state"))) {
            map.put("state", request.getParameter("state"));
        }
        return map;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public boolean delete(){
        boolean b = false ;
        Integer id = Integer.parseInt(request.getParameter("id")) ;
        Integer i = testService.delete(id);
        if(i == 1){
            b = true ;
        }
        return b;
    }
}
