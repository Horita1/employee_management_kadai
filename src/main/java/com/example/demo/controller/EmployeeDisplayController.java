package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeListDto;
import com.example.demo.service.EmployeeListService;
/**
 * ユーザー情報 Controller
 */
@Controller
public class EmployeeDisplayController {


	@Autowired
	EmployeeListService employeeListService;

	/**
	 * 社員一覧画面を表示
	 * @param model Model
	 * @return 社員情報一覧画面
	 */
	@GetMapping(value = "/employee") 
	public String display(Model model) {

		// 社員一覧を取得
		List<EmployeeListDto> employeeList = employeeListService.listJoin();

		// employee.htmlにemployeeListという変数名で、UserSerchRequestクラスを渡す  
		model.addAttribute("employeeList", employeeList);
		// 変数を渡すhtmlの指定
		return "employee";
	}

	

	
}
