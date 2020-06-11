package com.board.util;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class AuthorizeTag extends BodyTagSupport{

    private static final long serialVersionUID = 1L;
    private final String SEPARATE =",";

    private String grades; // 콤마(,)로 구분되어 있다.
    private String writerId;

    @Override
    public int doAfterBody() throws JspException {
        UserGrade userGrade = null;
        try {
            userGrade = UserGrade.valueOf(LoginUser.getLoginUserGrade());
        } catch (Exception e) {
            return SKIP_BODY;
        }

        // 로그인한 계정만 가능한지 확인 (옵션) - null 이면 무시
        if (!StringUtil.isEmpty(writerId)) {
                        // 게시자의 아이디와 Login User의 Id 비교
            if (!Loginuser.getLoginId().equals(writerId)) {
                return SKIP_BODY; // jsp Body에 출력 안함
            }
        }

        // 메뉴 사용가능한 목록 추출
        List<String> availableGrades = Arrays.asList(grades.split(SEPARATE));
        if (availableGrades.contains(userGrade)) {
            print(); // jsp Body에 출력 , private method.
        }
    }
}
