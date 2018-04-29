package com.zhc.core.action;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 1940339106238511988L;
	
	public String forwardView;

	public String getForwardView() {
		return forwardView;
	}

	public void setForwardView(String forwardView) {
		this.forwardView = forwardView;
	}
	
}
