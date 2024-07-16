package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		//소켓생성
		ServerSocket serverSocket = new ServerSocket();
		
		//바인드 ip=192.168.0.101  port=10001 여기에 프로그램구동중
		serverSocket.bind(  new InetSocketAddress("192.168.0.101", 10001)    );

		//서버시작
		System.out.println("<서버시작>");
		System.out.println("==================================================");
		
		//반복
		while(true) {
	
			System.out.println("[연결을 기다리고 있습니다.]");
			//클라이언트가 연결되면 accept()가실행되고 소켓이생긴다
			//socket은 종이컵 전화기
			Socket socket = serverSocket.accept(); 
			
			Thread thread =  new ServerThread(socket);
			thread.start();
			
		}
		
		/*
		System.out.println("=====================================");
		System.out.println("<서버 종료>");
		
		//닫기
		
		br.close();
		bw.close();
		socket.close();
		serverSocket.close();
		*/
	}

}
