package com.virtusa.eems.Exceptions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

@ControllerAdvice
public class GlobalExceptionHandler {

	static Logger log = Logger.getLogger(GlobalExceptionHandler.class);
	
	 @ExceptionHandler(ResourceNotFoundException.class)
	     public String handleResourceNotFoundException(HttpServletRequest req,
	 			ResourceNotFoundException ex) {
	         return "notfound";
	     }

	
	 @ExceptionHandler(NullPointerException.class)
		public ModelAndView conflictNullPointer(HttpServletRequest req,
				NullPointerException ex) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("classtype", ex.getClass().toString());
			//mav.addObject("cause", ex.getCause().toString());
			mav.addObject("exception", ex);
			mav.addObject("url", req.getRequestURL());
			mav.setViewName("Error");
			ex.printStackTrace();
			return mav;

		}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ModelAndView conflict(HttpServletRequest req,
			DataIntegrityViolationException ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("classtype", ex.getClass().toString());
		//mav.addObject("cause", ex.getCause().toString());
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("Error");
		ex.printStackTrace();
		return mav;

	}
	
	@ExceptionHandler(HibernateException.class)
	public ModelAndView conflictHibernate(HttpServletRequest req,
			HibernateException ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("classtype", ex.getClass().toString());
/*		mav.addObject("cause", ex.getCause().toString());*/
		mav.addObject("exception", ex.getClass().getSimpleName());
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("Error");
		ex.printStackTrace();
		return mav;

	}
	

	@ExceptionHandler(NoSuchRequestHandlingMethodException.class)
	public ModelAndView resource(HttpServletRequest req,
			NoSuchRequestHandlingMethodException ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("classtype", ex.getClass().toString());
		//mav.addObject("cause", ex.getCause().toString());
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("Error");
		ex.printStackTrace();
		return mav;

	}

	@ExceptionHandler(SQLException.class)
	public ModelAndView databaseError(HttpServletRequest req, SQLException ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("classtype", ex.getClass().toString());
		//mav.addObject("cause", ex.getCause().toString());
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("Error");
		ex.printStackTrace();
		return mav;

	}

	@ExceptionHandler(DataAccessException.class)
	public ModelAndView databaseError1(HttpServletRequest req,
			DataAccessException ex) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("classtype", ex.getClass().toString());
		//mav.addObject("cause", ex.getCause().toString());
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("Error");
		ex.printStackTrace();
		return mav;

	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception exception) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("classtype", exception.getClass().toString());
		//mav.addObject("cause", exception.getCause().toString());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("Error");
		exception.printStackTrace();
		return mav;
	}
	
	@ExceptionHandler(Throwable.class)
	  public ModelAndView handleAnyException(Throwable ex, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("classtype", ex.getClass().toString());
		//mav.addObject("cause", exception.getCause().toString());
		mav.addObject("exception", ex);
		mav.addObject("url", request.getRequestURL());
		mav.setViewName("Error");
		ex.printStackTrace();
		return mav;
	  }

}
