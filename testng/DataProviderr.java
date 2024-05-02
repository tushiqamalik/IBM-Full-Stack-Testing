import org.testng.annotations.DataProvider;

public class DataProviderr {
    @DataProvider(name = "Information")
    public static Object[][] credentials(){
        return new Object[][]{
                {"Person1", "ABC", "person1@xyz.com", "9999999999", "message1"},
                {"Person2", "DEF", "person2@xyz.com", "8888888888", "message2"},
                {"Person3", "XYZ", "person3@xyz.com", "7777777777", "message3"}
        };
    }
}

