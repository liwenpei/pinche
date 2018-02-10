package com.gionee.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.gionee.common.multidataSource.DataSourceContextHolder;
import com.gionee.common.multidataSource.DataSourceInstances;

@Aspect
@Component
public class DataSourceAspect {
/*
	@Around("execution(* com.gionee.merchant.controller.*.*(..))")
	public Object doAround(ProceedingJoinPoint jp) throws Throwable {
		if (jp.getTarget() instanceof MyAuthorizingRealm) {
			DataSourceContextHolder.setDataSourceType(DataSourceInstances.DS_USER);
		} else if (jp.getTarget() instanceof MerchantCouponDeliveryController) {
			DataSourceContextHolder.setDataSourceType(DataSourceInstances.DS_USER);
		} else if (jp.getTarget() instanceof PayTradeController
				|| jp.getTarget() instanceof PayCouponController || jp.getTarget() instanceof ExpController) {
			DataSourceContextHolder.setDataSourceType(DataSourceInstances.DS_PAY);
		} else {
			DataSourceContextHolder.setDataSourceType(DataSourceInstances.DS_USER);
		}
		return jp.proceed();
	}*/
}
