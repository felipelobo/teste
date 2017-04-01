/**
 * 
 */
package br.lobo.jms.listener;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.stereotype.Component;

/**
 * @author Felipe
 *
 */
@Component
public class ConsumerListener implements MessageListener {

	/* (non-Javadoc)
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	public void onMessage(Message arg0) {
		System.out.println("In onMessage()");

	}

}
