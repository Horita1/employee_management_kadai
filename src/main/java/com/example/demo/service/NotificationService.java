package com.example.demo.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PjMst;
import com.example.demo.repository.PjMstMapper;

@Service
public class NotificationService {

	@Autowired
	private PjMstMapper pjMstMapper;

	/**
	 * 通知リスト生成
	 * @return
	 */
	public List<PjMst> NotificationTargetCreate() {

		// ﾃｰﾌﾞﾙから値を取得
		List<PjMst> pjMstList = pjMstMapper.selectAll();

		// 通知用のlist
		List<PjMst> notificationList =  new ArrayList<>();


		// 通知対象案件の取得
		for(PjMst p : pjMstList) {
			if(getNotificationTarget(p.getPjEndDate())) {
				notificationList.add(p);
			}
		}

		return notificationList;
	}

	/**
	 * 交通費申請日の計算
	 * @return
	 */
	public boolean getNotificationTarget(LocalDate pjEndDate) {
		LocalDate currentDate = LocalDate.now();
		Period period = Period.between(currentDate , pjEndDate);
		int years = period.getYears();
		int months = period.getMonths();
		int day = period.getDays();

		if(years == 0 && months == 0 && day >= 0 && day <= 14) {
			return true ;
		}else {
			return false;
		}

	}

}
