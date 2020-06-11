package com.board.util;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;

public class AuthorizeTagTEI extends TagExtraInfo{

	@Override
	public boolean isValid(TagData data) {	// 태그가 실행 될 때마다 호출되는 메소드
		String attr = data.getAttributeString("");	// 태그에서 선언한 attribute 속성값 가젹오기.
		if(attr == null) {	//attr 값에 따라 return 값 지정
			
		}
		return super.isValid(data);
	}
}
