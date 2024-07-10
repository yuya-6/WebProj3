package com.diworksdev.webproj3.action;

import com.diworksdev.webproj3.dao.HelloStrutsDAO;
import com.diworksdev.webproj3.dto.HelloStrutsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HelloStrutsAction extends ActionSupport {
	private String result;

	public String execute() {
		String ret=ERROR;
		HelloStrutsDAO dao=new HelloStrutsDAO();
		HelloStrutsDTO dto=new HelloStrutsDTO();
		dto=dao.select();
		System.out.println(dto.getResult());

		result=dto.getResult();
		if(result.equals("MySQL と接続できます。")){
			ret=SUCCESS;
		}else{
			ret=ERROR;
		}
		return ret;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result=result;
	 }
}
