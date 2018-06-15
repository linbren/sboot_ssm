package net.business.system.service;

import com.github.pagehelper.PageInfo;
import net.business.system.entity.TsFunction;
import net.business.system.entity.TsUser;

import java.util.List;


public interface UserService {

    public TsUser getUserById(Integer id);
	public TsUser getUserByName(String userName, String password);
	public TsUser getUserByName(String userName);
	public List<TsFunction> getFunctionsByUserName(String userName);
    public PageInfo<TsUser> getList(Integer pageNum, Integer pageSize);

}
