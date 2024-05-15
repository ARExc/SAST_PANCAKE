package sast.pancake.sast_pancake.service;

import sast.pancake.sast_pancake.pojo.response.PersonalException.LoginException;

public interface UserService {
    String login(String username, String password) throws LoginException;
}
