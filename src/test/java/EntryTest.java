import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class EntryTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/entry_test", null, null);
  }

  @After
  public void tearDown() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM entries *;";
      con.createQuery(sql).executeUpdate();
    }
  }
  @Test
  public void Entry_instantiatesWithName_true() {
    Entry myEntry = new Entry("name", "ham", "address");
    assertEquals(true, myEntry instanceof Entry);
  }

  @Test
  public void newEntry_instantiatesWithName_String() {
    Entry myEntry = new Entry("name", "ham", "address");
    assertEquals("name", myEntry.getEntryName());
  }

  @Test
  public void newEntry_instantiatesWithPhoneNumber_String() {
    Entry myEntry = new Entry("name", "ham", "address");
    assertEquals("ham", mytest.getPhoneNumber());
    assertEquals("address", mytest.getMailingAddress());
  }

  @Test
  public void save_returnsTrueIfDescriptionsAretheSame() {
  Entry myEntry = new Entry("name", "ham", "address");
  myEntry.save();
  assertTrue(Entry.all().get(0).equals(myEntry));
}

//   @Test
//   public void save_returnsTrueIfDescriptionsAretheSame() {
//   Entry myEntry = new Entry("Mow the lawn");
//   myEntry.save();
//   assertTrue(Entry.all().get(0).equals(myEntry));
// }
  // @Test
  // public void newEntry_instantiatesWithPhoneNumber_String() {
  //   Entry myEntry = new Entry("360");
  //   assertEquals("360", myEntry.getPhoneNumber());
  // }
}
