package com.qq.ssm.dao;

import com.qq.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {

    @Select("select * from member where id = #{id}")
    Member findMemberById (String id);
}
