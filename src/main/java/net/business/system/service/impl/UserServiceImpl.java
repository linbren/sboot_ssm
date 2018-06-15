package net.business.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.business.system.dao.TsUserDao;
import net.business.system.entity.TsFunction;
import net.business.system.entity.TsUser;
import net.business.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TsUserDao tsUserDao;


	@Override
	public TsUser getUserById(Integer id) {	
		return tsUserDao.selectByPrimaryKey(id);
	}
	@Override
	public TsUser getUserByName( String userName,String password) {	
		TsUser u=new TsUser();
		u.setUserName(userName);
		u.setUserPass(password);
		return tsUserDao.selectOne(u);
	}		
	public TsUser getUserByName( String userName){
//		TsUser u=new TsUser();
//		u.setUserCode("ssm_admin");
//		u.setUserName("管理员");
//		u.setUserPass("21218CCA77804D2BA1922C33E0151105");
//		u.setStatus("1");
//		u=tsUserDao.getUserByName(userName);
		return tsUserDao.getUserByName(userName);	
	}
	public List<TsFunction> getFunctionsByUserName(String userName){
		return tsUserDao.getFunctionsByUserName(userName);
	}
	public PageInfo<TsUser> getList(Integer pageNum, Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<TsUser> list = tsUserDao.selectAll();
		return new PageInfo<TsUser>(list);
	}

}

