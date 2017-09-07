package ustc.sse.eprint.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.handler.stream.StreamIoHandler;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class MinaFileClient extends StreamIoHandler{  
	int port;
	String local;
	String filePath;
	
	public MinaFileClient(int port,String local,String filePath) {
		this.port=port;
		this.local=local;
		this.filePath=filePath;
	}
	public MinaFileClient(){
		
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
        //锟酵伙拷锟剿凤拷锟斤拷锟侥硷拷  
            File sendFile = new File(filePath);  
            FileInputStream fis = null;  
            try {  
                fis = new FileInputStream(sendFile);  
                  
            } catch (FileNotFoundException e) {  
                e.printStackTrace();  
            }  
            //锟斤拷锟斤拷锟竭筹拷锟斤拷锟斤拷执锟斤拷  
             //锟酵伙拷锟斤拷一锟姐都锟斤拷一锟斤拷锟竭筹拷实锟街硷拷锟斤拷 锟斤拷锟斤拷锟竭程筹拷  
            new IoStreamThreadWork(fis,out).start();  
            return;  
    }  
      
    public void createClienStream(MinaFileClient client){  
        /*int port = 8888;  
        String local = "192.168.40.108"; */ 
          
        NioSocketConnector connector = new NioSocketConnector();  
        /*DefaultIoFilterChainBuilder chain = connector.getFilterChain();*/  
        ObjectSerializationCodecFactory factory = new ObjectSerializationCodecFactory();  
        factory.setDecoderMaxObjectSize(Integer.MAX_VALUE);  
        factory.setEncoderMaxObjectSize(Integer.MAX_VALUE);  
        /*chain.addLast("logging", new LoggingFilter());//锟斤拷锟节达拷印锟斤拷志锟斤拷锟皆诧拷写  
*/      connector.setHandler(client);  
        ConnectFuture connectFuture = connector.connect(new InetSocketAddress(local,port));  
        connectFuture.awaitUninterruptibly();//写锟斤拷锟斤拷锟轿拷说玫锟斤拷锟斤拷锟斤拷session 锟斤拷思锟角等达拷锟斤拷锟接达拷锟斤拷锟斤拷锟�锟矫达拷锟斤拷锟斤拷锟斤拷锟斤拷锟届步锟斤拷同锟斤拷  
        //锟斤拷锟斤拷锟斤拷锟斤拷锟揭匡拷始锟斤拷锟诫法锟斤拷锟斤拷 锟斤拷态锟斤拷锟缴诧拷锟斤拷锟斤拷锟斤拷  
//      @SuppressWarnings("unused")  
//      IoSession session = connectFuture.getSession();  
//      setSession(session);  
    }  
/*    public static void main(String[] args) {  
        MinaFileClient client = new MinaFileClient();  
        client.createClienStream();  
    }  */
}