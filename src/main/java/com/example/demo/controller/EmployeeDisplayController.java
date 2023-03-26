package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.EmployeeDetailDto;
import com.example.demo.dto.EmployeeListDto;
import com.example.demo.entity.PjMst;
import com.example.demo.service.EmployeeDetailService;
import com.example.demo.service.EmployeeListService;
import com.example.demo.service.NotificationService;
/**
 * ユーザー情報 Controller
 */
@RestController
public class EmployeeDisplayController {


	@Autowired
	EmployeeListService employeeListService;
	@Autowired
	EmployeeDetailService employeeDetailService; 
	@Autowired
	NotificationService notificationService;

	/**
	 * 社員一覧画面を表示
	 * @param model Model
	 * @return 社員情報一覧画面
	 */
	@GetMapping(value = "/employee") 
	public ModelAndView display(Model model) {
		// 社員一覧を取得
		List<EmployeeListDto> employeeList = employeeListService.listJoin();
		// 通知対象を取得
		List<PjMst> notificationList = notificationService.NotificationTargetCreate();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("employee");
		mav.addObject("employeeList", employeeList);
		mav.addObject("notificationList", notificationList);
		return mav;

	}

    @GetMapping("/employeeDetail/{id}")
    public EmployeeDetailDto showEmployeeDetails(@PathVariable String id, Model model) {
        // idに対応する社員の詳細を取得し、JSONで返却
        return employeeDetailService.getEmployeeDetailsById(id);
    }

}
