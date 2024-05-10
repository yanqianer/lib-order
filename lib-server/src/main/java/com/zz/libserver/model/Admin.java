package com.zz.libserver.model;

import com.zz.libserver.model.common.BaseEntity;
import org.jetbrains.annotations.Nullable;
import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.Id;
import org.babyfish.jimmer.sql.GeneratedValue;

import org.babyfish.jimmer.sql.GenerationType;

/**
 * Entity for table "admin"
 */
@Entity
public interface Admin extends BaseEntity {

  /**
   * 主键
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY
  )
  long id();

  /**
   * 姓名
   */
  String name();

  /**
   * 用户名
   */
  String username();

  /**
   * 密码
   */
  @Nullable
  String password();

  /**
   * 手机号
   */
  String phone();

  /**
   * 性别
   */
  String sex();

  /**
   * 身份证号
   */
  String idNumber();

  /**
   * 状态,1是启用,0是禁用
   */
  @Nullable
  Integer status();

  /**
   * 创建人
   */
  @Nullable
  Long createUser();

  /**
   * 修改人
   */
  @Nullable
  Long updateUser();
}

