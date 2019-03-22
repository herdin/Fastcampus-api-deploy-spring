package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import vos.ListVo;

@Controller
public class TestDefaultController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestDefaultController.class);
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@RequestMapping(value="testInit", method=RequestMethod.GET)
	public String testInit() {
		return "testInit";
	}//END OF FUNCTION
	
	@RequestMapping(value="list_init", method=RequestMethod.GET)
	public void list_init(@RequestParam Map<String,Object> map, HttpServletResponse response) {
		logger.debug("list_init START");
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			logger.debug("key : {} : value : {}", key, map.get(key));
		}
		
		List<ListVo> list = sqlSessionTemplate.selectList("sql.list.selectList");
		
		ObjectMapper mapper =  new ObjectMapper();
		try {
			response.getWriter().print(mapper.writeValueAsString(list));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.debug("testAjax END");
	}//END OF FUNCTION

	@RequestMapping(value="list", method=RequestMethod.GET)
	public @ResponseBody List<ListVo> list(@RequestParam Map<String,Object> map, HttpServletResponse response) {
		logger.debug("list START");
		return sqlSessionTemplate.selectList("sql.list.selectList");
	}//END OF FUNCTION
	
}//END OF CLASS
