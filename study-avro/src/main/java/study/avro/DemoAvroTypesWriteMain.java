package study.avro;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;

import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import com.example.avro.DemoAvroTypes;
import com.example.avro.DemoAvroTypesXxx;
import com.example.avro.DemoAvroTypesYyy;

public class DemoAvroTypesWriteMain {
	public static void main(String[] args) throws IOException {
		DemoAvroTypes types1 = new DemoAvroTypes();
		types1.setAvroBytes(ByteBuffer.allocate(0));
		types1.setAvroString("aaa");
		types1.setAvroArrayOfString(Collections.emptyList());
		types1.setAvroArrayOfInt(Collections.emptyList());
		types1.setAvroMapOfString(new HashMap<CharSequence, CharSequence>(){});
		types1.setAvroMapOfInt(new HashMap<CharSequence, Integer>(){});
		types1.setAvroXxx1(DemoAvroTypesXxx.newBuilder().setField1(false).setField2(0).setField3("").build());
		types1.setAvroXxx2(DemoAvroTypesXxx.newBuilder().setField1(true).setField2(0).setField3("").build());
		types1.setAvroYyy1(DemoAvroTypesYyy.newBuilder().setField1(true).setField2(0).setField3("").build());

		DatumWriter<DemoAvroTypes> userDatumWriter = new SpecificDatumWriter<DemoAvroTypes>(DemoAvroTypes.class);
		DataFileWriter<DemoAvroTypes> dataFileWriter = new DataFileWriter<DemoAvroTypes>(userDatumWriter);
		dataFileWriter.create(types1.getSchema(), new File("DemoAvroTypes.avro"));
		dataFileWriter.append(types1);
		dataFileWriter.close();

	}
}
