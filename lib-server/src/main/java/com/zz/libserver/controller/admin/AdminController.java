package com.zz.libserver.controller.admin;

import com.zz.libcommon.result.Result;
import com.zz.libserver.model.dto.AddAdminInput;
import com.zz.libserver.model.dto.AdminInput;
import com.zz.libserver.repository.AdminRepository;
import com.zz.libserver.service.AdminService;
import jakarta.annotation.Resource;
import com.zz.libserver.model.Admin;

import lombok.extern.slf4j.Slf4j;
import org.babyfish.jimmer.client.FetchBy;
import org.babyfish.jimmer.client.meta.DefaultFetcherOwner;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Slf4j
@DefaultFetcherOwner(AdminRepository.class)
public class AdminController {

  @Resource
  private AdminService adminService;

  /**
   * 根据id查询管理员信息
   * @param id 用户id
   * @return  返回的所有信息
   */
  @GetMapping("/id/{id}")
  public  @FetchBy(value = "COMPLEX_FETCHER") Admin getAdminById(@PathVariable("id") long id) {
      return adminService.findById(id);
  }
  /**
   * 登录接口
   * @param adminInput 用户名和密码
   * @return  返回登录结果
   */

  @PutMapping("doLogin")
  public Result<String> doLogin(@RequestBody AdminInput adminInput) {
      return adminService.doLogin(adminInput);
  }

  /**
   * 判断是否登录
   * @return 返回是否已经登录
   */
  @GetMapping("isLogin")
  public Result<String> isLogin(){
    return adminService.isLogin();
  }

  /**
   * 退出登录
   * @return 返回结果
   */
  @PutMapping("logout")
  public Result<String> logout(){
//    log.info("执行退出登录......");
    return adminService.logout();
  }

  /**
   * 分页查询
   * @param pageIndex 第几页
   * @param pageSize 每页的条数
   * @return 返回分页查询结果
   */
  @GetMapping("list")
  public Page< @FetchBy(value = "SIMPLE_FETCHER")Admin> list(
      @RequestParam(defaultValue = "0") int pageIndex,
      @RequestParam(defaultValue = "5") int pageSize

  ){
   return adminService.list(pageIndex, pageSize);
  }

  /**
   * 添加管理员
   * @param addAdminInput  表单数据
   * @return Result
   */
  @PostMapping("add")
  public Result<String> add(@RequestBody AddAdminInput addAdminInput){
    return adminService.add(addAdminInput);
  }




}
