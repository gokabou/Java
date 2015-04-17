import java.io.*;
import java.net.URL;
import java.net.HttpURLConnection;

public class Client {
	public static void main(String[] args) {
		URL url = new URL("http://localhost:8080/hello/myresource");
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();

		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "text/plain");

		if (connection.getResponseCode() != 200) {
			throw new RuntimeException("Operation failed: "
					+ connection.getResponseCode());
		}

		System.out.println("Content-Type: " + connection.getContentType());

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(connection.getInputStream()));

		String line = reader.readLine();

		while (line != null) {
			System.out.println(line);
			line = reader.readLine();
		}

		connection.disconnect();
	}
}
