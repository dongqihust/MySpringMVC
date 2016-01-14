package com.springapp.mvc;


import com.mysql.jdbc.StringUtils;
import com.springapp.common.Pagination;
import com.springapp.domain.LagouCity;
import com.springapp.domain.Users;
import com.springapp.service.LagouCityService;
import com.springapp.service.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import static java.lang.System.currentTimeMillis;


@Controller
@RequestMapping("/user")
public class HelloController {

	@Autowired
	private UserService userService;

	@Autowired
	private LagouCityService lagouCityService;


	/**
	 * 分页处理Json
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getUsers",method = RequestMethod.GET)
	public Pagination<Users> printWelcome(HttpServletRequest request) {
		Pagination<Users> page = new Pagination<Users>();
		page.setPageSize(5);
		String pageCount = request.getParameter("page");

		if (StringUtils.isNullOrEmpty(pageCount)) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(pageCount));
		}
		page.getStartPage();
		page = userService.getUsers(page);

		return page;

	}


	/**
	 * 分页处理Json
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getCitys",method = RequestMethod.GET)
	public Pagination<LagouCity> printFuck(HttpServletRequest request) {
		Pagination<LagouCity> page = new Pagination<LagouCity>();
		page.setPageSize(5);
		String pageCount = request.getParameter("page");

		if (StringUtils.isNullOrEmpty(pageCount)) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(pageCount));
		}
		page.getStartPage();
		page =lagouCityService.getLagouCitys(page);

		return page;
	}



	@RequestMapping(value = "/home",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String showHomePage(Map<String,Object> model){
		model.put("name","董其");
		return "hello";
	}



	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@ResponseBody
	@RequestMapping(value = "/addImage",method = RequestMethod.POST)
	public int addImage(@RequestParam(value = "image", required = false) MultipartFile image,HttpServletRequest request){
			if(validateImage(image)){

				try {
					//这样能直接上传到web-inf下的resources目录下面
					File file = new File(request.getSession().getServletContext().getRealPath("/WEB-INF")+"/resources/" +currentTimeMillis()+""+image.getOriginalFilename());
					String path = file.getAbsolutePath();
					FileUtils.writeByteArrayToFile(file, image.getBytes());
				} catch (IOException e) {
					return 404;
				}
			}
		return 200;


	}

	private boolean validateImage(MultipartFile image){
		if(!image.isEmpty()){
			if(image.getContentType().contains("image")){
				return true;
			}

		}

		return false;
	}
}