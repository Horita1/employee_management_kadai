package com.example.demo.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDetailDto;
import com.example.demo.dto.EmployeeListDto;
import com.example.demo.entity.EmployeeMst;
import com.example.demo.entity.PaidHolMgmtTbl;
import com.example.demo.entity.PjMgmtTbl;
import com.example.demo.entity.PjMst;
import com.example.demo.entity.PositionMst;
import com.example.demo.entity.SalaryMgmtTbl;
import com.example.demo.entity.SalaryMst;
import com.example.demo.repository.EmployeeMstMapper;
import com.example.demo.repository.PaidHolMgmtTblMapper;
import com.example.demo.repository.PjMgmtTblMapper;
import com.example.demo.repository.PjMstMapper;
import com.example.demo.repository.PositionMstMapper;
import com.example.demo.repository.SalaryMgmtTblMapper;
import com.example.demo.repository.SalaryMstMapper;
import com.example.demo.utils.Util;

@Service
public class EmployeeDetailService {

	@Autowired
	private EmployeeMstMapper employeeMstMapper;
	@Autowired
	private PjMstMapper pjMstMapper;
	@Autowired
	private PjMgmtTblMapper pjMgmtTblMapper;
	@Autowired
	private PaidHolMgmtTblMapper paidHolMgmtTblMapper;
	@Autowired
	private PositionMstMapper positionMstMapper;
	@Autowired
	private SalaryMgmtTblMapper salaryMgmtTblMapper;
	@Autowired
	private SalaryMstMapper salaryMstMapper;
	@Autowired
	private Util util;
	
	
	
	/**
	 * 社員詳細情報生成
	 * @return
	 */
	public EmployeeDetailDto getEmployeeDetailsById(String id) {

		// ﾃｰﾌﾞﾙから値を取得
		List<EmployeeMst> employeeMstList = employeeMstMapper.selectAll();
		List<PjMst> pjMstList = pjMstMapper.selectAll();
		List<PjMgmtTbl> pjMgmtTblList = pjMgmtTblMapper.selectAll();
		List<PaidHolMgmtTbl> paidHolMgmtTblList = paidHolMgmtTblMapper.selectAll();
		List<PositionMst> positionMstList = positionMstMapper.selectAll();
		List<SalaryMgmtTbl> salaryMgmtTblList = salaryMgmtTblMapper.selectAll();
		List<SalaryMst> salaryMstList = salaryMstMapper.selectAll();


		// 結果格納用
		EmployeeDetailDto employeeDetailDto =new EmployeeDetailDto();
		// 役職ID格納用
		String positionId = "";
		// 案件ﾒﾝﾊﾞｰ取得する際の案件ID格納用
		String pjId = "";
		// メンバーの社員ID取得用
		List<String> memberIdList = new ArrayList<>();
		// メンバー格納用
		String member = "";
		

		// 社員マスターの社員IDをキーに値を取得
		for(EmployeeMst e : employeeMstList) {
			if(e.getEmployeeId().equals(id)) {
				
				// 名前と年齢と社歴の取得
				employeeDetailDto.setEmployeeName(e.getEmployeeName());
				employeeDetailDto.setAge(util.calculateAge(e.getBirthday()));
				employeeDetailDto.setServiceYears(getYearsAndMonthsOfService(e.getStartDate()));
				employeeDetailDto.setClosestSt(e.getClosestSt());
				
				
				positionId = e.getPositionId();
			}
		}
				
		// 役職の取得
		for(PositionMst poMs : positionMstList) {
			if(positionId.equals(poMs.getPositionId())) {
				employeeDetailDto.setPosition(poMs.getPosition());
			}
		}
				
		// 給料の取得
		for(SalaryMgmtTbl saMg : salaryMgmtTblList) {
			if(saMg.getEmployeeId().equals(id)) {
				for(SalaryMst saMs : salaryMstList) {
					if(saMs.getSalaryId().equals(saMg.getSalaryId())) {
						employeeDetailDto.setSalary(saMs.getSalary());
					}
				}
			}
		}
					
		// 案件情報の取得
		for(PjMgmtTbl pjMg : pjMgmtTblList) {
			if(pjMg.getEmployeeId().equals(id)) {
				for(PjMst pjMs : pjMstList) {
					if(pjMs.getPjId().equals(pjMg.getPjId())) {

						employeeDetailDto.setPjName(pjMs.getPjName());
						employeeDetailDto.setPjPeriod(pjMs.getPjStartDate() + " - " + pjMs.getPjEndDate());

						pjId = pjMs.getPjId();
					}
				}
			}
		}


		// 案件ﾒﾝﾊﾞｰのID取得
		for(PjMgmtTbl pjMg : pjMgmtTblList) {
			if(pjMg.getPjId().equals(pjId)) {
				memberIdList.add(pjMg.getEmployeeId());
			}
		}

		// 案件ﾒﾝﾊﾞｰ名取得
		for(String memberId : memberIdList) {
			for(EmployeeMst e : employeeMstList) {
				if(memberId.equals(e.getEmployeeId())) {
					if(member.isEmpty()) {
						member = e.getEmployeeName();
					}else {
						member = member + "、" + e.getEmployeeName();
					}
				}
			}
		}
		employeeDetailDto.setPjMember(member);
		
		
		// 有給残日数を取得
		for(PaidHolMgmtTbl phMg : paidHolMgmtTblList) {
			if(phMg.getEmployeeId().equals(pjId)) {
				employeeDetailDto.setPaidBalance(phMg.getPaidHolsTotal() - phMg.getPaidHolsUsed());
			}
		}
		return employeeDetailDto;
	}
	

	
	/**
	 * 社歴計算
	 * @return
	 */
    public String getYearsAndMonthsOfService(LocalDate startDate) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(startDate, currentDate);
        int years = period.getYears();
        int months = period.getMonths();
        return years + "年" + months + "ヶ月";
    }
	
	
}
