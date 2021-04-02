package com.sunny.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sunny.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	@Inject
	private SqlSession sql;
	
	//memberMapper
	private static String namespace = "com.sunny.mappers.memberMapper";
	
	//ȸ������
	@Override
	public void signUp(MemberVO vo) throws Exception {
		System.out.println("========================================");
		System.out.println("MemberDAOImpl:: signUp");
		
		sql.insert(namespace + ".signUp", vo);
	}
	
	//�α���
	@Override
	public MemberVO logIn(MemberVO vo) throws Exception {
		System.out.println("========================================");
		System.out.println("MemberDAOImpl:: logIn");
		
		return sql.selectOne(namespace + ".logIn", vo);
	}
	
	//���̵� ���翩�� Ȯ��
	@Override
	public String logInExistID(String userID) throws Exception {
		System.out.println("========================================");
		System.out.println("MemberDAOImpl:: logInExistID");
		
		sql.selectOne(namespace + ".logInExistID", userID);
		System.out.println("logInExistID:: " + sql.selectOne(namespace + ".logInExistID", userID));
		   
	    return sql.selectOne(namespace +".logInExistID", userID); 
	       
	}

}
