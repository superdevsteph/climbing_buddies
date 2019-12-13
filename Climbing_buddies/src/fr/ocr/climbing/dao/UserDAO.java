package fr.ocr.climbing.dao;

import java.util.List;

import fr.ocr.climbing.entity.User;
import fr.ocr.climbing.model.UserInfo;

public interface UserDAO {

	public User findUser(String id);

	public List<UserInfo> listUserInfos();

	public void saveUser(UserInfo userInfo);

	public UserInfo findUserInfo(String id);

	public void deleteUser(String id);

}