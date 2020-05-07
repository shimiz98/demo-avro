```
java -jar ./avro-tools-1.9.2.jar compile schema src/main/resources/User.avrs src/main/gen-avro
```


```
java -jar ./avro-tools-1.9.2.jar compile schema ^
src\main\resources\DemoAvroTypesXxx.avrs ^
src\main\resources\DemoAvroTypesYyy.avrs ^
src\main\resources\DemoAvroTypes.avrs ^
src\main\gen-avro
```



* `DemoAvroTypesWriteMain` を実行したら、以下の例外が発生。
```
Exception in thread "main" org.apache.avro.file.DataFileWriter$AppendWriteException: java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Long (java.lang.String and java.lang.Long are in module java.base of loader 'bootstrap')
	at org.apache.avro.file.DataFileWriter.append(DataFileWriter.java:317)
	at study.avro.DemoAvroTypesWriteMain.main(DemoAvroTypesWriteMain.java:33)
Caused by: java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Long (java.lang.String and java.lang.Long are in module java.base of loader 'bootstrap')
	at org.apache.avro.generic.GenericDatumWriter.writeWithoutConversion(GenericDatumWriter.java:159)
	at org.apache.avro.specific.SpecificDatumWriter.writeField(SpecificDatumWriter.java:98)
	at org.apache.avro.generic.GenericDatumWriter.writeRecord(GenericDatumWriter.java:195)
	at org.apache.avro.specific.SpecificDatumWriter.writeRecord(SpecificDatumWriter.java:83)
	at org.apache.avro.generic.GenericDatumWriter.writeWithoutConversion(GenericDatumWriter.java:130)
	at org.apache.avro.specific.SpecificDatumWriter.writeField(SpecificDatumWriter.java:98)
	at org.apache.avro.generic.GenericDatumWriter.writeRecord(GenericDatumWriter.java:195)
	at org.apache.avro.specific.SpecificDatumWriter.writeRecord(SpecificDatumWriter.java:83)
	at org.apache.avro.generic.GenericDatumWriter.writeWithoutConversion(GenericDatumWriter.java:130)
	at org.apache.avro.generic.GenericDatumWriter.write(GenericDatumWriter.java:82)
	at org.apache.avro.generic.GenericDatumWriter.write(GenericDatumWriter.java:72)
	at org.apache.avro.file.DataFileWriter.append(DataFileWriter.java:314)
	... 1 more
```

* `-Dorg.apache.avro.specific.use_custom_coders=true` 付きで、`DemoAvroTypesWriteMain` を実行したら、正常終了。
  * Readは時間切れで未実装なので、正常に読み込めない可能性あり。

