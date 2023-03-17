package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.EmployeeMst;
import com.example.demo.repository.EmployeeListMapper;
/**
 * ユーザー情報 Controller
 */
@Controller
public class EmployeeDisplayController {

	@Autowired
	EmployeeListMapper employeeListMapper;

	/**
	 * 社員一覧画面を表示
	 * @param model Model
	 * @return 社員情報一覧画面
	 */
	//user/searchにアクセスすると処理が実行される
	@GetMapping(value = "/employee") 
	// モデルクラスはコントローラーからビューに変数を渡す
	public String display(Model model) {
		
		List<EmployeeMst> list = employeeListMapper.selectAll();
		// search.htmlにuserSearchRequestという変数名で、UserSerchRequestクラスを渡す  
		model.addAttribute("employeeList", list);
		// 変数を渡すhtmlの指定
		return "employee";
	}
}