
// Search Engine Demo for DHGate.com 
// Author: Shen Jiyi  shenjiyi@dhgate.com
// 2015.1.19

package com.dh.domain;

import java.util.List;

public class Piclight {
	private String status;
	private List<PicItem> content;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<PicItem> getContent() {
		return content;
	}
	public void setContent(List<PicItem> content) {
		this.content = content;
	}
}
