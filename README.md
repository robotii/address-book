# Address Book Example

## Running the application

Maven is used for the build process. To package as a jar file, run the command below

```bash
mvn package
```

To execute, run the following

```bash
java -jar target/addressbook-1.0.0.jar
```

The output should be simiar to the following

```
~/projects/addressbook 11:21 $ java -jar target/addressbook-1.0.0.jar
Number of Males present in AddressBook = 3
Locating oldest member...
AddressEntry { name: Wes Jackson, gender: Male, birthday: 1974-08-14T00:00+01:00[Europe/London]}
How many days older is Bill than Paul?
2862
```