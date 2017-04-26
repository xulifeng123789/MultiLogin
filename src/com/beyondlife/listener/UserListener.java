package com.beyondlife.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.beyondlife.vo.UList;
import com.beyondlife.vo.User;


public class UserListener implements ServletContextListener,
		HttpSessionListener,HttpSessionAttributeListener{

	ServletContext application = null;
	
	/** 
	 * 当Servlet 容器终止Web 应用时调用该方法。在调用该方法之前，容器会先销毁所有的Servlet 和Filter 过滤器。 
	 */ 
	public void contextDestroyed(ServletContextEvent event) {
		
		Map ulist = (Map)event.getServletContext().getAttribute("ulist");
		if(ulist != null){
			
			ulist.clear();
		}
	}

	/** 
	 * 当Servlet 容器启动Web 应用时调用该方法。在调用完该方法之后，容器再对Filter 初始化， 
	 * 并且对那些在Web 应用启动时就需要被初始化的Servlet 进行初始化。 
	 */  
	public void contextInitialized(ServletContextEvent event) {
		
		//��ʼ���û��б�
		Map ulist = new HashMap();
		application = event.getServletContext();
		application.setAttribute("ulist", ulist);
		
	}

	//新建一个会话时候触发也可以说是客户端第一次和服务器交互时候触发
	public void sessionCreated(HttpSessionEvent event) {
	}

	//销毁会话的时候  一般来说只有某个按钮触发进行销毁 或者配置定时销毁 
	//（ 很多文献中提到说浏览器关闭时候会销毁 但是楼主通过各种现行主流浏览器测试效果不尽如人意
	public void sessionDestroyed(HttpSessionEvent event) {
		
		HttpSession session = event.getSession();
		User user = (User)session.getAttribute("user");
		if(user != null){
			System.out.println(user.getSerial());
			Map ulist = (Map)application.getAttribute("ulist");
			UList ul = (UList)ulist.get(user.getUid());
			if(ul != null && ul.getSerial().equals(user.getSerial())){
				ulist.remove(user.getUid());
			}
		}
	}
	//在session中添加对象时触发此操作 笼统的说就是调用setAttribute这个方法时候会触发的
	public void attributeAdded(HttpSessionBindingEvent event) {
		Object obj = event.getValue();
		if(obj.getClass().getName().equals("com.beyondlife.vo.User")){
			User user = (User)obj;
			//�����û��б�ʵ��
			UList ul = new UList();
			ul.setSerial(user.getSerial());
			ul.setUid(user.getUid());
            ul.setName(user.getName());
			//����û��Ѿ���½������Ϣ���ᱻmapӳ���������ΪKEY�� Ψһ��UID
			Map ulist = (Map)application.getAttribute("ulist");
			ulist.put(user.getUid(), ul);
		}
		
	}
    //修改、删除session中添加对象时触发此操作  笼统的说就是调用 removeAttribute这个方法时候会触发的
	public void attributeRemoved(HttpSessionBindingEvent event) {
		Object obj = event.getValue();
		if(obj.getClass().getName().equals("com.beyondlife.vo.User")){
			User user = (User)obj;
			//���û�����Ϣ����
			Map ulist = (Map)application.getAttribute("ulist");
			ulist.remove(user.getUid());
		}
	}

	//在Session属性被重新设置时
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
		Object obj = event.getValue();
		if(obj.getClass().getName().equals("com.beyondlife.vo.User")){
			User user = (User)event.getSession().getAttribute("user");
			//�����û��б�ʵ��
			UList ul = new UList();
			ul.setSerial(user.getSerial());
			ul.setUid(user.getUid());
            ul.setName(user.getName());
			//�û�ԭ������Ϣ���ᱻmapӳ���������ΪKEY��Ψһ��UID
			Map ulist = (Map)application.getAttribute("ulist");
			ulist.put(user.getUid(), ul);
		}
		
	}

}
