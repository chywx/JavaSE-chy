package com.test;

import com.alibaba.fastjson.JSONObject;
import com.util.ConnectUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Statistics {
	public static void main(String[] args) throws SQLException {
		Connection connect = ConnectUtil.getConnect();
		System.out.println(connect);
		PreparedStatement statement = connect.prepareStatement("select count(*) amount,f_tablesecrecy secrecy from w_sec_dec_itemapply where to_char(f_itemdate,'yyyy') = ? group by f_tablesecrecy");
		statement.setString(1, "2017");
		ResultSet executeQuery = statement.executeQuery();
		while(executeQuery.next()) {
			int amount = executeQuery.getInt("amount");
			String secrecy = executeQuery.getString("secrecy");
			System.out.println("数量是："+amount+"---密级是："+secrecy);
		}
	}

	@Test
	public void test1(){
		String string = "{\"evaluateTags\":\"解析不正确\",\"evaluateContent\":\"\",\"apkVersionName\":\"3.6.52\",\"questionId\":1110153,\"apkName\":\"助理医师考试星题库\",\"phoneNumber\":\"18707809979\"}18707809979";
		String tagStart = "evaluateTags\":";
		String tagEnd = "evaluateContent";
		System.out.println(string.indexOf(tagStart));
        System.out.println(string.substring(tagStart.length()+3,string.indexOf(tagEnd)-3));


		String string2 = "{\"apkVersionName\":\"3.9.37\",\"evaluateContent\":\"解析不完整\",\"evaluateTags\":\"其他错误,图片不存在\",\"phoneNumber\":\"15978977159\",\"questionId\":1120073}15978977159\t";

		System.out.println(string2.indexOf(tagStart));
		System.out.println(string2.indexOf(tagEnd));
		// System.out.println(string2.substring(string2.indexOf(tagStart)+2,string2.indexOf(tagEnd)));


		String json = string.substring(0, string.indexOf("}") + 1);
		System.out.println(json);
		//JSONObject object = JSONObject.fromObject(json);
		AdviceJson adviceJson = JSONObject.parseObject(json, AdviceJson.class);
		System.out.println(adviceJson.getEvaluateTags());

//		Object evaluateTags = object.get("evaluateTags");
//		System.out.println(evaluateTags);

		System.out.println(string.startsWith("{"));
		System.out.println(string2.startsWith("{"));
		System.out.println(string.lastIndexOf("33}"));
		System.out.println(string2.lastIndexOf("}"));

		System.out.println(string.substring(0,string.lastIndexOf("}")+1));

	}

}

class AdviceJson{
	private String evaluateContent;
	private String evaluateTags;

	public String getEvaluateContent() {
		return evaluateContent;
	}

	public void setEvaluateContent(String evaluateContent) {
		this.evaluateContent = evaluateContent;
	}

	public String getEvaluateTags() {
		return evaluateTags;
	}

	public void setEvaluateTags(String evaluateTags) {
		this.evaluateTags = evaluateTags;
	}
}