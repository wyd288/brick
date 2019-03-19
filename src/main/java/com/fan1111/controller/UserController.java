package com.fan1111.controller;

import com.alibaba.fastjson.JSONArray;
import com.fan1111.entity.Role;
import com.fan1111.entity.User;
import com.fan1111.service.user.UserService;
import com.fan1111.utils.Constants;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;


	/**
	 * 跳转用户管理页面
	 * @param queryUserName
	 * @param queryUserRole
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String findUsers(@RequestParam(value="queryUserName",required=false)String queryUserName,
							@RequestParam(value="queryUserRole",required=false)String queryUserRole,
							Model model){
		
		List<User> userList = null;//初始化用户信息集合
		List<Role> roleList = null;//初始化用户角色信息集合
		Integer userRole = 0;//初始化用户角色值
		if(queryUserRole != null && !queryUserRole.equals("")){
			userRole = Integer.parseInt(queryUserRole);
		}
		//查询用户信息
		userList = userService.getUserList(queryUserName,userRole);


		model.addAttribute("userList", userList);
		model.addAttribute("activeTable", "activeMenu");
		return "table/teacher";
	}
	/**
	 * 跳转添加用户页面
	 * @return
	 */
	@RequestMapping(value="/userAdd.html")
	public String addUser(){
		return "useradd";
	}
	/**
	 * 检查用户编码是否重复
	 * @param userCode
	 * @return
	 */
	@RequestMapping(value="/checkCode",method=RequestMethod.GET)
	@ResponseBody
	public Object checkCode(@RequestParam(value="userCode")String userCode){
		Map<String, String> resultMap = new HashMap<String, String>();
		if(StringUtils.isNotEmpty(userCode)){
			resultMap.put("userCode", "exist");
		}else{
			User user = userService.getUserByCode(userCode);
			if(null != user){
				resultMap.put("userCode", "exist");
			}else{
				resultMap.put("userCode", "noexist");
			}
		}
		return JSONArray.toJSONString(resultMap);
	}
	
	/**
	 * 添加用户信息功能
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/userSave.html",method=RequestMethod.POST)
	public String saveUser(User user,HttpSession session,
			@RequestParam(value="attches",required=false) MultipartFile[] attches,
			HttpServletRequest request){
		String idPicPath="";
		String workPicPath = "";
		String errorType = "";
		//设置文件上传大小
		int fileSize = 5000000;
		//上传文件位置
		String path = request.getSession().getServletContext().getRealPath("statics"+File.separator+"upload");		
		for(int i = 0;i<attches.length;i++){
			if(i == 0){
				errorType = "uploadError";
			}else{
				errorType = "uploadMError";
			}
			MultipartFile attch = attches[i];
			if(!attch.isEmpty()){
				//获得文件名
				String oldFileName = attch.getOriginalFilename();
				//获得扩展名
				String suffix = FilenameUtils.getExtension(oldFileName);
				if(attch.getSize() > fileSize){
					request.setAttribute(errorType, "* 上传文件最大500kb");
					return "useradd";
				}else if("png".equals(suffix) || "jpg".equals(suffix)){
					//上传
					// 重命名
					String fileName = System.currentTimeMillis()+"-"+RandomUtils.nextInt(999999)+"_card.jpg";
					File PicFile = new File(path, fileName);
					if(!PicFile.exists()){
						PicFile.mkdirs();
					}
					try {
						attch.transferTo(PicFile);
					} catch (Exception e) {
						e.printStackTrace();
						request.setAttribute(errorType, "* 文件上传失败");
					}
					if(i== 0){
						idPicPath = path+File.separator+fileName;
					}else{
						workPicPath = path+File.separator+fileName;
					}
					
				}else{
					request.setAttribute(errorType, "* 文件格式必须是jpg，png");
					return "useradd";
				}
			}
		}
		//完善用户信息
		User cUser = (User)session.getAttribute(Constants.USER_SESSION);
		user.setCreator(cUser.getRole());
		user.setCreationtime(new Date());
		user.setIdPicPath(idPicPath);
		user.setWorkPicPath(workPicPath);
		//添加上传文件地址
		boolean result = userService.insertUser(user);
		if(result){
			//重定向
			return "redirect:/sys/user/userlist.html";
		}
		//出错，停留当前页
		return "useradd";
				
	}
	
	
	/**
	 * 显示用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/view",method=RequestMethod.GET)
	@ResponseBody
	public User viewUser(@RequestParam(value="id")String id){
		Integer userId = Integer.parseInt(id);
		User user = new User();
			try {
				user = userService.getUserById(userId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return user;
	}
	
	/**
	 * 跳转用户信息修改页面
	 * @return
	 */
	@RequestMapping(value="/userModify.html")
	public String modifyUser(@RequestParam("id")Integer id ,HttpServletRequest request){
		if(null == id || id == 0){
			return "redirect:/sys/user/syserror";	
		}else{
			User user = userService.getUserById(id);
			List<Role> rlist = userService.getUserRoleList();
			if(null == user){
				return "redirect:/sys/user/syserror";	
			}else{
				request.setAttribute("user", user);
				request.setAttribute("rlist", rlist);
				return "usermodify";
			}
		}
	}
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/userUpdate.html",method=RequestMethod.POST)
	public String updateUser(User user,HttpSession session){
		if(null == user){//判断用户参数是否为空
			return "redirect:/sys/user/syserror";	
		}else{
			User tempUser = (User)session.getAttribute(Constants.USER_SESSION);
			if(null == tempUser){//判断当前登录用户是否为空
				return "redirect:/sys/user/syserror";
			}else{
				user.setModifier(tempUser.getRole());
				user.setModificationtime(new Date());
				Boolean bool = userService.updateUser(user);
				if(bool){//判断是否更新成功
					return "redirect:/sys/user/userlist.html";
				}else{
					return "usermodify";
				}
			}
		}
	}
	

	/**
	 * 检查旧密码输入是否正确
	 * @param oldpassword
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/checkOldPassword",method=RequestMethod.GET)
	@ResponseBody
	public Object checkOldPassword(String oldpassword,HttpSession session){
		HashMap<String, String> hashMap = new HashMap<String, String>();
		if(null == oldpassword || oldpassword.equals("")){
			hashMap.put("result", "error");
			return hashMap;
		}
		User user = (User)session.getAttribute(Constants.USER_SESSION);
		if(null == user){
			hashMap.put("result", "sessionerror");
			return hashMap;
		}else{
			if(oldpassword.equals(user.getPassword())){
				hashMap.put("result", "true");
				return hashMap;
			}else{
				hashMap.put("result", "false");
				return hashMap;
			}
		}
	}
	
	/**
	 * 跳转修改用户密码页面
	 * @return
	 */
	@RequestMapping(value="/pwdModify.html")
	public String modifyUserPassword(){
		return "pwdmodify";
	}
	@RequestMapping(value="/pwdSave.html")
	public String updateUserPassword(String id,String oldpassword,String newpassword,HttpSession session,HttpServletRequest request){
		if(oldpassword.equals(newpassword) ){//后台判断新旧密码是否相同
			request.setAttribute("message", "密码修改失败，请重试");
			return "pwdmodify";
		}else if(null == id || id.equals("")){//判断传入的ID是否为空
			request.setAttribute("message", "登陆失效，请重新登录");
			return "pwdmodify";
		}else{
			Integer uid = Integer.parseInt(id);
			Boolean bool = userService.updatePasswordById(uid, newpassword);
			if(bool){
				session.removeAttribute(Constants.USER_SESSION);
				return  "redirect:/index.html";
			}else{
				request.setAttribute("message", "密码修改失败，请重试");
				return "pwdmodify";
			}
		}
		
	}
	
	@RequestMapping(value="/deleteUser",method=RequestMethod.GET)
	@ResponseBody
	public Object deleteUser(@RequestParam(value="id")Integer id){
		HashMap<String, String> hashMap = new HashMap<String, String>();
		if(null == id){
			hashMap.put("delResult", "notexist");
			return hashMap;
		}else{
			Boolean bool = userService.deleteUser(id);
			if(bool){
				hashMap.put("delResult", "true");
				return hashMap;	
			}else{
				hashMap.put("delResult", "false");
				return hashMap;	
			}
		}
	}
	
	
	
	
	
	
	
	
	/**
	 * 跳转系统错误页面
	 * @return
	 */
	@RequestMapping("/syserror")
	public String errorPage(){
		return "error";
	}
}
