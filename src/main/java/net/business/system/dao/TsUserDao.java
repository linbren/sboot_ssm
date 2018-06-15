package net.business.system.dao;

import net.business.system.entity.TsFunction;
import net.business.system.entity.TsUser;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TsUserDao extends Mapper<TsUser> {
    public TsUser getUserByName(String userName);
    public List<TsFunction> getFunctionsByUserName(String userName);
}