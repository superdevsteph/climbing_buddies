package fr.ocr.climbing.dao;

import java.util.List;

import fr.ocr.climbing.entity.User;
import fr.ocr.climbing.model.UserInfo;

public interface UserDAO {

	public User findUser(int id);

	public List<UserInfo> listUserInfos();

	public void saveUser(UserInfo userInfo);

	public UserInfo findUserInfo(int id);

	public void deleteUser(int id);

}