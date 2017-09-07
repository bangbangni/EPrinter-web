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
        //客户端发送文件  
            File sendFile = new File(filePath);  
            FileInputStream fis = null;  
            try {  
                fis = new FileInputStream(sendFile);  
                  
            } catch (FileNotFoundException e) {  
                e.printStackTrace();  
            }  
            //放入线程让其执行  
             //客户端一般都用一个线程实现即可 不用线程池  
            new IoStreamThreadWork(fis,out).start();  
            return;  
    }  
    
  public void createClienStream(String Ip,int port){   
      NioSocketConnector connector = new NioSocketConnector();  
      DefaultIoFilterChainBuilder chain = connector.getFilterChain();  
      ObjectSerializationCodecFactory factory = new ObjectSerializationCodecFactory();  
      factory.setDecoderMaxObjectSize(Integer.MAX_VALUE);  
      factory.setEncoderMaxObjectSize(Integer.MAX_VALUE);  
      chain.addLast("logging", new LoggingFilter());//用于打印日志可以不写  
      connector.setHandler(new sendMessage(filePath));  
      ConnectFuture connectFuture = connector.connect(new InetSocketAddress(Ip,port));  
      connectFuture.awaitUninterruptibly();//写上这句为了得到下面的session 意思是等待连接创建完成 让创建连接由异步变同步  
      
  	}  
 
	
}
