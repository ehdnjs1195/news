package com.board.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.board.dao.UsersDAO;
import com.board.vo.UsersVO;

public class AuthorizeTag extends TagSupport{

    private static final long serialVersionUID = 1L;
    private final String SEPARATE =",";

    private String authority; // U001, U002
    private String id;
    private String writer;
    private UsersDAO dao = UsersDAO.getInstance();
   
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}


	
	@Override
    public int doAfterBody() throws JspException {	//바디
    	if(doEndTag() == SKIP_PAGE) {
    		return EVAL_BODY_INCLUDE;    		
    	}
    	return SKIP_BODY;
    }
	
	@Override
	public int doEndTag() throws JspException {	//끝 태그
		UsersVO userInfo = dao.getBoardWriter(id);	// 
		
		if(userInfo.getUser_id() != null) {	//로그인 되어있는 경우
			if(authority.contains(userInfo.getUser_authority_code())) {
				if(writer != null) {	//글 수정/삭제 페이지에서 입력되는 값.
					if(id.equals(writer)) {	// 사용자와 작성자가 같은 경우
						return EVAL_PAGE;	// 권한 OK, 작성자=사용자 OK	=>페이지 OK
					}else {	//다른경우
						return SKIP_PAGE;	// 권한 OK, 작성자!=사용자 XX =>페이지 NO
					}
				}else {
					return EVAL_PAGE; 	// 권한은 OK, 작성자 없음 => 페이지 OK (글 수정,삭제 페이지가 아니므로)
				}
			}else {	//권한 XX
				return SKIP_PAGE;	// 권한 XX => 페이지 NO
			}
		}else {	
			return SKIP_PAGE; // 로그인 X => 페이지 NO
		}
	}
}
