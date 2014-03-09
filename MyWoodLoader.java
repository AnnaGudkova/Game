import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class MyWoodLoader implements WoodLoader {
	
	public Wood Load(byte[] stream) throws IOException, CodeException {
		Wood world;
		ByteArrayInputStream reader= new ByteArrayInputStream(stream);
		File file = new File("world.txt");
			try {
				Scanner scanner = new Scanner(
						new InputStreamReader(System.in));
			int readValue=reader.read();
			 ByteArrayOutputStream outstream = new  ByteArrayOutputStream();
			try { 
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(outstream,"cp866"));
				try {
					while (readValue>=0) {
						writer.write(readValue);
						readValue=reader.read();
					}
				} finally	{
					writer.close();	
				}
			}
			finally	{
				outstream.close();
			}
		}
		catch (IOException ex) {
			throw new CodeException("Input correct arguments!");
		} finally	{
		reader.close();	
		}
			return world;
	}

	
}

