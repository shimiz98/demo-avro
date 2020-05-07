package study.avro;

import java.io.File;
import java.io.IOException;

import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import com.example.avro.User;

public class UserWriteMain {
	public static void main(String[] args) throws IOException {
		User user1 = new User();
		user1.setName("Alyssa");
		user1.setFavoriteNumber(256);

		User user2 = new User();
		user2.setName("Bob");
		user2.setFavoriteNumber(512);

		User user3 = new User();
		user3.setName("Chris");
		user3.setFavoriteNumber(666);

		DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(User.class);
		DataFileWriter<User> dataFileWriter = new DataFileWriter<User>(userDatumWriter);
		dataFileWriter.create(user1.getSchema(), new File("users.avro"));
		dataFileWriter.append(user1);
		dataFileWriter.append(user2);
		dataFileWriter.append(user3);
		dataFileWriter.close();

	}
}
