package flux.app.api.session;

import flux.app.api.models.UserModel;
import flux.app.api.repositories.UserRepo;
import reactor.core.publisher.Mono;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
  private final UserRepo userRepo;

  @Autowired
  public AuthService(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  void call() {
    userRepo.save(new UserModel(RandomStringUtils.random(12, true, true)))
        .subscribe(System.out::println);

    // System.out.println(qq);
    System.out.println("AUTH SERVICE");
  }
}
