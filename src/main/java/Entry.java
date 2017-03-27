import org.sql2o.*;
import java.util.List;

public class Entry {
  private int id;
  private String name;
  private String phoneNumber;
  private String mailingAddress;
  private String emailAddress;

  public Entry(String entryName, String phoneNumber, String mailingAddress) {
    this.name = entryName;
    this.phoneNumber = phoneNumber;
    this.mailingAddress = mailingAddress;

  }
  public static List<Entry> all() {
   String sql = "SELECT id, name FROM entries";
   try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Entry.class);
   }

   public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO entry (name) VALUES (:name)";
      con.createQuery(sql)
        .addParameter("name", this.name)
        .executeUpdate();
    }
  }


 }
 public String getEntryName() {
   return this.name;
 }

 public String getPhoneNumber() {
   return this.phoneNumber;
 }

 public String getMailingAddress() {
   return this.mailingAddress;
 }

 @Override
 public boolean equals(Object otherEntry) {
  if (!(otherEntry instanceof Entry)) {
    return false;
  } else {
    Entry newEntry = (Entry) otherEntry;
    return this.getEntryName().equals(newEntry.getEntryName());
  }
}
}
