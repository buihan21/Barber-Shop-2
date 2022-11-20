/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jspmodel.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jspmodel.mapper.UserMapper;
import com.jspmodel.models.User;
import com.jspmodel.service.IUserService;
import com.jspmodel.utils.HttpUtil;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/user"})
public class UserApi extends HttpServlet{
	@Inject
	private IUserService UserService;
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
    	ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        res.setContentType("aplication/json");
        HttpUtil.of(req.getReader());
        User user = HttpUtil.of(req.getReader()).toModel(User.class);
        user = UserService.save(user);       
        mapper.writeValue(res.getOutputStream(), user);
    }
    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
    	ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        res.setContentType("aplication/json");	
        User updateUser = HttpUtil.of(req.getReader()).toModel(User.class);
        updateUser = UserService.update(updateUser);
        mapper.writeValue(res.getOutputStream(), updateUser);
	}
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
    	ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        res.setContentType("aplication/json");	
        User User = HttpUtil.of(req.getReader()).toModel(User.class);   	
        UserService.delete(User.getId());
        mapper.writeValue(res.getOutputStream(), "{}");
    }
    
}
