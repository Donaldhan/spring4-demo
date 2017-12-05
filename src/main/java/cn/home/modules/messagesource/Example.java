package cn.home.modules.messagesource;

import org.springframework.context.MessageSource;

/**
 * @author donald
 * 2017年11月26日
 * 下午9:30:28
 */
public class Example {

	private MessageSource messages;

	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}

	public void execute() {
		String message = this.messages.getMessage("argument.required", new Object[] { "userDao" }, "Required", null);
		System.out.println(message);
	}

}