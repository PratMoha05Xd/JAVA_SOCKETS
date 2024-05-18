package mohamed.jellal.dam.mp09.uf03.a01.server;

import mohamed.jellal.dam.mp09.uf03.a01.config.Settings;
import mohamed.jellal.dam.mp09.uf03.a01.domain.Book;
import mohamed.jellal.dam.mp09.uf03.a01.view.BookView;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnexioServer {

	private ServerSocket serverSocket;
	private Socket clientSocket;

	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;

	public void transmetre() throws IOException, ClassNotFoundException
	{
		serverSocket = new ServerSocket(Settings.PORT);

		BookView bookView = new BookView();

		while(true)
		{
			System.out.println("S:Esperant connexions de clients ...");
			clientSocket = serverSocket.accept();
			System.out.println("S:Client connectat");


			//=============================
			Book bookServidor = bookView.getBook();
			System.out.println("S: Enviem llibre al client: " + bookServidor.toString());
			objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
			objectOutputStream.writeObject(bookServidor);

			//=============================
			System.out.println("S: Esperant a que el client transmeti un arxiu ...");
			objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
			Object objecteRetornat = objectInputStream.readObject();
			Book bookClient = (Book)objecteRetornat;
			System.out.println("S: Hem rebut del client: " + bookClient.toString());


			//=============================
			objectInputStream.close();
			objectOutputStream.close();
			clientSocket.close();

		}
	}
}
