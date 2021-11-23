package com.spring.subjectdao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.spring.subjectvo.SubjectVO;

@Repository
public class SubjectMapperImpl implements SubjectMapper{

	@Inject
	private Object sqlSession;
	
	
	private static final String namespace = "com.spring.subjectdao.SubjectMapper";

	@Override
	public List<SubjectVO> listSubject(SubjectVO param) {
		return sqlSession.selectList(namespace + ".listSubject",param);
	}

	@Override
	public int insertSubject(SubjectVO param) {
		return sqlSession.insert(namespace + ".insertSubject",param);
	}
	
	
}
