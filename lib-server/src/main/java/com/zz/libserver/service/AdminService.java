package com.zz.libserver.service;


import cn.dev33.satoken.stp.StpUtil;

import com.zz.libcommon.result.Result;
import com.zz.libserver.model.Admin;

import com.zz.libserver.model.dto.AddAdminInput;
import com.zz.libserver.model.dto.AdminInput;
import com.zz.libserver.repository.AdminRepository;

import jakarta.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

  @Resource
  private AdminRepository adminRepository;


  public Admin findById(Long id) {
    return adminRepository.findNullable(id, adminRepository.COMPLEX_FETCHER);
  }

  public Result<String> doLogin(AdminInput adminInput) {
      Admin admin = adminRepository.findAdmin(adminInput);
      if(!admin.password().equals(adminInput.getPassword())){
          return Result.error("用户名或密码错误");
      }
      StpUtil.login(admin.id());
      return Result.success("登录成功");
  }
  public Result<String> isLogin() {
    if(StpUtil.isLogin()){
        return Result.success();
    }
    else {
      return Result.error("请登录");
    }
  }
  public Result<String> logout() {
      StpUtil.logout();
      return Result.success("登出成功");
  }
  public Page<Admin> list(int pageIndex, int pageSize) {
    return adminRepository.findAll(pageIndex,pageSize,adminRepository.SIMPLE_FETCHER);
  }

  public Result<String> add(AddAdminInput addAdminInput) {
    addAdminInput.setStatus(1);
    addAdminInput.setCreateUser(1L);
    addAdminInput.setUpdateUser(1L);
    addAdminInput.setPassword("123456");
    try {
      adminRepository.save(addAdminInput);
    }
    catch ( Exception e){
      return Result.error("手机号或身份证号已经存在了");
    }
    return Result.success("添加成功");
  }

}
