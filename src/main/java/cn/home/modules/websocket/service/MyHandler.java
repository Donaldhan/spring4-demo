package cn.home.modules.websocket.service;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class MyHandler implements WebSocketHandler {

	@Override
	public void afterConnectionClosed(WebSocketSession websocketsession, CloseStatus closestatus) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterConnectionEstablished(WebSocketSession websocketsession) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMessage(WebSocketSession websocketsession, WebSocketMessage<?> websocketmessage)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleTransportError(WebSocketSession websocketsession, Throwable throwable) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

}
