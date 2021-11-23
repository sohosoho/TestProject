package com.spring.subjectdao;

import java.util.List;

import com.spring.subjectvo.SubjectVO;

public interface SubjectMapper {
	public List<SubjectVO> listSubject(SubjectVO param);

	public int insertSubject(SubjectVO param);
}
