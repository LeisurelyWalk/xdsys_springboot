package com.xd.sys.Dao;

import com.xd.sys.objectData.StudentInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhoukang on 2017/11/25.
 */
public interface StudentInfoDao extends JpaRepository<StudentInfo,Integer> {
        Page<StudentInfo> findByStudentIdIn(List<Integer> integers, Pageable pageable);
}
