package ustc.sse.eprint.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.handler.stream.StreamIoHandler;
import org.apache.mina.transport.socket.nio.NioSocketConnector;



public class sendMessage extends StreamIoHandler {

	String filePath;
	public sendMessage(String filePath){
		this.filePath = filePath;
		
	}
	
	IoSession session;  
    public void setSession(IoSession session) {  
        this.session = session;  
    }  
    public IoSession getSession() {  
        return session;    
    }  
    
    
    
    @Override  
    protected void processStreamIo(IoSession session, InputStream in,  
            OutputStream out) {  
        //�ͻ��˷����ļ�  
            File sendFile = new File(filePath);  
            FileInputStream fis = null;  
            try {  
                fis = new FileInputStream(sendFile);  
                  
            } catch (FileNotFoundException e) {  
                e.printStackTrace();  
            }  
            //�����߳�����ִ��  
             //�ͻ���һ�㶼��һ���߳�ʵ�ּ��� �����̳߳�  
            new IoStreamThreadWork(fis,out).start();  
            return;  
    }  
    
  public void createClienStream(String Ip,int port){   
      NioSocketConnector connector = new NioSocketConnector();  
      DefaultIoFilterChainBuilder chain = connector.getFilterChain();  
      ObjectSerializationCodecFactory factory = new ObjectSerializationCodecFactory();  
      factory.setDecoderMaxObjectSize(Integer.MAX_VALUE);  
      factory.setEncoderMaxObjectSize(Integer.MAX_VALUE);  
      chain.addLast("logging", new LoggingFilter());//���ڴ�ӡ��־���Բ�д  
      connector.setHandler(new sendMessage(filePath));  
      ConnectFuture connectFuture = connector.connect(new InetSocketAddress(Ip,port));  
      connectFuture.awaitUninterruptibly();//д�����Ϊ�˵õ������session ��˼�ǵȴ����Ӵ������ �ô����������첽��ͬ��  
      
  	}  
 
	
}
