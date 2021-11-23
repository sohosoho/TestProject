package com.spring.subjectservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.subjectdao.SubjectMapper;
import com.spring.subjectvo.SubjectVO;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService{
	
	private SubjectMapper subjectMapper;
	
	@Override
	public List<SubjectVO> listSubject(SubjectVO param) {
		List<SubjectVO>list = new ArrayList<SubjectVO>();
		list=subjectMapper.listSubject(param);
		return list;
	}

	@Override
	public int insertSubject(SubjectVO param) {
		return subjectMapper.insertSubject(param);
	}
	
}
