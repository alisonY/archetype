package rml.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rml.dao.MUserMapper;
import rml.model.MUser;
import rml.service.MUserService;

@Service("muserService")
public class MUserServiceImpl implements MUserService{
	
    private static final Logger LOGGER     = LoggerFactory.getLogger(MUserServiceImpl.class);

	@Autowired
	private MUserMapper muserMapper;
		
	@Override
	public List<MUser> getAll() {
		LOGGER.error("get all {} ", new Date());
		return muserMapper.getAll();
	}

	@Override
	public int insert(MUser muser) {
		if(muser.getName().equals("123")){
			LOGGER.error("muser.getName {} ", muser.getName());
		}
		return muserMapper.insert(muser);
	}

	@Override
	public int update(MUser muser) {
		
		return muserMapper.updateByPrimaryKey(muser);
	}

	@Override
	public int delete(String id) {
	
		return muserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public MUser selectByPrimaryKey(String id) {
		
		return muserMapper.selectByPrimaryKey(id);
	}

}
