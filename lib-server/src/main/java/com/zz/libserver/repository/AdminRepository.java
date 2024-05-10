package com.zz.libserver.repository;

import com.zz.libcommon.exception.CustomException;
import com.zz.libserver.model.Admin;
import com.zz.libserver.model.AdminFetcher;
import com.zz.libserver.model.AdminTable;
import com.zz.libserver.model.dto.AdminInput;
import org.babyfish.jimmer.spring.repository.JRepository;


public interface AdminRepository extends JRepository<Admin, Long> {

  AdminTable adminTable = AdminTable.$;
  AdminFetcher COMPLEX_FETCHER = AdminFetcher.$.allScalarFields();
  AdminFetcher SIMPLE_FETCHER = AdminFetcher.$.name().username().phone().status().updateTime();


  default Admin findAdmin(AdminInput adminInput){
      return sql().createQuery(adminTable)
          .where(adminTable.username().eq(adminInput.getUsername()))
          .select(adminTable.fetch(COMPLEX_FETCHER))
          .fetchOptional()
          .orElseThrow(()->new CustomException("用户名或密码错误"));
  }


}