package flux.app.api.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flux.app.api.repositories.UserRepo;

@Service
public class AuthService {
  private final UserRepo userRepo;

  @Autowired
  public AuthService(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  void call() {
    userRepo.createWithRandomData();

    System.out.println("AUTH SERVICE");
  }
}