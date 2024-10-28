package pard.server.hw5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import pard.server.hw5.user.entity.User;
import pard.server.hw5.user.repo.UserRepo;

import java.util.Optional;

@Service
@Slf4j
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    private final UserRepo userRepo;

    public PrincipalOauth2UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        String name = oAuth2User.getAttribute("name");
        String email = oAuth2User.getAttribute("email");

        // check for duplicates
        Optional<User> existingUser = userRepo.findByEmail(email);
        // 없음 저장
        if (existingUser.isEmpty()) {
            User newUser = new User(name, email);
            userRepo.save(newUser);
        }
        
        return oAuth2User;

    }
    /*@Override
    public OAuth2User loadUser (
            OAuth2UserRequest oAuth2UserRequest
    ) throws OAuth2AuthenticationException {
        log.info("google에서만 받아온 UserRequest: " + oAuth2UserRequest);
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        log.info("oauth에서 받아온 정보: " + oAuth2User.getAttributes());
        return super.loadUser(oAuth2UserRequest);
    }
     */
}
