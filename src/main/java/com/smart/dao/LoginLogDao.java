package com.smart.dao;

import org.springframework.stereotype.Repository;

import com.smart.domain.LoginLog;

/**
 * Post的DAO类
 * @author  leilanjie
 * @date  2019/08/15
 */
@Repository
public class LoginLogDao extends BaseDao<LoginLog> {
	@Override
	public void save(LoginLog loginLog) {
		this.getHibernateTemplate().save(loginLog);
	}

}
