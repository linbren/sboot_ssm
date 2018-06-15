package net.business.system.dao;

import net.business.system.entity.TsFunction;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
public interface TsFunctionDao extends Mapper<TsFunction> {
    public List<TsFunction> getFunctionList(Integer userId);
    public List<TsFunction> getFunctionByUserId(Integer userId);
}