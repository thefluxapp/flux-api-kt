package flux.app.api.repositories;

// import org.jooq.DSLContext;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {
  // private final DSLContext dslContext;

  // @Autowired
  // public UserRepo(DSLContext dslContext) {
  // this.dslContext = dslContext;
  // }

  public void createWithRandomData() {
    System.out.println("USER REPO CREATE");
  }
}
