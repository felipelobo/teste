package test.br.lobo.jms.listener;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.lobo.jms.listener.ConsumerListener;

public class ConsumerListenerTest {
	
	private TextMessage message;
	private ApplicationContext context;
	private ConsumerListener listener;
	private String json  = "{vendorName:\"Microsofttest3\",firstName:\"BobTest3\",lastName:\"SmithTest3\",address:\"123 Main test3\",city:\"TulsaTest3\",state:\"OKTest3\",zip:\"71345Test3\",email:\"Bob@microsoft.test3\",phoneNumber:\"test-123-test3\"}";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("/spring/application-config.xml");
		listener = (ConsumerListener)context.getBean("consumerListener");
		message = createMock(TextMessage.class);
	}

	@After
	public void tearDown() throws Exception {
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void testOnMessage() throws JMSException {
		expect(message.getText()).andReturn(json);
		replay(message);
		listener.onMessage(message);
		verify(message);
	}

}
