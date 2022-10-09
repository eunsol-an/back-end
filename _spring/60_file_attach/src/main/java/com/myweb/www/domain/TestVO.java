package com.myweb.www.domain;

import lombok.Getter;
import lombok.Setter;

public class TestVO {
	@Getter @Setter
	private long tno;
	@Setter
	private String tname;
	@Getter
	private double tcode;
	private String content;
}
