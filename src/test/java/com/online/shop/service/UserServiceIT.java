package com.online.shop.service;

import com.online.shop.ShopApp;
import com.online.shop.domain.User;
import com.online.shop.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.auditing.AuditingHandler;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import static org.mockito.Mockito.when;

/**
 * Integration tests for {@link UserService}.
 */
@SpringBootTest(classes = ShopApp.class)
@Transactional
public class UserServiceIT {

    private static final String DEFAULT_LOGIN = "johndoe";

    private static final String DEFAULT_EMAIL = "johndoe@localhost";

    private static final String DEFAULT_FIRSTNAME = "john";

    private static final String DEFAULT_LASTNAME = "doe";

    private static final String DEFAULT_IMAGEURL = "http://placehold.it/50x50";

    private static final String DEFAULT_LANGKEY = "dummy";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuditingHandler auditingHandler;

    @Mock
    private DateTimeProvider dateTimeProvider;

    private User user;

    @BeforeEach
    public void init() {
        user = new User();
        user.setLogin(DEFAULT_LOGIN);
        user.setPassword(RandomStringUtils.random(60));
        user.setActivated(true);
        user.setEmail(DEFAULT_EMAIL);
        user.setFirstName(DEFAULT_FIRSTNAME);
        user.setLastName(DEFAULT_LASTNAME);
        user.setImageUrl(DEFAULT_IMAGEURL);
        user.setLangKey(DEFAULT_LANGKEY);

        when(dateTimeProvider.getNow()).thenReturn(Optional.of(LocalDateTime.now()));
        auditingHandler.setDateTimeProvider(dateTimeProvider);
    }











}
