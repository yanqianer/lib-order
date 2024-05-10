package com.zz.libserver.repository;

import com.zz.libcommon.exception.CustomException;
import com.zz.libserver.model.AdminFetcher;
import com.zz.libserver.model.Student;
import com.zz.libserver.model.StudentFetcher;
import com.zz.libserver.model.StudentTable;
import org.babyfish.jimmer.spring.repository.JRepository;

public interface StudentRepository extends JRepository<Student, Long> {
    StudentTable studentTable = StudentTable.$;
    StudentFetcher SIMPLE_FETCHER = StudentFetcher.$.name().number().phone().status().updateTime();

    default Student findByName(String name) {
        return sql().createQuery(studentTable).where(studentTable.name().eq(name))
            .select(studentTable.fetch(SIMPLE_FETCHER))
            .fetchOptional()
            .orElseThrow(()->new CustomException("学生不存在"));
    }

    void deleteByNumber(String number);
}
