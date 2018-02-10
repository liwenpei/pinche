package com.project.xxx.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;  
  
@Controller  
@RequestMapping("/paramurl")  
public class ParamController {  
      
    @RequestMapping(value="paramTest",method=RequestMethod.POST)  
    public String paramTest(HttpServletRequest request){
    	System.out.println("1");
    	Map<String,String> parmMap=new HashMap<String,String>();
    	//方式一：getParameterMap()，获得请求参数map  
        Map<String,String[]> map= request.getParameterMap();  
        //参数名称  
        Set<String> key=map.keySet();  
        //参数迭代器  
        Iterator<String> iterator = key.iterator();  
        while(iterator.hasNext()){  
            String k=iterator.next();  
            parmMap.put(k, map.get(k)[0]);  
        }  
        System.out.println("parmMap====="+parmMap.toString());  
        /*System.out.println(param);  
        JSONObject jo=new JSONObject();  
          
        //如果页面传的是json字符串，用下列方式解析  
//      Map<String, Object> m=(Map<String, Object> )jo.parse(param); //string转map  
//      System.out.println(m);//          
//      JSONObject parseObject = jo.parseObject(param); //string转json  
//      System.out.println(parseObject);  
          
        //如果页面传的是json数组字符串，用下列方式解析  
        List<Map> parseArray = jo.parseArray(param, Map.class);  
        System.out.println(parseArray); //string转list  
          
        JSONArray parseArray2 = jo.parseArray(param);  
        System.out.println(parseArray2);  */
        return "ok";  
    }  
    
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		System.out.println("1");  
		return "showUser";
	}
}  
