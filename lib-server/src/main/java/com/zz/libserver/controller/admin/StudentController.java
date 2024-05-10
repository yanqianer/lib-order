package com.zz.libserver.controller.admin;

import com.zz.libcommon.result.Result;
import com.zz.libserver.model.Student;
import com.zz.libserver.model.dto.StatusDTo;
import com.zz.libserver.model.dto.StudentDTO;

import com.zz.libserver.repository.StudentRepository;
import com.zz.libserver.service.StudentService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.babyfish.jimmer.client.FetchBy;
import org.babyfish.jimmer.client.meta.DefaultFetcherOwner;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@Slf4j
@DefaultFetcherOwner(StudentRepository.class)
public class StudentController {

  @Resource
  private StudentService studentService;

  /**
   * 获取学生列表
   * @param pageIndex 第几页
   * @param pageSize  一页多少行
   * @return  学生列表
   */
  @GetMapping("list")
  public Page<@FetchBy("SIMPLE_FETCHER") Student> list(
      @RequestParam(defaultValue = "0") int pageIndex,
      @RequestParam(defaultValue = "5") int pageSize) {
    return studentService.list(pageIndex,pageSize);
  }

  /**
   * 根据姓名获取某个学生的信息
   * @param studentName 学生姓名
   * @return  学生信息
   */
  @GetMapping("getByStudentName")
  public @FetchBy("SIMPLE_FETCHER") Student getByStudentName(@RequestParam String studentName){

    return studentService.getByName(studentName);
  }

  /**
   * 添加学生
   * @param studentDTO  学生信息
   * @return  Result
   */
  @PostMapping("addStudent")
  public Result<String> addStudent(@RequestBody StudentDTO studentDTO){
    return studentService.add(studentDTO);

  }

  /**
   * 管理员删除学生
   * @param number  学生学号
   * @return
   */
  @DeleteMapping("deleteStudent")
  public Result<String> delete(@RequestParam String number){
    return studentService.delete(number);
  }

  /**
   * 管理员修改学生状态
   * @param statusDTo id还有状态1或者0
   * @return
   */
  @PostMapping("statusStudent")
  public Result<String> status(@RequestBody StatusDTo statusDTo){//RequestParam好像只能给临时用，像是List什么的，反正自己定义的复杂对象赋值不过来
    return studentService.status(statusDTo);
  }

}
