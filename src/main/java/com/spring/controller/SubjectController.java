package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.subjectservice.SubjectService;
import com.spring.subjectvo.SubjectVO;

@Controller
@RequestMapping(value="/subject")
public class SubjectController {
	private static final String CONTEXT_PATH = "subject";	//view의 하위 폴더명
	
	@Autowired
	private SubjectService subjectService;
	

	//학과 전체 조회
	@RequestMapping("/listSubject")
	public ModelAndView listSubject(@ModelAttribute SubjectVO param) {
		
		List<SubjectVO> list = subjectService.listSubject(param);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("subjectList",list);	//jsp파일에 필요한("객체명",데이터)
		mav.setViewName(CONTEXT_PATH  + "/subject");	//CONTEXT_PATH 폴더의 JSP파일명
		return mav;
	}
	
	//학과 추가
	@RequestMapping("/insertSubject")
	public ModelAndView insertSubject(@ModelAttribute SubjectVO param) {
		String resultStr="";
		int result=subjectService.insertSubject(param);
		
		if(result>0) {
			resultStr="학과 등록이 완료되었습니다.";
		}else {
			resultStr="학과 등록에 문제가 있어 완료하지 못하였습니다.";
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", resultStr);
		mav.setViewName("/result");
		
		return mav;
	}
}
