package com.zz.libserver.model.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import org.babyfish.jimmer.sql.MappedSuperclass;

/*
 * see CommonEntityDraftInterceptor
 */
@MappedSuperclass // ❶
public interface BaseEntity {

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  LocalDateTime createTime();

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  LocalDateTime updateTime();
}