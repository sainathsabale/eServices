package com.automation.eservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.automation.eservices.model.ACSOrderAppl;
import com.automation.eservices.repository.dto.FiveColumnDto;
import com.automation.eservices.repository.dto.ThreeColumnDto;

public interface ACSOrderApplRepository extends JpaRepository<ACSOrderAppl, Long> {
	
	/*@Query("SELECT new com.jeejava.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
			+ "FROM Department d INNER JOIN d.employees e")*/
	
	
	
	
	@Query("SELECT new com.automation.eservices.repository.dto.ThreeColumnDto(func AS busn_func, data_val, COUNT (acs_order_data.acs_order_appl_id) req_count) "
			+ " FROM enterprise_user_repository_own.acs_order_appl "
			+ "  INNER JOIN enterprise_user_repository_own.acs_order_data ON (acs_order_appl.acs_order_appl_id =  acs_order_data.acs_order_appl_id) "
			+ " INNER JOIN enterprise_user_repository_own.mcc_order ON (mcc_order.mcc_order_id = acs_order_appl.mcc_order_id) "
	        + " INNER JOIN enterprise_user_repository_own.wrkflw_rule ON (wrkflw_rule.wrkflw_rule_id = acs_order_data.wrkflw_rule_id) "
	        + " INNER JOIN enterprise_user_repository_own.wrkflw_step ON (wrkflw_step.wrkflw_step_id = wrkflw_rule.wrkflw_step_id) "
	        + " WHERE appl_nam = 'esrvmcbs' AND itemstate = 'IN_QUEUE' "
	        + " AND func IN ('ab505010aa', 'af760010aa', 'af760010bb', 'af760010cc', 'af760010dd',"
	        + "  'af761010aa', 'af761010cc', 'af761010dd', 'af762010aa', 'af762010bb', 'af762010cc', "
	        + "  'af762010dd', 'am700010aa', 'am700010bb', 'am700010dd','am700010ee', 'am710010aa', 'bu510010aa', " 
	        + "  'bu520010aa', 'bu530010aa', 'bu540010aa', 'bu570010aa', 'si417010a', 'si417010b', 'si417010c', "
	        + "  'si417010d', 'si441010a', 'si458010aa', 'si737010aa', 'si738010aa', 'tm100010aa', "
	        + "  'tm100010bb', 'tm110010aa', 'tm120010aa', 'tm130010aa', 'tm140010aa', 'tm150010aa', 'wb120-m', "
	        + "  'wb210', 'WB500-m', 'AM700010-CC', 'AM730010-BB', 'SI737010-BB', 'SI735010-BB', 'SI417010-A', 'SI417010-B', "
	        + "  'SI417010-C', 'SI417010-D', 'AM700010-AA', 'AM700010-BB', 'AM700010-DD', 'AM700010-EE', 'AM710010-AA', 'WB210', "
	        + "  'WB120-M', 'WB500-M', 'AF761010-AA', 'AF762010-BB', 'AF761010-CC', 'AF762010-AA', 'AF762010-DD', "
	        + "  'AF762010-CC', 'AF760010-BB', 'AF760010-CC','AF760010-DD', 'AF760010-AA', 'AM700010-GG', 'AM730010-CC') "
	        + "   AND nam IN ('FUNCTION_OWNER', 'USER_OWNER', 'DATA_OWNER') "
	        + "   AND data_val IS NOT NULL "
	        + "   GROUP BY func, data_val "
	        + "   ORDER BY busn_func")
	List<ThreeColumnDto> fetchAllThreeColumns();
	
	
	@Query("SELECT new com.automation.eservices.repository.dto.FiveColumnDto(func AS busn_func, data_val, acs_order_data.order_data_id AS itim_rqst_id, acs_order_data.crte_dt AS crte_dttm,  mcc_order.mcc_order_id) "
			+" FROM enterprise_user_repository_own.acs_order_appl"  
			+" INNER JOIN  enterprise_user_repository_own.acs_order_data  ON (acs_order_appl.acs_order_appl_id = acs_order_data.acs_order_appl_id)\r\n"  
			+" INNER JOIN enterprise_user_repository_own.mcc_order  ON (mcc_order.mcc_order_id = acs_order_appl.mcc_order_id)"
			+" INNER JOIN enterprise_user_repository_own.wrkflw_rule ON (wrkflw_rule.wrkflw_rule_id = acs_order_data.wrkflw_rule_id)" 
			+" INNER JOIN enterprise_user_repository_own.wrkflw_step ON (wrkflw_step.wrkflw_step_id = wrkflw_rule.wrkflw_step_id) " 
			+" WHERE appl_nam = 'esrvmcbs' AND itemstate = 'IN_QUEUE' AND func IN"  
			+" ('ab505010aa',"  
			+"                 'af760010aa',\r\n"  
			+"                 'af760010bb',\r\n"  
			+"                 'af760010cc',\r\n"  
			+"                 'af760010dd',\r\n"  
			+"                 'af761010aa',\r\n"  
			+"                 'af761010cc',\r\n"  
			+"                 'af761010dd',\r\n"  
			+"                 'af762010aa',\r\n"  
			+"                 'af762010bb',\r\n"  
			+"                 'af762010cc',\r\n"  
			+"                 'af762010dd',\r\n"  
			+"                 'am700010aa',\r\n"  
			+"                 'am700010bb',\r\n"  
			+"                 'am700010dd',\r\n"  
			+"                 'am700010ee',\r\n"  
			+"                 'am710010aa',\r\n"  
			+"                 'bu510010aa',\r\n"  
			+"                 'bu520010aa',\r\n"  
			+"                 'bu530010aa',\r\n"  
			+"                 'bu540010aa',\r\n"  
			+"                 'bu570010aa',\r\n"  
			+"                 'si417010a',\r\n" 
			+"                 'si417010b',\r\n"  
			+"                 'si417010c',\r\n"  
			+"                 'si417010d',\r\n"  
			+"                 'si441010a',\r\n"  
			+"                 'si458010aa',\r\n" 
			+"                 'si737010aa',\r\n"  
			+"                 'si738010aa',\r\n"  
			+"                 'tm100010aa',\r\n"  
			+"                 'tm100010bb',\r\n"  
			+"                 'tm110010aa',\r\n"  
			+"                 'tm120010aa',\r\n"  
			+"                 'tm130010aa',\r\n"  
			+"                 'tm140010aa',\r\n"  
			+"                 'tm150010aa',\r\n"  
			+"                 'wb120-m',\r\n"  
			+"                 'wb210',\r\n"  
			+"                 'WB500-m',\r\n"  
			+"                 'AM700010-CC',\r\n"  
			+"                 'AM730010-BB',\r\n"  
			+"                 'SI737010-BB',\r\n"  
			+"                 'SI735010-BB',\r\n"  
			+"                 'SI417010-A',\r\n"  
			+"                 'SI417010-B',\r\n"  
			+"                 'SI417010-C',\r\n"  
			+"                 'SI417010-D',\r\n"  
			+"                 'AM700010-AA',\r\n" 
			+"                 'AM700010-BB',\r\n"  
			+"                 'AM700010-DD',\r\n"  
			+"                 'AM700010-EE',\r\n"  
			+"                 'AM710010-AA',\r\n"  
			+"                 'WB210',\r\n"  
			+"                 'WB120-M',\r\n"  
			+"                 'WB500-M',\r\n"  
			+"                 'AF761010-AA',\r\n"  
			+"                 'AF762010-BB',\r\n"  
			+"                 'AF761010-CC',\r\n"  
			+"                 'AF762010-AA',\r\n"  
			+"                 'AF761010-DD',\r\n"  
			+"                 'AF762010-DD',\r\n"  
			+"                 'AF762010-CC',\r\n"  
			+"                 'AF760010-BB',\r\n"  
			+"                 'AF760010-CC',\r\n"  
			+"                 'AF760010-DD',\r\n"  
			+"                 'AF760010-AA',\r\n"  
			+"                 'AM700010-GG',\r\n"  
			+"                 'AM730010-CC')\r\n"  
			+"         AND nam IN ('FUNCTION_OWNER', 'USER_OWNER', 'DATA_OWNER')\r\n"  
			+"         AND data_val IS NOT NULL\r\n"  
			+"    ORDER BY crte_dttm, busn_func, data_val")
	List<FiveColumnDto> fetchAllFiveColumns();
}
