package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeListDto;
import com.example.demo.entity.EmployeeMst;
import com.example.demo.entity.PjMgmtTbl;
import com.example.demo.entity.PjMst;
import com.example.demo.repository.EmployeeMstMapper;
import com.example.demo.repository.PjMgmtTblMapper;
import com.example.demo.repository.PjMstMapper;
import com.example.demo.utils.Util;

@Service
public class EmployeeListService {

	@Autowired
	private EmployeeMstMapper employeeMstMapper;
	@Autowired
	private PjMstMapper pjMstMapper;
	@Autowired
	private PjMgmtTblMapper pjMgmtTblMapper;
	@Autowired
	private Util util;
	
	
	
	/**
	 * 社員リスト生成
	 * @return
	 */
	public List<EmployeeListDto> listJoin() {

		// ﾃｰﾌﾞﾙから値を取得
		List<EmployeeMst> employeeMstList = employeeMstMapper.selectAll();
		List<PjMst> pjMstList = pjMstMapper.selectAll();
		List<PjMgmtTbl> pjMgmtTblList = pjMgmtTblMapper.selectAll();

		// 結合結果格納用
		List<EmployeeListDto> employeeList =  new ArrayList<>();
		

		// 社員マスターの社員ID、案件管理ﾃｰﾌﾞﾙの社員IDをもとにテーブル結合を行う。
		for(EmployeeMst e : employeeMstList) {
			for(PjMgmtTbl pm : pjMgmtTblList) {
				if(e.getEmployeeId().equals(pm.getEmployeeId())) {
					// 案件管理ﾃｰﾌﾞﾙの案件IDと案件ﾏｽﾀｰの案件IDを結合
					for(PjMst p : pjMstList) {
						if(pm.getPjId().equals(p.getPjId())) {

							EmployeeListDto employeeListDto = new EmployeeListDto();
							employeeListDto.setEmployeeId(e.getEmployeeId());
							employeeListDto.setEmployeeName(e.getEmployeeName());
							employeeListDto.setAge(util.calculateAge(e.getBirthday()));
							employeeListDto.setPjName(p.getPjName());
							employeeListDto.setPjStartDate(p.getPjStartDate());

							employeeList.add(employeeListDto);
						}
					}
				}

			}

		}
		return employeeList;
	}


	
}
