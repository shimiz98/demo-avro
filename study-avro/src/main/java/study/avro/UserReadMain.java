package study.avro;

import java.io.File;
import java.io.IOException;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;

import com.example.avro.User;

public class UserReadMain {
	public static void main(String[] args) throws IOException {
		File file = new File("users.avro");

		// Deserialize Users from disk
		DatumReader<User> userDatumReader = new SpecificDatumReader<User>(User.class);
		try (DataFileReader<User> dataFileReader = new DataFileReader<User>(file, userDatumReader)) {
			User user = null;
			while (dataFileReader.hasNext()) {
				// Reuse user object by passing it to next(). This saves us from
				// allocating and garbage collecting many objects for files with
				// many items.
				user = dataFileReader.next(user);
				System.out.println(user);
			}
		}
	}
}
