package com.zz.libserver.service;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.db.sql.SqlUtil;
import com.zz.libcommon.result.Result;
import com.zz.libserver.model.Objects;
import com.zz.libserver.model.Student;
import com.zz.libserver.model.dto.StatusDTo;
import com.zz.libserver.model.dto.StudentDTO;
import com.zz.libserver.repository.StudentRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentService {
  @Resource
  private StudentRepository studentRepository;

  public Page<Student> list(int pageIndex, int pageSize) {
      return studentRepository.findAll(pageIndex,pageSize,studentRepository.SIMPLE_FETCHER);
  }

  public Student getByName(String name) {
      return studentRepository.findByName(name);
  }

  public Result<String> add(StudentDTO studentDTO) {
    studentDTO.setStatus(1);
    studentDTO.setPassword("123456");
    try{
      studentRepository.save(studentDTO);
    }
    catch (Exception e){
      return Result.error("已经有了别重复添加了");
    }
    return Result.success("添加成功");
  }
  public Result<String> status(StatusDTo status) {
    studentRepository.update(status);
    return Result.success();
  }

  public Result<String> delete(String number) {
    try {
      studentRepository.deleteByNumber(number);
    }catch (Exception e){
      log.info(String.valueOf(e));
      return Result.error("删除失败");
    }
    return Result.success("删除成功");
  }
}
