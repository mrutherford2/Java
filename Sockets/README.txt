Steps to compile and run the Socket Project

For Server:
1. Open Terminal
2. Change directory to the source folder of the server folder
	ex: cd /NewServer/src
3. Compile the java file first
	ex: javac newserver/SocketServer.java
4. Then run the Server
	ex: java -cp ./ newserver.SocketServer

For Client:
1. Open Terminal
2. Change directory to the source folder of the client folder
	ex: cd /SocketClient/src
3. Compile the java file first
	ex: javac socketclient/SocketClient.java
4. Then run the Client with the server IP as one of the arguments 
	ex: java -cp ./ socketclient.SocketClient 127.0.0.1
 