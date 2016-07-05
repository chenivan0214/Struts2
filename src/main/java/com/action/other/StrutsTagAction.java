package com.action.other;

import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.bean.other.TagBean;

public class StrutsTagAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    
    private List<TagBean> listTagBean = new ArrayList<TagBean>();
    
    //@Override
    //public String execute() throws Exception {
    //    return ActionSupport.SUCCESS;
    //}
    
    public List<TagBean> getListTagBean() {
        return this.listTagBean;
    }

    public String nonUi() {
        this.listTagBean.add(new TagBean("a"));
        this.listTagBean.add(new TagBean("b"));
        this.listTagBean.add(new TagBean("c"));
        
        Map sessionMap = ServletActionContext.getContext().getSession();
        TagBean tagBean = new TagBean();
        tagBean.setName("Adddbc");
        sessionMap.put("tagBean", tagBean);
        
        return "nonui_success";
    }
}
