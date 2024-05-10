package com.zz.libserver.model;

import com.zz.libserver.model.common.BaseEntity;
import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.Id;
import org.babyfish.jimmer.sql.GeneratedValue;
import org.babyfish.jimmer.sql.Key;
import org.jetbrains.annotations.Nullable;
import org.babyfish.jimmer.sql.GenerationType;
import java.time.LocalDateTime;

/**
 * Entity for table "student"
 */
@Entity
public interface Student extends BaseEntity {

  /**
   * 主键
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY
  )
  long id();

  /**
   * 学号
   */
  @Key
  String number();

  /**
   * 姓名
   */
  String name();

  /**
   * 密码
   */
  @Nullable
  String password();

  /**
   * 手机号
   */
  @Key
  String phone();

  /**
   * 性别
   */
  String sex();


  /**
   * 状态
   */
  @Nullable
  Integer status();
}

