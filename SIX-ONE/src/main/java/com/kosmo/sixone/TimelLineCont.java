package com.kosmo.sixone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TimelLineCont {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private ServletContext context;
	
	
	@RequestMapping(value = "/TimeLine.do", method = RequestMethod.GET)
	public String TimeLine(Locale locale, Model model, HttpServletRequest req) {
		
		
		DAO dao = new DAO(req.getSession().getServletContext());
		
		
		model.addAttribute("aaa", "resources/images/black.jpg");
		model.addAttribute("bbb", "resources/images/classes-1.jpg");
		String[] images = new String[10];
		images = dao.test();
		for(int i=0;i<10;i++)
			System.out.println(images[i]);
		
		req.setAttribute("images", images);
		System.out.println("기존2");
		
		///======================================
		
		

		
		
		
		return "/TimeLine.tiles";
	}
	
	@RequestMapping(value = "/exercise.do", method = RequestMethod.GET)
	public String exec(Locale locale, Model model) {
	
		
		
		return "/exercise.tiles";
	}

}
