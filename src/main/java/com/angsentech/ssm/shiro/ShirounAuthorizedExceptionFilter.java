package com.angsentech.ssm.shiro;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;
/**
 * <p>Shiro权限拦截器</p>
 * @ClassName: ShirounAuthorizedExceptionFilter 
 * @Description: TODO
 * @author sun 
 * @date 2016年7月19日 下午10:05:09
 */
@ControllerAdvice
public class ShirounAuthorizedExceptionFilter {

	/**
	 * <p>shiro权限不足拦截器</p>
	 *
	 * @param @param  request
	 * @param @param  e
	 * @param @return
	 * @return ModelAndView
	 * @throws
	 * @Title: processUnauthenticatedException
	 * @Description:
	 */
	@ExceptionHandler({UnauthorizedException.class})
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ModelAndView processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", e);
		mv.setViewName("/unauthorized");
		return mv;
	}
}