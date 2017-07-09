package ws.com.chinaedu.hel.constants;

public interface IDocWebsConstants {
	public final static String Message_Header_businessRespCode_00 = "00";//报文头中的返回业务编码 00代表成功
	public final static String Message_Header_businessRespCode_01 = "01";//01代表异常
	public final static String Message_Header_businessRespCode_02 = "02";//02代表没有查询到数据
	
	public final static String Log_Exec_Status_Success = "1";
	public final static String Log_Exec_Status_Failed = "2";

	public final static String defaultUserWebs = "admin";
	public final static Long defaultUserId0l = null;
	public final static String states = "13";
	
//	激活卡单状态	ACTIVATE_CARD_POL_STATUS	01	未激活 
//	激活卡单状态	ACTIVATE_CARD_POL_STATUS	02	已激活 
//	激活卡单状态	ACTIVATE_CARD_POL_STATUS	03	无效
	
	public final static String polstatus_new = "01";
	public final static String polstatus_used = "02";
	public final static String polstatus_invalid = "03";

	
	public final static int selfGiveUpTime = 30000;
	
	public final static String webs_error_str_001 = "服务端无法按xsd解析传入报文";
	public final static String webs_error_str_002 = "服务端内部异常";
	public final static String webs_error_str_003 = "单行记录返回多条";
	public final static String webs_error_str_004 = "不支持该类型的业务";
	public final static String webs_error_str_005 = "单证处于冻结状态，不可回销";
	public final static String webs_error_str_006 = "不存在单证";
	public final static String webs_error_str_007 = "单证状态不符合回销条件";
	public final static String webs_error_str_008 = "单证处于锁定状态不可回销";
	public final static String webs_error_str_009 = "单证系统内部数据错误";

	//中介批量回销更新
	public final static String webs_error_str_010 = "单证已处于锁定状态，不能再次锁定";
	public final static String webs_error_str_011 = "单证不是未用状态，无法更新";
	//校验激活卡密码服务
	public final static String webs_error_str_012 = "单证系统不存在此单证";
	public final static String webs_error_str_013 = "卡单密码不正确";
	public final static String webs_error_str_014 = "单证不是回销状态，不可回销回退";
	public final static String webs_error_str_015 = "已经是作废回销，不可再次作废回销";


	//客户经理入库锁定类型
	public final static String webs_lock_type = "04";
	//中介单证回退（空白回销）前置条件
	public final static String doc_status = "03";
	//中介单证回退（空白回销）后单证状态
	public final static String state = "01";
	//空白回销状态
	public final static String fall_back_type = "04";
	
	//命名空间 前半部分
    public final static String tns_header = "http://ws.xxxxxxlife.cn/Doc";
	
    // 命名空间 后半部分 http://ws.xxxxxxxlife.cn/Doc/服务名/版本号/
	public final static String tns_BatDocInfo = tns_header + "/BatDocInfo";
	public final static String tns_BatUpdateDocInfo = tns_header + "/BatUpdateDocInfo";
	public final static String tns_CheckCardPw = tns_header + "/CheckCardPw";
	public final static String tns_DocInfo = tns_header + "/DocInfo";
	public final static String tns_DocUserInfo = tns_header + "/DocUserInfo";
	public final static String tns_UpdateDocInfo = tns_header + "/UpdateDocInfo";
	public final static String tns_DocFallBack = tns_header + "/DocFallBack";
	public final static String tns_DocSegmentInfo = tns_header + "/DocSegmentInfo";

	//businessId的id
	public final static String websBusinessId_docservice_batdocinfo = "docservice_batdocinfo";
	public final static String websBusinessId_docservice_batupdatedocinfo = "docservice_batupdatedocinfo";
	public final static String websBusinessId_docservice_checkcardpw = "docservice_checkcardpw";
	public final static String websBusinessId_docservice_docinfo = "docservice_docinfo";
	public final static String websBusinessId_docservice_docuserinfo = "docservice_docuserinfo";
	public final static String websBusinessId_docservice_updatedocinfo = "docservice_updatedocinfo";
	public final static String websBusinessId_docservice_docfallback = "docservice_docfallback";
	public final static String websbusinessid_docservice_docsegmentinfo = "docservice_docsegmentinfo";

	public final static String websType_message = "message";
	
	public final static String DOC_RU_KU = "1";
	public final static String DOC_CHU_KU = "2";
	public final static String DOC_HUI_XIAO = "3";

	public final static String MESVER_V1 = "V1";//报文版本代码=(中介)
	public final static String MESVER_V2 = "V2";//报文版本代码=(新版)


	
}
