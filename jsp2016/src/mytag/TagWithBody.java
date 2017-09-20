package mytag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;


public class TagWithBody extends BodyTagSupport{

	int counts;//counts位迭代的次数

	public  TagWithBody(){
		super();
	}
	//设置counts属性，这个方法有容器自动调用
	public void setCounts(int c) {
		this.counts = c;
	}
	//覆盖doStartTag方法
	@Override
	public int doStartTag() throws JspException {
		System.out.println("doStartTag");
		if(counts>0){
			return EVAL_BODY_TAG;
		}else{
			return SKIP_BODY;
		}
	}
	//覆盖doAfterBody方法
	@Override
	public int doAfterBody() throws JspException {
		System.out.println("doAfterBody");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(counts>1){
			counts--;
			return EVAL_BODY_TAG;
		}else{
			return SKIP_BODY;
		}
		
	}
	//覆盖doEndTag方法
	@Override
	public int doEndTag() throws JspException {
		System.out.println("doEndTag");
		try{
			if(bodyContent!=null){
				bodyContent.writeOut(bodyContent.getEnclosingWriter());
			}
		}catch(java.io.IOException e){
			throw new JspTagException("io Error："+e.getMessage());
		}
		return EVAL_PAGE;
	}
	@Override
	public void doInitBody() throws JspException {
		System.out.println("doInitBody");
	}
	@Override
	public void setBodyContent(BodyContent bodyContent) {
		System.out.println("setBodyContext");
		this.bodyContent = bodyContent;
	}
}
